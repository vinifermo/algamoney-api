CREATE TABLE categoria (
codigo bigint(20) PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(50) NOT NULL
);

INSERT INTO categoria (nome) values ('lazer');
INSERT INTO categoria (nome) values ('Alimentação');
INSERT INTO categoria (nome) values ('Supermercado');
INSERT INTO categoria (nome) values ('Farmácia');
INSERT INTO categoria (nome) values ('Outros');

