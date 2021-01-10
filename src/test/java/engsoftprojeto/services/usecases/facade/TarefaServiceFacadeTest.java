package engsoftprojeto.services.usecases.facade;

import engsoftprojeto.models.Funcionario;
import engsoftprojeto.models.Tarefa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@SpringBootTest(classes = TarefaServiceFacade.class)
class TarefaServiceFacadeTest {
    @Autowired
    private TarefaServiceFacade facade;
    @MockBean
    private AdicionarFuncionarioTarefaUseCase adicionarFuncionarioTarefaUseCase;
    @MockBean
    private AtualizarTarefaConclusaoUseCase atualizarTarefaConclusaoUseCase;
    @MockBean
    private CriarTarefaUseCase criarTarefaUseCase;
    @MockBean
    private MostrarTempoExecucaoTarefaUseCase mostrarTempoExecucaoTarefaUseCase;

    @Test
    void adicionaFuncionario() {
        assertNotNull(facade);
        assertNotNull(adicionarFuncionarioTarefaUseCase);
        Tarefa tarefa=new Tarefa();
        Funcionario funcionario =new Funcionario();
        when(adicionarFuncionarioTarefaUseCase.adicionaFuncionario(tarefa.getId(),funcionario)).thenReturn(Optional.of(tarefa));
        assertNotNull(facade.adicionaFuncionario(tarefa.getId(),funcionario));
    }

    @Test
    void atualizaTarefa() {
        assertNotNull(facade);
        assertNotNull(atualizarTarefaConclusaoUseCase);
        Tarefa tarefa=new Tarefa();

        when(atualizarTarefaConclusaoUseCase.atualizaTarefa(tarefa.getId())).thenReturn(Optional.of(tarefa));
        assertNotNull(facade.atualizaTarefa(tarefa.getId()));
    }

    @Test
    void criarTarefa() {
        assertNotNull(facade);
        assertNotNull(criarTarefaUseCase);
        Tarefa tarefa=new Tarefa();
        when(criarTarefaUseCase.criarTarefa(tarefa)).thenReturn(Optional.of(tarefa));

        assertNotNull(facade.criarTarefa(tarefa));
    }

    @Test
    void tempoExecucaoTarefa() {
        assertNotNull(facade);
        assertNotNull(mostrarTempoExecucaoTarefaUseCase);
        Tarefa tarefa=new Tarefa();

        when(mostrarTempoExecucaoTarefaUseCase.tempoExecucaoTarefa(tarefa.getId())).thenReturn(Optional.of(tarefa.getDuracao()));
        assertNotNull(facade.tempoExecucaoTarefa(tarefa.getId()));
    }
}