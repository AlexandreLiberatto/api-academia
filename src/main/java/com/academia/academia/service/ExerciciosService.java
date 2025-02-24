package com.academia.academia.service;


import com.academia.academia.dto.ExerciciosDTO;
import com.academia.academia.model.Exercicios;
import com.academia.academia.repository.ExerciciosRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExerciciosService {

    private final ExerciciosRepository exerciciosRepository;

    private final ModelMapper modelMapper;

    public ExerciciosDTO criarExercicios(ExerciciosDTO dto) {
        Exercicios exercicios = modelMapper.map(dto, Exercicios.class);
        exerciciosRepository.save(exercicios);

        return modelMapper.map(exercicios, ExerciciosDTO.class);
    }

    public Page<ExerciciosDTO> buscarExercicios(Pageable paginacao) {
        return exerciciosRepository
                .findAll(paginacao)
                .map(p -> modelMapper.map(p, ExerciciosDTO.class));
    }

    public ExerciciosDTO buscarExercicioPorId(Integer id){
        Exercicios exercicios = exerciciosRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        return modelMapper.map(exercicios, ExerciciosDTO.class);
    }

    public ExerciciosDTO atualizarExercicio(Integer id, ExerciciosDTO dto) {
        Exercicios exercicios = modelMapper.map(dto, Exercicios.class);
        exercicios.setId(id);
        exercicios = exerciciosRepository.save(exercicios);
        return modelMapper.map(exercicios, ExerciciosDTO.class);
    }

    public void excluirExercicio( Integer id) {
        exerciciosRepository.deleteById(id);
    }
}
