ALTER TABLE tb_pessoas
    ADD COLUMN cpf VARCHAR(15) NOT NULL,
    ADD CONSTRAINT uk_pessoa_cpf UNIQUE (cpf);
