package com.academia.academia.dto;

import com.academia.academia.enun.Planos;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AlunoDTO {

    private Integer id;
    @NotBlank
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;
    private Planos plano;
}
