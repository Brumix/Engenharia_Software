package EngSoftProjeto.services.usecases.facade;

import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.services.usecases.facade.teste.AdicionaTarefaProjetoUseCase;
import EngSoftProjeto.services.usecases.facade.teste.CriarProjetoUseCase;
import EngSoftProjeto.services.usecases.facade.teste.MostrarPorIdProjetoUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = ProjetoServiceFacade.class)
class ProjetoServiceFacadeTest {

    @Autowired
    private ProjetoServiceFacade projetoServicefacade;
    @MockBean
    private AdicionaTarefaProjetoUseCase adicionaTarefaProjetoUseCase;
    @MockBean
    private CriarProjetoUseCase criarProjetoUseCase;
    @MockBean
    private MostrarPorIdProjetoUseCase mostrarPorIdProjetoUseCase;
    @MockBean
    private MostraTodosProjetoUseCase mostraTodosProjetoUseCase;
    @MockBean
    private MostraTarefaPorPojetoUseCase mostraTarefaPorPojetoUseCase;
    @MockBean
    private MostraClientePorPojetoUseCase mostraClientePorPojetoUseCase;
    @MockBean
    private  MostrarPorIdClienteUseCase mostrasPorIdUseCase;

    @Test
    void encontraTodos() {
        List<Projeto> projetos= new ArrayList<>();
        projetos.add(Projeto.builder().id(1L).nome("projeto1").build());
        projetos.add(Projeto.builder().id(2L).nome("projeto2").build());
        projetos.add(Projeto.builder().id(3L).nome("projeto3").build());

        when(mostraTodosProjetoUseCase.findAll()).thenReturn(projetos);
        assertNotNull(projetoServicefacade.encontraTodos());
        assertEquals(3,projetoServicefacade.encontraTodos().size());
    }

    @Test
    void encontraId() {
        when(mostrarPorIdProjetoUseCase.findById(1L)).thenReturn(Optional.of(new Projeto()));
        assertTrue(projetoServicefacade.encontraId(1L).isPresent());
        assertTrue(projetoServicefacade.encontraId(2L).isEmpty());
    }

    @Test
    void criarProjeto() {
        Projeto projeto = new Projeto();
        projeto.setId(1L);
        when(criarProjetoUseCase.criarprojeto(projeto)).thenReturn(Optional.of(projeto));
        assertTrue(criarProjetoUseCase.criarprojeto(projeto).isPresent());
    }

    @Test
    void adicionaTarefaProjecto() {
        Tarefa tarefa = new Tarefa();
        tarefa.setId(1L);
        Projeto projeto = new Projeto();
        projeto.setId(1L);
        when(adicionaTarefaProjetoUseCase.adicionaTarefa(1L,tarefa)).thenReturn( Optional.of(projeto));
        Optional<Projeto> optionalProjeto=projetoServicefacade.adicionaTarefaProjecto(1L,tarefa);
        assertTrue(optionalProjeto.isPresent());

    }

    @Test
    void mostraTarefasPorPojeto() {
        Projeto projeto = new Projeto();
        projeto.setId(1L);
        when(mostraTarefaPorPojetoUseCase.mostraTarefasPorPojeto(projeto)).thenReturn(new ArrayList<>());
        assertNotNull(mostraTarefaPorPojetoUseCase.mostraTarefasPorPojeto(projeto));
    }

    @Test
    void mostraClientePorPojeto() {
        Projeto projeto = new Projeto();
        projeto.setId(1L);
        when(mostraClientePorPojetoUseCase.mostraClientePorPojeto(projeto)).thenReturn(Optional.of(projeto.getCliente()));
        assertNotNull(mostraClientePorPojetoUseCase.mostraClientePorPojeto(projeto));
    }
}