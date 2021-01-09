package EngSoftProjeto.services.usecases.facade;

import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.Repositories.TarefaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
@SpringBootTest(classes=MostrarTempoExecucaoTarefaUseCase.class)
class MostrarTempoExecucaoTarefaUseCaseTest {
    @Autowired
    MostrarTempoExecucaoTarefaUseCase mostrarTempoExecucaoTarefaUseCase;
    @MockBean
    TarefaRepository tarefaRepository;
    @Test
    void tempoExecucaoTarefa() {
        Tarefa tarefa=new Tarefa();
        tarefa.setNome("testes");



        when(tarefaRepository.findById(1L)).thenReturn(Optional.of(tarefa));

    }
}