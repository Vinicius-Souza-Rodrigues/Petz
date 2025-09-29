CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE usuario (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    email TEXT UNIQUE NOT NULL,
    telefone TEXT,
    celular TEXT,
    senha_hash TEXT NOT NULL,
    tipo_usuario String NOT NULL,
    creiado_em TIMESTAMP WITH TIME ZONE DEFAULT now()
);

CREATE TABLE usuario_fisico (
    usuario_id UUID PRIMARY KEY REFERENCES usuario(id) ON DELETE CASCADE,
    nome TEXT NOT NULL,
    genero TEXT NOT NULL,
    data_nascimento TEXT NOT NULL,
    cpf CHAR(11) UNIQUE NOT NULL
);

CREATE TABLE usuario_juridico (
    usuario_id UUID PRIMARY KEY REFERENCES usuario(id) ON DELETE CASCADE,
    razao_social TEXT NOT NULL,
    nome_contato TEXT NOT NULL,
    cnpj CHAR(14) UNIQUE NOT NULL
);
