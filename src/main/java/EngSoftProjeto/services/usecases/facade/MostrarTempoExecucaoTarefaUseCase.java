package EngSoftProjeto.services.usecases.facade;

import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.Repositories.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MostrarTempoExecucaoTarefaUseCase {

    private final TarefaRepository tarefaRepository;

    public MostrarTempoExecucaoTarefaUseCase(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public Float tempoExecucaoTarefa(Long tarefaId){
        Optional<Tarefa>optionalTarefa=tarefaRepository.findById(tarefaId);

       if(optionalTarefa.isPresent()){
           return optionalTarefa.get().getDuracao();
       }
       return Float.NaN;
    }
}
