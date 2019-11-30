CREATE TABLE usuario (
	codigo BIGINT(20) PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	senha VARCHAR(150) NOT NULL
)	ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO usuario (codigo, nome, email, senha) values (1, 'admin', 'admin@admin.com', '$2a$10$kesM69UIOJw5q6CDAfYy9eivkoyIs3ZPRuqaHn76nfW12uOcYUaMO');