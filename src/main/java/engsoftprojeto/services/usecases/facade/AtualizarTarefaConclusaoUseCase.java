package engsoftprojeto.services.usecases.facade;


import engsoftprojeto.models.Tarefa;
import engsoftprojeto.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AtualizarTarefaConclusaoUseCase {

    private final TarefaRepository tarefaRepository;
    @Autowired
    public AtualizarTarefaConclusaoUseCase(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public Optional<Tarefa> atualizaTarefa(Long tarefaId) {
        Optional<Tarefa> optionalTarefa= tarefaRepository.findById(tarefaId);
        if(optionalTarefa.isPresent()){
            Tarefa tarefa=optionalTarefa.get();
            if(tarefa.getConcluida()==null|| !tarefa.getConcluida()) {
                tarefa.setConcluida(true);
                tarefaRepository.save(tarefa);
                return Optional.of(tarefa);
            }
        }
       return Optional.empty();
    }

}
