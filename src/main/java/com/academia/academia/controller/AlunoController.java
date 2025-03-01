package com.academia.academia.controller;

import com.academia.academia.dto.AlunoDTO;
import com.academia.academia.service.AlunoService;
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
@RequestMapping("/aluno")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearer-key")
public class AlunoController {
    private final AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoDTO> cadastrarAluno(@RequestBody @Valid AlunoDTO dto, UriComponentsBuilder uribuilder) {
        AlunoDTO alunoDTO = alunoService.criarAluno(dto);
        URI endereco = uribuilder.path("/aluno/{id}").buildAndExpand(alunoDTO.getId()).toUri();
        return ResponseEntity.created(endereco).body(alunoDTO);
    }

    @GetMapping
    public ResponseEntity<Page<AlunoDTO>> buscarAlunos(@PageableDefault(size = 10)Pageable paginacao) {
        Page<AlunoDTO> alunos = alunoService.buscarAlunos(paginacao);
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> buscarAlunoPorId(@PathVariable @NotNull Integer id){
        AlunoDTO alunoDTO = alunoService.buscarAlunoPorId(id);
        return ResponseEntity.ok(alunoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoDTO> atualizarAluno(@PathVariable @NotNull Integer id, @RequestBody @Valid AlunoDTO dto){
        AlunoDTO alunoAtualizado = alunoService.atualizarAluno(id, dto);
        return ResponseEntity.ok(alunoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAluno(@PathVariable @NotNull Integer id){
        alunoService.excluirAluno(id);
        return ResponseEntity.noContent().build();
    }
}