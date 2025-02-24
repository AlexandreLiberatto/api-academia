package com.academia.academia.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosUsuarioCadastro {

    private Integer id;
    @NotBlank
    private String login;
    @NotBlank
    private String password;
}
