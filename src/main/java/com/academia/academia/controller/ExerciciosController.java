package com.academia.academia.controller;

import com.academia.academia.dto.ExerciciosDTO;
import com.academia.academia.service.ExerciciosService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/exercicios")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearer-key")
public class ExerciciosController {

    private final ExerciciosService exerciciosService;

    @PostMapping
    public ResponseEntity<ExerciciosDTO> cadastrarExercicios(@RequestBody @Valid ExerciciosDTO dto, UriComponentsBuilder uribuilder) {
        ExerciciosDTO exerciciosDTO = exerciciosService.criarExercicios(dto);
        URI endereco = uribuilder.path("/exercicios/{id}").buildAndExpand(exerciciosDTO.getId()).toUri();
        return ResponseEntity.created(endereco).body(exerciciosDTO);
    }

    @GetMapping
    public ResponseEntity<Page<ExerciciosDTO>> buscarExercicios(@PageableDefault(size = 10) Pageable paginacao) {
        Page<ExerciciosDTO> exercicios = exerciciosService.buscarExercicios(paginacao);
        return ResponseEntity.ok(exercicios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExerciciosDTO> buscarExercicioPorId(@PathVariable @NotNull Integer id){
        ExerciciosDTO exerciciosDTO = exerciciosService.buscarExercicioPorId(id);
        return ResponseEntity.ok(exerciciosDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExerciciosDTO> atualizarExercicio(@PathVariable @NotNull Integer id, @RequestBody @Valid ExerciciosDTO dto){
        ExerciciosDTO exercicioAtualizado = exerciciosService.atualizarExercicio(id, dto);
        return ResponseEntity.ok(exercicioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirExercicio(@PathVariable @NotNull Integer id){
        exerciciosService.excluirExercicio(id);
        return ResponseEntity.noContent().build();
    }
}
