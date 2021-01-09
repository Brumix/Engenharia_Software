package EngSoftProjeto.services.usecases.facade;

import EngSoftProjeto.Models.Funcionario;
import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = ProjetoServiceFacade.class)
class ProjetoServiceFacadeTest {
    @Autowired
    private ProjetoServiceFacade facade;
    @MockBean
    private AdicionaTarefaProjetoUseCase adicionaTarefaProjetoUseCase;
    @MockBean
    private CriarProjetoUseCase criarProjetoUseCase;
    @MockBean
    private MostrarEstadodoProjetoUseCase mostrarEstadodoProjetoUseCase;
    @MockBean
    private MostrarTempoPorProjetoUseCase mostrarTempoPorProjetoUseCase;
    @MockBean
    private MostrarPrecoProjetoUseCase mostrarPrecoProjetoUseCase;
    @Test
    void adicionaTarefa() {
        assertNotNull(facade);
        assertNotNull(adicionaTarefaProjetoUseCase);
        Tarefa tarefa=new Tarefa();
        Projeto projeto=new Projeto();
        when(adicionaTarefaProjetoUseCase.adicionaTarefa(projeto.getId(),tarefa)).thenReturn(Optional.of(projeto));
        assertNotNull(facade.adicionaTarefa(projeto.getId(),tarefa));
    }

    @Test
    void criarprojeto() {
        assertNotNull(facade);
        assertNotNull(criarProjetoUseCase);
        Projeto projeto=new Projeto();
        when(criarProjetoUseCase.criarprojeto(projeto)).thenReturn(Optional.of(projeto));

        assertNotNull(facade.criarprojeto(projeto));
    }

    @Test
    void mostrarEstadoProjeto() {
        assertNotNull(facade);
        assertNotNull(mostrarEstadodoProjetoUseCase);
        Projeto p1 = new Projeto();
        p1.setId(1L);
        when(mostrarEstadodoProjetoUseCase.mostrarEstadoProjeto(p1.getId())).thenReturn(1.0f);
        assertNotNull(facade.mostrarEstadoProjeto(p1.getId()));
    }
//este
    @Test
    void precoProjeto() {
        assertNotNull(facade);
        assertNotNull(mostrarPrecoProjetoUseCase);
        Projeto p1 = new Projeto();
        when(mostrarPrecoProjetoUseCase.precoProjeto(p1.getId())).thenReturn(1.0f);
        assertNotNull(facade.precoProjeto(p1.getId()));
    }
//este
    @Test
    void mostrarTempoProjeto() {
        assertNotNull(facade);
        assertNotNull(mostrarTempoPorProjetoUseCase);
        Projeto p1 = new Projeto();
        when(mostrarTempoPorProjetoUseCase.mostrarTempoProjeto(p1.getId())).thenReturn(1);
        assertNotNull(facade.mostrarTempoProjeto(p1.getId()));
    }
}