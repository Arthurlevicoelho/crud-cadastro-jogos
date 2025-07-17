CREATE TABLE "colmeia"."console" (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome VARCHAR(100) NOT NULL UNIQUE,
    dataLancamento TIMESTAMP,
    empresa VARCHAR(100) NOT NULL UNIQUE,
    data_criacao TIMESTAMP NOT NULL DEFAULT (now()),
    data_atualizacao TIMESTAMP NOT NULL DEFAULT (now())
);