package pt.ufp.inf.esof.projeto.models;

import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class ClienteTest {
@Test
void consultarEstadoProjeto(){
    Cliente cliente=new Cliente();
    cliente.setNome("andre");
    cliente.setId(1);
    Projeto projeto=new Projeto ();
    projeto.setNome("projeto");
    projeto.setDuracao(10);
    projeto.setId(1);
    projeto.setMyCliente(cliente);
    projeto.setPercentagemDeConclusao((float) 20.0);
    projeto.setPrecoFinal(5000);
    cliente.getProjetos().add(projeto);
    assertEquals("projeto 20.0",cliente.consultarEstadoProjeto(projeto));




}

    @Test
    void consultarDuracaoProjeto() {
        Cliente cliente=new Cliente();
        cliente.setNome("andre");
        cliente.setId(1);
        Projeto projeto=new Projeto ();
        projeto.setNome("projeto");
        projeto.setId(1);
        projeto.setMyCliente(cliente);
        projeto.setDuracao(2000);
        projeto.setPercentagemDeConclusao(20);
        projeto.setPrecoFinal(5000);
        cliente.getProjetos().add(projeto);
        assertEquals("projeto 2000",cliente.consultarDuracaoProjeto(projeto));
    }

    @Test
    void consultarPrecoProjeto() {
        Cliente cliente=new Cliente();
        cliente.setNome("andre");
        cliente.setId(1);
        Projeto projeto=new Projeto ();
        projeto.setNome("projeto");
        projeto.setId(1);
        projeto.setMyCliente(cliente);
        projeto.setPercentagemDeConclusao(20);
        projeto.setPrecoFinal(5000);
        cliente.getProjetos().add(projeto);
        assertEquals("projeto 5000",cliente.ConsultarPrecoProjeto(projeto));
    }
}