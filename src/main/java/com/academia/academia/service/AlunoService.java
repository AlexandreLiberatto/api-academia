package com.academia.academia.service;

import com.academia.academia.dto.AlunoDTO;
import com.academia.academia.model.Aluno;
import com.academia.academia.repository.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlunoService {
    private final AlunoRepository alunoRepository;
    private final ModelMapper modelMapper;

    public AlunoDTO criarAluno(AlunoDTO dto) {
        Aluno aluno = modelMapper.map(dto, Aluno.class);
        alunoRepository.save(aluno);
        return modelMapper.map(aluno, AlunoDTO.class);
    }

    public Page<AlunoDTO> buscarAlunos(Pageable paginacao) {
        return alunoRepository
                .findAll(paginacao)
                .map(p -> modelMapper.map(p, AlunoDTO.class));
    }

    public AlunoDTO buscarAlunoPorId(Integer id){
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        return modelMapper.map(aluno, AlunoDTO.class);
    }

    public AlunoDTO atualizarAluno(Integer id, AlunoDTO dto) {
        Aluno aluno = modelMapper.map(dto, Aluno.class);
        aluno.setId(id);
        aluno = alunoRepository.save(aluno);
        return modelMapper.map(aluno, AlunoDTO.class);
    }

    public void excluirAluno( Integer id) {
        alunoRepository.deleteById(id);
    }
}