package pt.ufp.inf.esof.projeto.models;

<<<<<<< HEAD
import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Models.Projeto;
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
        projeto.setDuracao(10);
        projeto.setId(1L);
        projeto.setCliente(cliente);
        projeto.setPercentagemDeConclusao((float) 20.0);
        projeto.setPrecoFinal(5000);
        assertNull(cliente.consultarEstadoProjeto(projeto));
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
    void consultarDuracaoProjetoNull() {
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
=======
import org.junit.jupiter.api.Test;


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
    projeto.setCliente(cliente);
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
>>>>>>> 7c95394a7f6115ceaa38553fdc1a086196c6b9b4
        projeto.setCliente(cliente);
        projeto.setDuracao(2000);
        projeto.setPercentagemDeConclusao(20);
        projeto.setPrecoFinal(5000);
        cliente.getProjetos().add(projeto);
<<<<<<< HEAD
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
        assertNull(cliente.ConsultarPrecoProjeto(projeto));
=======
        assertEquals("projeto 2000",cliente.consultarDuracaoProjeto(projeto));
>>>>>>> 7c95394a7f6115ceaa38553fdc1a086196c6b9b4
    }

    @Test
    void consultarPrecoProjeto() {
<<<<<<< HEAD
        Cliente cliente = new Cliente();
        cliente.setNome("andre");
        cliente.setId(1L);
        Projeto projeto = new Projeto();
        projeto.setNome("projeto");
        projeto.setId(1L);
=======
        Cliente cliente=new Cliente();
        cliente.setNome("andre");
        cliente.setId(1);
        Projeto projeto=new Projeto ();
        projeto.setNome("projeto");
        projeto.setId(1);
>>>>>>> 7c95394a7f6115ceaa38553fdc1a086196c6b9b4
        projeto.setCliente(cliente);
        projeto.setPercentagemDeConclusao(20);
        projeto.setPrecoFinal(5000);
        cliente.getProjetos().add(projeto);
<<<<<<< HEAD
        assertEquals("projeto 5000", cliente.ConsultarPrecoProjeto(projeto));
    }

    @Test
    void adicionaProjectoTeste() {
        Cliente cliente = new Cliente();
        List<Projeto> projetos = new ArrayList<>();
        Projeto projeto1 = new Projeto();
        projeto1.setNome("Projeto1");
        Projeto projeto2 = new Projeto();
        projeto2.setNome("Projeto2");
        cliente.adicionaProjecto(projeto1);
        cliente.adicionaProjecto(projeto2);
        projetos.add(projeto1);
        projetos.add(projeto2);
        assertEquals(projetos, cliente.getProjetos());
=======
        assertEquals("projeto 5000",cliente.ConsultarPrecoProjeto(projeto));
>>>>>>> 7c95394a7f6115ceaa38553fdc1a086196c6b9b4
    }
}