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
    
);

INSERT INTO funcionario (nome, login, senha, admin) VALUES("Admin", "admin", "Senai123", true);