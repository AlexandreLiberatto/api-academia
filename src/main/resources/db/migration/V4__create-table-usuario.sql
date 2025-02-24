-- V4__create-table-usuário.sql

CREATE TABLE usuario (

    id SERIAL PRIMARY KEY,
    login VARCHAR(100) NOT NULL,
    password VARCHAR(255) UNIQUE NOT NULL

);