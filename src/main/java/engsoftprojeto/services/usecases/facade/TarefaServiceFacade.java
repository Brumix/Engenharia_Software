package engsoftprojeto.services.usecases.facade;

import engsoftprojeto.models.Funcionario;
import engsoftprojeto.models.Tarefa;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TarefaServiceFacade implements TarefaServiceFacadeI {
    private final AdicionarFuncionarioTarefaUseCase adicionarFuncionarioTarefaUseCase;
    private final AtualizarTarefaConclusaoUseCase atualizarTarefaConclusaoUseCase;
    private final CriarTarefaUseCase criarTarefaUseCase;
    private final MostrarTempoExecucaoTarefaUseCase mostrarTempoExecucaoTarefaUseCase;

    public TarefaServiceFacade(AdicionarFuncionarioTarefaUseCase adicionarFuncionarioTarefaUseCase, AtualizarTarefaConclusaoUseCase atualizarTarefaConclusaoUseCase, CriarTarefaUseCase criarTarefaUseCase, MostrarTempoExecucaoTarefaUseCase mostrarTempoExecucaoTarefaUseCase) {
        this.adicionarFuncionarioTarefaUseCase = adicionarFuncionarioTarefaUseCase;
        this.atualizarTarefaConclusaoUseCase = atualizarTarefaConclusaoUseCase;
        this.criarTarefaUseCase = criarTarefaUseCase;
        this.mostrarTempoExecucaoTarefaUseCase = mostrarTempoExecucaoTarefaUseCase;
    }
    @Override
    public Optional<Tarefa>adicionaFuncionario(Long tarefaid, Funcionario funcionario){
        return adicionarFuncionarioTarefaUseCase.adicionaFuncionario(tarefaid,funcionario);
    }
    @Override
    public Optional<Tarefa>atualizaTarefa(Long tarefaid){
        return atualizarTarefaConclusaoUseCase.atualizaTarefa(tarefaid);
    }
    @Override
    public Optional<Tarefa>criarTarefa(Tarefa tarefa){
        return criarTarefaUseCase.criarTarefa(tarefa);
    }
    @Override
    public Optional<Float>tempoExecucaoTarefa(Long tarefaid){
        return mostrarTempoExecucaoTarefaUseCase.tempoExecucaoTarefa(tarefaid);
    }
}
