package com.academia.academia.model;

import com.academia.academia.enun.HorarioDisponivel;
import com.academia.academia.enun.Especialidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "professor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Enumerated(EnumType.STRING)
    private HorarioDisponivel horarioDisponivel;
}
