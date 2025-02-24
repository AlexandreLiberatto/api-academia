-- V1__create_table_aluno.sql

CREATE TABLE IF NOT EXISTS Aluno (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    data_nascimento DATE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefone VARCHAR(20),
    plano VARCHAR(50) NOT NULL
)