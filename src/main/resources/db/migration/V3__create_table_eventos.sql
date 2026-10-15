CREATE TABLE tb_eventos (
    id BINARY(16) NOT NULL,
    nome VARCHAR(150) NOT NULL,
    data_hora_evento DATETIME(6) NOT NULL,
    local VARCHAR(200) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    estado VARCHAR(2) NOT NULL,
    qtde INT NOT NULL,

    PRIMARY KEY (id)
);