CREATE TABLE "colmeia"."genero" (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome VARCHAR(50) NOT NULL UNIQUE,
    data_criacao TIMESTAMP NOT NULL DEFAULT (now()),
    data_atualizacao TIMESTAMP NOT NULL DEFAULT (now())
);