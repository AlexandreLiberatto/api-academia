package com.academia.academia.model;

import com.academia.academia.enun.GrupoMuscular;
import com.academia.academia.enun.NomeExercico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exercicios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exercicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private String equipamento;
    @Enumerated(EnumType.STRING)
    private NomeExercico nomeExercicio;
    @Enumerated(EnumType.STRING)
    private GrupoMuscular grupoMuscular;
}
