CREATE TABLE pessoa (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
    logradouro VARCHAR(30),
    numero VARCHAR(30),
    complemento VARCHAR(30),
    bairro VARCHAR(30),
    cep VARCHAR(30),
    cidade VARCHAR(30),
    estado VARCHAR(30),
    ativo BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Guilherme', 'Rua ABC', '123', 'Perto da uf', 'Centro', '5842312', 'Campina Gretzky', 'PB', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Chico', 'Rua ABCD', '1234', 'Perto da ufpb', 'Candelaria', '5882812', 'Sousa', 'PB', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Chica', 'Rua ABCDE', '12345', 'Perto da ufrn', 'Malvinas', '5849412', 'Pombal', 'PB', true);
