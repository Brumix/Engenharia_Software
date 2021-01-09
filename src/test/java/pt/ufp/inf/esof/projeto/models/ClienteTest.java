package pt.ufp.inf.esof.projeto.models;

import EngSoftProjeto.Models.*;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void testeClientId() {
        Cliente cliente = new Cliente();
        cliente.setId(12L);
        assertEquals(12, cliente.getId());
    }

    @Test
    void testeClientName() {
        Cliente cliente = new Cliente();
        cliente.setNome("bruno");
        assertEquals("bruno", cliente.getNome());
    }

    @Test
    void consultarEstadoProjetoNull() {
        Cliente cliente = new Cliente();
        cliente.setNome("andre");
        cliente.setId(1L);
        Projeto projeto = new Projeto();
        projeto.setNome("projeto");
        projeto.setId(1L);
        projeto.setCliente(cliente);
        assertNull(cliente.consultarEstadoProjeto(projeto));
    }


    @Test
    void consultarEstadoProjeto() {
        Cliente cliente= Cliente.builder().nome("Bruno").build();
        Tarefa tarefa= Tarefa.builder().concluida(true).build();
        Tarefa tarefa1= Tarefa.builder().concluida(false).build();
        Projeto projeto = new Projeto();
        projeto.setNome("projeto");
        projeto.setId(1L);
        projeto.getTarefas().add(tarefa);
        projeto.getTarefas().add(tarefa1);
        projeto.setCliente(cliente);
        List<Projeto> projetos= new ArrayList<>();
        projetos.add(projeto);
        cliente.setProjetos(projetos);
        System.out.println("cheguei");
        assertEquals("projeto 50.0", cliente.consultarEstadoProjeto(projeto));
    }


    @Test
    void consultarDuracaoProjetoNull() {
        Cliente cliente = new Cliente();
        cliente.setNome("andre");
        cliente.setId(1L);
        Projeto projeto = new Projeto();
        projeto.setNome("projeto");
        projeto.setId(1L);
        projeto.setCliente(cliente);
        assertNull(cliente.consultarDuracaoProjeto(projeto));

    }


    @Test
    void consultarDuracaoProjeto() {
        Cliente cliente = new Cliente();
        cliente.setNome("Bruno");
        cliente.setId(1L);
        Tarefa tarefa= Tarefa.builder().duracao(50).build();
        Projeto projeto = new Projeto();
        projeto.setNome("projeto");
        projeto.setId(1L);
        projeto.tarefas.add(tarefa);
        projeto.setCliente(cliente);
        cliente.getProjetos().add(projeto);
        assertEquals("projeto 50", cliente.consultarDuracaoProjeto(projeto));
    }


    @Test
    void consultarPrecoProjetoNull() {
        Cliente cliente = new Cliente();
        cliente.setNome("andre");
        cliente.setId(1L);
        Projeto projeto = new Projeto();
        projeto.setNome("projeto");
        projeto.setId(1L);
        projeto.setCliente(cliente);
        assertNull(cliente.ConsultarPrecoProjeto(projeto));
    }

    @Test
    void consultarPrecoProjeto() {
        Cliente cliente = Cliente.builder().nome("Bruno").build();
        Funcionario funcionario= Funcionario.builder().nome("Andre").cargo(Cargo.AN_JR).build();
        Tarefa tarefa = Tarefa.builder().funcionario(funcionario).nome("tarefa").duracao(20).build();
        Projeto projeto = new Projeto();
        projeto.setNome("projeto");
        projeto.setId(1L);
        projeto.tarefas.add(tarefa);
        projeto.setCliente(cliente);

        List<Projeto> projetos= new ArrayList<>();
        projetos.add(projeto);
        cliente.setProjetos(projetos);


        assertEquals("projeto 400.0", cliente.ConsultarPrecoProjeto(projeto));
    }

    @Test
    void adicionaProjetoTest() {
        Cliente cliente = new Cliente();
        Projeto projeto = new Projeto();
        projeto.setCliente(cliente);
        assertEquals(cliente, projeto.getCliente());
    }
}