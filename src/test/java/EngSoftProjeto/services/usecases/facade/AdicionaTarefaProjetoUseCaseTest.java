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

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
@SpringBootTest(classes=AdicionaTarefaProjetoUseCase.class)
class AdicionaTarefaProjetoUseCaseTest {
    @Autowired
    AdicionaTarefaProjetoUseCase adicionaTarefaProjetoUseCase;
    @MockBean
    ProjetoRepository projetoRepository;
    @MockBean
    TarefaRepository tarefaRepository;
    @Test
    void adicionaTarefa() {
        Tarefa tarefa=new Tarefa();
        tarefa.setId(1L);
        Projeto projeto=new Projeto();
        projeto.setId(1L);
        projeto.setNome("andre");

        when(projetoRepository.findById(1L)).thenReturn(Optional.of(projeto));
        assertTrue(adicionaTarefaProjetoUseCase.adicionaTarefa(projeto.getId(), tarefa).isPresent());

        assertTrue(adicionaTarefaProjetoUseCase.adicionaTarefa(projeto.getId(), tarefa).isEmpty());

    }
    }
