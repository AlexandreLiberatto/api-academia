package com.academia.academia.controller;

import com.academia.academia.dto.AlunoDTO;
import com.academia.academia.dto.ExerciciosDTO;
import com.academia.academia.dto.ProfessorDTO;
import com.academia.academia.service.ProfessorService;
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
import java.util.List;

@RestController
@RequestMapping("/professor")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearer-key")
public class ProfessorController {

    private final ProfessorService professorService;

    @PostMapping
    public ResponseEntity<ProfessorDTO> cadastrarProfessor(@RequestBody @Valid ProfessorDTO dto, UriComponentsBuilder uribuilder) {
        ProfessorDTO professorDTO = professorService.criarProfessor(dto);
        URI endereco = uribuilder.path("/professor/{id}").buildAndExpand(professorDTO.getId()).toUri();
        return ResponseEntity.created(endereco).body(professorDTO);
    }

    @GetMapping
    public ResponseEntity<Page<ProfessorDTO>> buscarProfessores(@PageableDefault(size = 10) Pageable paginacao) {
        Page<ProfessorDTO> professor = professorService.buscarProfessores(paginacao);
        return ResponseEntity.ok(professor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorDTO> buscarProfessorPorId(@PathVariable @NotNull Integer id){
        ProfessorDTO professorDTO = professorService.buscarProfessorPorId(id);
        return ResponseEntity.ok(professorDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorDTO> atualizarProfessor(@PathVariable @NotNull Integer id, @RequestBody @Valid ProfessorDTO dto){
        ProfessorDTO professorAtualizado = professorService.atualizarProfessor(id, dto);
        return ResponseEntity.ok(professorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProfessor(@PathVariable @NotNull Integer id){
        professorService.excluirProfessor(id);
        return ResponseEntity.noContent().build();
    }
}
