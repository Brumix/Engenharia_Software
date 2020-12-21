package pt.ufp.inf.esof.projeto.models;

import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Models.Projeto;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void testeClientId(){
        Cliente cliente = new Cliente();
        cliente.setId(12L);
        assertEquals(12,cliente.getId());
    }

    @Test
    void testeClientName(){
        Cliente cliente = new Cliente();
        cliente.setNome("bruno");
        assertEquals("bruno",cliente.getNome());
    }

    @Test
    void consultarEstadoProjetoNull() {
        Cliente cliente = new Cliente();
        cliente.setNome("andre");
        cliente.setId(1L);
        Projeto projeto = new Projeto();
        projeto.setNome("projeto");
        projeto.setDuracao(10);
        projeto.setId(1L);
        projeto.setCliente(cliente);
        projeto.setPercentagemDeConclusao((float) 20.0);
        projeto.setPrecoFinal(5000);
        assertNull( cliente.consultarEstadoProjeto(projeto));
    }


    @Test
    void consultarEstadoProjeto() {
        Cliente cliente = new Cliente();
        cliente.setNome("andre");
        cliente.setId(1L);
        Projeto projeto = new Projeto();
        projeto.setNome("projeto");
        projeto.setDuracao(10);
        projeto.setId(1L);
        projeto.setCliente(cliente);
        projeto.setPercentagemDeConclusao((float) 20.0);
        projeto.setPrecoFinal(5000);
        cliente.getProjetos().add(projeto);
        assertEquals("projeto 20.0", cliente.consultarEstadoProjeto(projeto));
    }


    @Test
    void  consultarDuracaoProjetoNull(){
        Cliente cliente = new Cliente();
        cliente.setNome("andre");
        cliente.setId(1L);
        Projeto projeto = new Projeto();
        projeto.setNome("projeto");
        projeto.setId(1L);
        projeto.setCliente(cliente);
        projeto.setDuracao(2000);
        projeto.setPercentagemDeConclusao(20);
        projeto.setPrecoFinal(5000);
        assertNull(cliente.consultarDuracaoProjeto(projeto));

    }


    @Test
    void consultarDuracaoProjeto() {
        Cliente cliente = new Cliente();
        cliente.setNome("andre");
        cliente.setId(1L);
        Projeto projeto = new Projeto();
        projeto.setNome("projeto");
        projeto.setId(1L);
        projeto.setCliente(cliente);
        projeto.setDuracao(2000);
        projeto.setPercentagemDeConclusao(20);
        projeto.setPrecoFinal(5000);
        cliente.getProjetos().add(projeto);
        assertEquals("projeto 2000", cliente.consultarDuracaoProjeto(projeto));
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
        projeto.setPercentagemDeConclusao(20);
        projeto.setPrecoFinal(5000);
        assertNull( cliente.ConsultarPrecoProjeto(projeto));
    }
    @Test
    void consultarPrecoProjeto() {
        Cliente cliente = new Cliente();
        cliente.setNome("andre");
        cliente.setId(1L);
        Projeto projeto = new Projeto();
        projeto.setNome("projeto");
        projeto.setId(1L);
        projeto.setCliente(cliente);
        projeto.setPercentagemDeConclusao(20);
        projeto.setPrecoFinal(5000);
        cliente.getProjetos().add(projeto);
        assertEquals("projeto 5000", cliente.ConsultarPrecoProjeto(projeto));
    }


}