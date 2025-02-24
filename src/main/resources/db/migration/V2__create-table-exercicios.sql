-- V1__create_exercicios_aluno.sql

CREATE TABLE exercicios (
    id SERIAL PRIMARY KEY,
    descricao TEXT NOT NULL,
    equipamento VARCHAR(100),
    nome_exercicio VARCHAR(50) NOT NULL,
    grupo_muscular VARCHAR(50) NOT NULL
);
