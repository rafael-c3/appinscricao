CREATE TABLE tb_pessoas (
    id BINARY(16) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(15) NOT NULL,

    PRIMARY KEY (id),
    UNIQUE KEY uk_pessoa_email (email)
);
