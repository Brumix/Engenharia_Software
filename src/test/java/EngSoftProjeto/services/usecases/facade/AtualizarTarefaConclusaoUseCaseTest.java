package EngSoftProjeto.services.usecases.facade;

import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.Repositories.TarefaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest(classes=AtualizarTarefaConclusaoUseCase.class)
class AtualizarTarefaConclusaoUseCaseTest {
    @Autowired
    AtualizarTarefaConclusaoUseCase atualizarTarefaConclusaoUseCase;
    @MockBean
    TarefaRepository tarefaRepository;
    @Test
    void atualizaTarefa() {
        Tarefa tarefa=new Tarefa();
        tarefa.setId(1L);
        tarefa.setNome("teste");

        when(tarefaRepository.findById(1L)).thenReturn(Optional.of(tarefa));
        assertTrue(atualizarTarefaConclusaoUseCase.atualizaTarefa(tarefa.getId()).isPresent());



    }
}