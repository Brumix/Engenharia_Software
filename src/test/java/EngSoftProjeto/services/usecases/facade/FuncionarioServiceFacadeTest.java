package EngSoftProjeto.services.usecases.facade;


import EngSoftProjeto.Models.Funcionario;
import EngSoftProjeto.services.usecases.facade.teste.CriarFuncionarioUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


@SpringBootTest(classes = FuncionarioServiceFacade.class)
class FuncionarioServiceFacadeTest {

    @Autowired
    private FuncionarioServiceFacade funcionarioServiceFacade;

    @MockBean
    private  MostrarTarefasPorFuncionarioUseCase mostrarTarefasPorFuncionarioUseCase;

    @MockBean
    private CriarFuncionarioUseCase criarFuncionarioUseCase;
    @MockBean
    private MostraPorIdFuncionarioUseCase mostraPorIdFuncionarioUseCase;
    @MockBean
    private MostraTodosFuncionarioUseCase mostraTodosFuncionarioUseCase;

    @Test
    void mostrarTodos() {
        when(mostraTodosFuncionarioUseCase.findAll()).thenReturn(new ArrayList<>());
        assertNotNull(funcionarioServiceFacade.mostrarTodos());
    }

    @Test
    void encontraProjetosId() {
        when(mostraPorIdFuncionarioUseCase.findById(1L)).thenReturn(Optional.of(new Funcionario()));
        assertTrue(funcionarioServiceFacade.encontraProjetosId(1L).isPresent());
        assertTrue(funcionarioServiceFacade.encontraProjetosId(2L).isEmpty());
    }

    @Test
    void criaFuncionario() {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(1L);
        when(criarFuncionarioUseCase.criarfuncionario(funcionario)).thenReturn(Optional.of(funcionario));
        assertTrue(criarFuncionarioUseCase.criarfuncionario(funcionario).isPresent());
    }

    @Test
    void mostrarTarefasorFuncionario() {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(1L);
        when(mostrarTarefasPorFuncionarioUseCase.mostraTarefasPorPojeto(funcionario)).thenReturn(new ArrayList<>());
        assertNotNull(mostrarTarefasPorFuncionarioUseCase.mostraTarefasPorPojeto(funcionario));
    }
}