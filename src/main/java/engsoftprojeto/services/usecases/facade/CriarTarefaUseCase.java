package engsoftprojeto.services.usecases.facade;


import engsoftprojeto.models.Tarefa;
import engsoftprojeto.repositories.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CriarTarefaUseCase {

    private final TarefaRepository tarefaRepository;

    public CriarTarefaUseCase(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public Optional<Tarefa> criarTarefa(Tarefa tarefa) {
        Optional<Tarefa> optionalTarefa = tarefaRepository.findByNome(tarefa.getNome());
        if (optionalTarefa.isEmpty()) {
            tarefaRepository.save(tarefa);
            return Optional.of(tarefa);
        }
    return Optional.empty();
    }
}
