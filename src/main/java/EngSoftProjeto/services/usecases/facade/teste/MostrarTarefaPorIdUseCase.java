package EngSoftProjeto.services.usecases.facade.teste;


import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.Repositories.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MostrarTarefaPorIdUseCase {
    private final TarefaRepository tarefaRepository;


    public MostrarTarefaPorIdUseCase(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public Optional<Tarefa> findById(Long id) {
        return tarefaRepository.findById(id);
    }

}
