package EngSoftProjeto.services.usecases.facade;

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

@SpringBootTest(classes=CriarTarefaUseCase.class)
class CriarTarefaUseCaseTest {
    @Autowired
    CriarTarefaUseCase criarTarefaUseCase;
    @MockBean
    TarefaRepository tarefaRepository;
    @Test
    void criarTarefa() {
        Tarefa tarefa=new Tarefa();
        tarefa.setId(2L);
        tarefa.setNome("teste");

        assertTrue(criarTarefaUseCase.criarTarefa(tarefa).isPresent());
         when(tarefaRepository.findByNome(tarefa.getNome())).thenReturn(Optional.of(tarefa));
         assertTrue(criarTarefaUseCase.criarTarefa(tarefa).isEmpty());
    }
}