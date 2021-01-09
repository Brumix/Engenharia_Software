package EngSoftProjeto.services.usecases.facade;

import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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
    }

    @Test
    void atualizaTarefa() {
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
    }
}