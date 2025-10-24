CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE usuarios (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    email TEXT UNIQUE NOT NULL,
    telefone TEXT,
    celular TEXT,
    senha TEXT NOT NULL,
    tipo_usuario TEXT NOT NULL,
    criado_em TIMESTAMP WITH TIME ZONE DEFAULT now()
);

CREATE TABLE user_fisico (
    usuario_id UUID PRIMARY KEY REFERENCES usuarios(id) ON DELETE CASCADE,
    nome TEXT NOT NULL,
    genero TEXT NOT NULL,
    data_nascimento DATE NOT NULL,
    cpf CHAR(11) UNIQUE NOT NULL
);

CREATE TABLE user_juridico (
    usuario_id UUID PRIMARY KEY REFERENCES usuarios(id) ON DELETE CASCADE,
    razao_social TEXT NOT NULL,
    nome_contato TEXT NOT NULL,
    cnpj CHAR(14) UNIQUE NOT NULL
);

CREATE TABLE item (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10,2) NOT NULL
);

CREATE TABLE especificacao (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE item_especificacao (
    id SERIAL PRIMARY KEY,
    item_id INT NOT NULL REFERENCES item(id) ON DELETE CASCADE,
    especificacao_id INT NOT NULL REFERENCES especificacao(id) ON DELETE CASCADE,
    valor VARCHAR(255) NOT NULL
);
