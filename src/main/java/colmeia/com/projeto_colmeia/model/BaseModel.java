package colmeia.com.projeto_colmeia.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel {

    @Id
    @GeneratedValue(generator = "UUID")
    UUID id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @PrePersist
    protected void onCreate() {
        dataCriacao = LocalDateTime.now();
        System.out.println(dataCriacao);
        dataAtualizacao = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        dataAtualizacao = LocalDateTime.now();
    }
}

