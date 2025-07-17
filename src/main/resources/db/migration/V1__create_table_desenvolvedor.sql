CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE "colmeia"."desenvolvedor" (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome VARCHAR(100) NOT NULL UNIQUE,
    dataFundacao TIMESTAMP NOT NULL,
    website VARCHAR(100) NOT NULL UNIQUE,
    sede VARCHAR(100) NOT NULL,
    data_criacao TIMESTAMP NOT NULL DEFAULT (now()),
    data_atualizacao TIMESTAMP NOT NULL DEFAULT (now())
);