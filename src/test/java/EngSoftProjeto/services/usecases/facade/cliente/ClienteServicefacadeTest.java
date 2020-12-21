package EngSoftProjeto.services.usecases.facade.cliente;

import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Models.Projeto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes=ClienteServicefacade.class)
class ClienteServicefacadeTest {

    @Autowired
    private ClienteServicefacade clienteServicefacade;
    @MockBean
    private AdicionarProjectoClienteUseCase adicionarProjectoClienteUseCase;
    @MockBean
    private  CriarClienteUseCase criarClienteUseCase;
    @MockBean
    private MostrarPorIdUseCase mostrarPorIdUseCase;
    @MockBean
    private MostrarTodosOsClientesUseCase mostrarTodosOsClientesUseCase;

    @Test
    void encontraTodos() {
        when(mostrarTodosOsClientesUseCase.findAll()).thenReturn(new ArrayList<>());
        assertNotNull(clienteServicefacade.encontraTodos());
    }

    @Test
    void encontraId() {
        when(mostrarPorIdUseCase.findById(1L)).thenReturn(Optional.of(new Cliente()));
        assertTrue(clienteServicefacade.encontraId(1L).isPresent());
        assertTrue(clienteServicefacade.encontraId(2L).isEmpty());
    }

    @Test
    void criaCliente() {

        Cliente cliente = new Cliente();
        cliente.setId(1L);
        when(criarClienteUseCase.criarcliente(cliente)).thenReturn(Optional.of(cliente));
        assertTrue(clienteServicefacade.criaCliente(cliente).isPresent());
    }


    @Test
    void adicionaProjecto() {
        Long id = 1L;
        Projeto projeto = new Projeto();
        projeto.setNome("projeto");

        Cliente cliente = new Cliente();
        cliente.setId(id);

        when(adicionarProjectoClienteUseCase.adicionaProjetos(id, projeto)).thenReturn(Optional.of(cliente));
        assertTrue(clienteServicefacade.adicionaProjecto(id, projeto).isPresent());
        assertTrue(clienteServicefacade.adicionaProjecto(2L, projeto).isEmpty());
    }
}
