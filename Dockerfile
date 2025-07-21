# ========================================================================
# ESTÁGIO 1: Build da Aplicação com Maven e JDK 21
#
# Este estágio usa uma imagem completa do JDK para compilar a aplicação
# Java e gerar o artefato .jar. Nenhum dos componentes deste estágio
# fará parte da imagem final.
# ========================================================================
FROM eclipse-temurin:21-jdk-jammy AS builder

LABEL stage="builder"

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia os arquivos de definição do Maven para o contêiner.
# Isso otimiza o cache de camadas do Docker. As dependências só serão
# baixadas novamente se o pom.xml mudar.
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Baixa as dependências do projeto para otimizar builds futuros
RUN ./mvnw dependency:go-offline

# Copia o restante do código-fonte da aplicação
COPY src ./src

# Compila a aplicação, gera o pacote .jar e pula os testes
RUN ./mvnw package -DskipTests


# ========================================================================
# ESTÁGIO 2: Criação da Imagem Final de Produção
#
# Este estágio usa uma imagem JRE mínima e copia apenas o artefato .jar
# gerado no estágio anterior. Ele também implementa práticas de segurança
# cruciais, como a execução com um usuário não-privilegiado.
# ========================================================================
# Para builds de produção críticos, considere fixar a versão da imagem
# usando seu digest SHA256 para garantir builds 100% reprodutíveis.
# Ex: FROM eclipse-temurin:21-jre-jammy@sha256:xxxxxxxxxxxx
FROM eclipse-temurin:21-jre-jammy AS production

LABEL stage="production"

# Define o diretório de trabalho
WORKDIR /app

# [SEGURANÇA] Cria um grupo de sistema e um usuário de sistema dedicados,
# sem privilégios, para executar a aplicação.
RUN groupadd --system appgroup && useradd --system --gid appgroup appuser

# Define um argumento para o nome do JAR para facilitar a manutenção
ARG JAR_FILE=target/*.jar

# [SEGURANÇA] Copia o .jar gerado no estágio 'builder' e define a
# propriedade do arquivo para o novo usuário não-privilegiado.
# Usar --chown é mais eficiente que um comando RUN 'chown' separado.
COPY --from=builder --chown=appuser:appgroup /app/${JAR_FILE} application.jar

# [SEGURANÇA] Muda o contexto de execução para o usuário não-privilegiado.
# Todos os comandos a seguir serão executados como 'appuser'.
USER appuser

# Expõe a porta em que a aplicação Spring Boot roda (padrão 8080)
EXPOSE 8080

# [RESILIÊNCIA] Adiciona uma verificação de saúde para que o orquestrador
# de contêineres (Docker, Kubernetes) possa verificar o status da aplicação.
# Requer que o endpoint Spring Boot Actuator Health esteja habilitado.
# A imagem base 'jammy' já inclui 'curl'.
HEALTHCHECK --interval=30s --timeout=5s --start-period=15s --retries=3 \
  CMD curl -f http://localhost:8080/actuator/health || exit 1

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "application.jar"]