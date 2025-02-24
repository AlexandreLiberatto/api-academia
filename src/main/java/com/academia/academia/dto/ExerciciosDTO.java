package com.academia.academia.dto;

import com.academia.academia.enun.GrupoMuscular;
import com.academia.academia.enun.NomeExercico;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExerciciosDTO {

    private Integer id;
    @NotBlank
    private String descricao;
    private String equipamento;
    private NomeExercico nomeExercicio;
    private GrupoMuscular grupoMuscular;
}
