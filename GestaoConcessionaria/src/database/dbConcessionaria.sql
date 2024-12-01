CREATE DATABASE IF NOT EXISTS dbConcessionaria;
USE dbConcessionaria;

CREATE TABLE funcionario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    login VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    salario DECIMAL(10,2) DEFAULT 0,
    admin BOOLEAN DEFAULT false
);

CREATE TABLE cliente(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    dataNascimento DATE NOT NULL,
    telefone VARCHAR(16),
    genero VARCHAR(20)
);

CREATE TABLE veiculo (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    placa VARCHAR(7) NOT NULL,
    marca VARCHAR(255) NOT NULL,
    modelo VARCHAR(255) NOT NULL,
    ano INTEGER(4) NOT NULL,
    cor VARCHAR(255) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    anunciado BOOLEAN NOT NULL DEFAULT FALSE,
    id_cliente BIGINT,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);

CREATE TABLE compra(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    parcelas INT NOT NULL,
    dataCompra DATE not null,
    id_cliente BIGINT NOT NULL,
    id_veiculo BIGINT NOT NULL,
    id_funcionario BIGINT NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id),
    FOREIGN KEY (id_veiculo) REFERENCES veiculo(id),
    FOREIGN KEY (id_funcionario) REFERENCES funcionario(id)
);

INSERT INTO funcionario (nome, login, senha, admin) VALUES("Admin", "admin", "Senai123", true);
INSERT INTO veiculo (placa, marca, modelo, ano, cor, preco) VALUES ("DRH9205", "Volkswagen", "Gol", "2005", "Preto", 21000);