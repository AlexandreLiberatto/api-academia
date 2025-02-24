package com.academia.academia.dto;

import com.academia.academia.enun.Especialidade;
import com.academia.academia.enun.HorarioDisponivel;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessorDTO {

    private Integer id;
    @NotBlank
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Especialidade especialidade;
    private HorarioDisponivel horarioDisponivel;
}
