package EngSoftProjeto.services.usecases.facade;

import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.Repositories.ProjetoRepository;
import EngSoftProjeto.Repositories.TarefaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@SpringBootTest(classes=MostrarTempoExecucaoTarefaUseCase.class)
class MostrarTempoExecucaoTarefaUseCaseTest {
    @Autowired
    MostrarTempoExecucaoTarefaUseCase mostrarTempoExecucaoTarefaUseCase;
    @MockBean
    TarefaRepository tarefaRepository;
    @Test
    void tempoExecucaoTarefa() {
       /* Projeto projeto=new Projeto();
        projeto.setId(2L);
        projeto.setNome("andre");*/
        Tarefa tarefa=new Tarefa();
        tarefa.setId(10L);
        tarefa.setNome("testes");
       /* projeto.tarefas.add(tarefa);
        tarefa.setProjeto(projeto);*/

        when(tarefaRepository.findById(tarefa.getId())).thenReturn(Optional.of(tarefa));
        assertTrue(mostrarTempoExecucaoTarefaUseCase.tempoExecucaoTarefa(tarefa.getId()).isPresent());
    }
}