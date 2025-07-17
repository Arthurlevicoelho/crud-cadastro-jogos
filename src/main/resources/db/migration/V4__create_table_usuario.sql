CREATE TABLE "colmeia"."usuario" (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    telefone VARCHAR(20),
    cpf VARCHAR(14) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    data_criacao TIMESTAMP NOT NULL DEFAULT (now()),
    data_atualizacao TIMESTAMP NOT NULL DEFAULT (now())
);