CREATE TABLE "colmeia"."jogo" (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome VARCHAR(255) NOT NULL,
    descricao TEXT NOT NULL,
    data_lancamento DATE,
    website VARCHAR(255),
    url_capa VARCHAR(255),
    desenvolvedor_id UUID NOT NULL,
    genero_id UUID NOT NULL,
    data_criacao TIMESTAMP NOT NULL DEFAULT (now()),
    data_atualizacao TIMESTAMP NOT NULL DEFAULT (now())
);

ALTER TABLE "colmeia"."jogo"
    ADD CONSTRAINT fk_jogo_desenvolvedor
        FOREIGN KEY (desenvolvedor_id)
            REFERENCES "colmeia"."desenvolvedor" (id)
            ON DELETE RESTRICT;

ALTER TABLE "colmeia"."jogo"
    ADD CONSTRAINT fk_jogo_genero
        FOREIGN KEY (genero_id)
            REFERENCES "colmeia"."genero" (id)
            ON DELETE RESTRICT;