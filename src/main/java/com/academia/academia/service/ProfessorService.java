package com.academia.academia.service;

import com.academia.academia.dto.AlunoDTO;
import com.academia.academia.dto.ExerciciosDTO;
import com.academia.academia.dto.ProfessorDTO;
import com.academia.academia.model.Aluno;
import com.academia.academia.model.Professor;
import com.academia.academia.repository.ProfessorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    private final ModelMapper modelMapper;

    public ProfessorDTO criarProfessor(ProfessorDTO dto) {
        Professor professor = modelMapper.map(dto, Professor.class);
        professorRepository.save(professor);

        return modelMapper.map(professor, ProfessorDTO.class);
    }

    public Page<ProfessorDTO> buscarProfessores(Pageable paginacao) {
        return professorRepository
                .findAll(paginacao)
                .map(p -> modelMapper.map(p, ProfessorDTO.class));
    }

    public ProfessorDTO buscarProfessorPorId(Integer id){
        Professor professor = professorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        return modelMapper.map(professor, ProfessorDTO.class);
    }

    public ProfessorDTO atualizarProfessor(Integer id, ProfessorDTO dto) {
        Professor professor = modelMapper.map(dto, Professor.class);
        professor.setId(id);
        professor = professorRepository.save(professor);
        return modelMapper.map(professor, ProfessorDTO.class);
    }

    public void excluirProfessor( Integer id) {
        professorRepository.deleteById(id);
    }
}
