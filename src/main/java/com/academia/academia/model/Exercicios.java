package com.academia.academia.model;

import com.academia.academia.enun.GrupoMuscular;
import com.academia.academia.enun.NomeExercico;
import jakarta.persistence.*;

@Entity
@Table(name = "exercicios")
public class Exercicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descricao;
    private String equipamento;
    @Enumerated(EnumType.STRING)
    private NomeExercico nomeExercicio;
    @Enumerated(EnumType.STRING)
    private GrupoMuscular grupoMuscular;
}
