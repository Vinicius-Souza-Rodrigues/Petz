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
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10,2) NOT NULL
);

CREATE TABLE especificacao (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    nome VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE item_especificacao (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    item_id UUID NOT NULL REFERENCES item(id) ON DELETE CASCADE,
    especificacao_id UUID NOT NULL REFERENCES especificacao(id) ON DELETE CASCADE,
    valor VARCHAR(255) NOT NULL
);

CREATE TABLE animais (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),

    nome VARCHAR(100) NOT NULL,
    usuario_id UUID NOT NULL REFERENCES usuarios(id) ON DELETE CASCADE,

    sexo VARCHAR(100) NOT NULL,
    porte VARCHAR(100) NOT NULL,

    peso VARCHAR(100) NOT NULL,
    idade VARCHAR(100) NOT NULL,
    microchip VARCHAR(100) NOT NULL,
    especie VARCHAR(100) NOT NULL,
    raca VARCHAR(100) NOT NULL,
    localizacao VARCHAR(100) NOT NULL,
    descricao VARCHAR(100) NOT NULL
);

CREATE TABLE favoritos_animal (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),

    usuario_id UUID NOT NULL REFERENCES usuarios(id) ON DELETE CASCADE,
    animais_id UUID NOT NULL REFERENCES animais(id) ON DELETE CASCADE,
    UNIQUE (usuario_id, animais_id)
);

CREATE TABLE favoritos_item (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),

    usuario_id UUID NOT NULL REFERENCES usuarios(id) ON DELETE CASCADE,
    itens_id UUID NOT NULL REFERENCES item(id) ON DELETE CASCADE,
    UNIQUE (usuario_id, itens_id)

);
