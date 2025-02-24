-- V3__create-table-professor.sql

CREATE TABLE professor (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefone VARCHAR(20),
    especialidade VARCHAR(50) NOT NULL,
    horario_disponivel VARCHAR(50) NOT NULL
);
