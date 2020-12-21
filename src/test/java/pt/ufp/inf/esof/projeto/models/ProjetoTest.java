package pt.ufp.inf.esof.projeto.models;

<<<<<<< HEAD
import EngSoftProjeto.Models.*;
=======
>>>>>>> 7c95394a7f6115ceaa38553fdc1a086196c6b9b4
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjetoTest {

    @Test
<<<<<<< HEAD
    void testeProjectoId() {

        Projeto projeto = new Projeto();
        projeto.setId(12L);
        assertEquals(12, projeto.getId());
    }

    @Test
    void testeProjectoCliente() {

        Cliente cliente = new Cliente();
        cliente.setNome("bruno");
        Projeto projeto = new Projeto();
        projeto.setCliente(cliente);
        assertEquals(cliente, projeto.getCliente());
    }

    @Test
    void calcularPrecoProjeto() {
        Projeto projeto = new Projeto();
        projeto.setId(1L);
=======
    void calcularPrecoProjeto() {
        Projeto projeto=new Projeto ();
        projeto.setId(1);
>>>>>>> 7c95394a7f6115ceaa38553fdc1a086196c6b9b4
        projeto.setNome("projeto");
        projeto.setDuracao(2000);

        projeto.setPercentagemDeConclusao(20);
<<<<<<< HEAD
        Tarefa tarefa = new Tarefa();
=======
        Tarefa tarefa=new Tarefa();
>>>>>>> 7c95394a7f6115ceaa38553fdc1a086196c6b9b4
        tarefa.setPreco(1000);
        tarefa.setNome("classes");
        tarefa.setConcluida(false);
        projeto.getTarefas().add(tarefa);
<<<<<<< HEAD
        Funcionario funcionario = new Funcionario();
=======
        Funcionario funcionario=new Funcionario();
>>>>>>> 7c95394a7f6115ceaa38553fdc1a086196c6b9b4
        funcionario.setNome("andre");
        funcionario.setCargo(Cargo.DEV_JR);
        funcionario.setEmail("teste123@hotmail.com");
        funcionario.setPassword("algo");
        funcionario.getTarefas().add(tarefa);
<<<<<<< HEAD
        tarefa.setFuncionario(funcionario);
        tarefa.setProjeto(projeto);
=======
        tarefa.setMyFuncionario(funcionario);
        tarefa.setMyProjeto(projeto);
>>>>>>> 7c95394a7f6115ceaa38553fdc1a086196c6b9b4

        assertEquals(1000, projeto.calcularPrecoProjeto());

    }

    @Test
    void duracaoProjeto() {
<<<<<<< HEAD
        Projeto projeto = new Projeto();
        projeto.setId(1L);
        projeto.setNome("projeto");
        Tarefa tarefa = new Tarefa();
=======
        Projeto projeto=new Projeto ();
        projeto.setId(1);
        projeto.setNome("projeto");
        Tarefa tarefa=new Tarefa();
>>>>>>> 7c95394a7f6115ceaa38553fdc1a086196c6b9b4
        tarefa.setPreco(1000);
        tarefa.setNome("classes");
        tarefa.setConcluida(false);
        tarefa.setDuracao(100);
        projeto.getTarefas().add(tarefa);
<<<<<<< HEAD
        Funcionario funcionario = new Funcionario();
=======
        Funcionario funcionario=new Funcionario();
>>>>>>> 7c95394a7f6115ceaa38553fdc1a086196c6b9b4
        funcionario.setNome("andre");
        funcionario.setCargo(Cargo.DEV_JR);
        funcionario.setEmail("teste123@hotmail.com");
        funcionario.setPassword("algo");
        funcionario.getTarefas().add(tarefa);
<<<<<<< HEAD
        tarefa.setFuncionario(funcionario);
        tarefa.setProjeto(projeto);
=======
        tarefa.setMyFuncionario(funcionario);
        tarefa.setMyProjeto(projeto);
>>>>>>> 7c95394a7f6115ceaa38553fdc1a086196c6b9b4

        assertEquals(100, projeto.duracaoProjeto());

    }

    @Test
    void calcularPercentagemConclusao() {
<<<<<<< HEAD
        Projeto projeto = new Projeto();
        projeto.setId(1L);
        projeto.setNome("projeto");
        Tarefa tarefa = new Tarefa();
        tarefa.setPreco(1000);
        tarefa.setNome("classes");
        tarefa.setConcluida(true);
        Tarefa tarefa1 = new Tarefa();
=======
        Projeto projeto=new Projeto ();
        projeto.setId(1);
        projeto.setNome("projeto");
        Tarefa tarefa=new Tarefa();
        tarefa.setPreco(1000);
        tarefa.setNome("classes");
        tarefa.setConcluida(true);
        Tarefa tarefa1=new Tarefa();
>>>>>>> 7c95394a7f6115ceaa38553fdc1a086196c6b9b4
        tarefa1.setDuracao(100);
        tarefa1.setPreco(1000);
        tarefa1.setNome("classes1");
        tarefa1.setConcluida(false);
        tarefa1.setDuracao(100);
        projeto.getTarefas().add(tarefa);
        projeto.getTarefas().add(tarefa1);
<<<<<<< HEAD
        Funcionario funcionario = new Funcionario();
=======
        Funcionario funcionario=new Funcionario();
>>>>>>> 7c95394a7f6115ceaa38553fdc1a086196c6b9b4
        funcionario.setNome("andre");
        funcionario.setCargo(Cargo.DEV_JR);
        funcionario.setEmail("teste123@hotmail.com");
        funcionario.setPassword("algo");
        funcionario.getTarefas().add(tarefa);
<<<<<<< HEAD
        tarefa.setFuncionario(funcionario);
        tarefa.setProjeto(projeto);
        assertEquals(funcionario,tarefa.getFuncionario());
=======
        tarefa.setMyFuncionario(funcionario);
        tarefa.setMyProjeto(projeto);

>>>>>>> 7c95394a7f6115ceaa38553fdc1a086196c6b9b4
        assertEquals(50, projeto.calcularPercentagemConclusao());
    }

    @Test
    void atualizarTarefa() {
<<<<<<< HEAD
        Projeto projeto = new Projeto();
        projeto.setId(1L);
        projeto.setNome("projeto");
        Tarefa tarefa = new Tarefa();
        tarefa.setPreco(1000);
        tarefa.setNome("classes");
        tarefa.setConcluida(true);
        Tarefa tarefa1 = new Tarefa();
=======
        Projeto projeto=new Projeto ();
        projeto.setId(1);
        projeto.setNome("projeto");
        Tarefa tarefa=new Tarefa();
        tarefa.setPreco(1000);
        tarefa.setNome("classes");
        tarefa.setConcluida(true);
        Tarefa tarefa1=new Tarefa();
>>>>>>> 7c95394a7f6115ceaa38553fdc1a086196c6b9b4
        tarefa1.setDuracao(100);
        tarefa1.setPreco(1000);
        tarefa1.setNome("classes1");
        tarefa1.setConcluida(false);
        tarefa1.setDuracao(100);
        projeto.getTarefas().add(tarefa);
        projeto.getTarefas().add(tarefa1);
<<<<<<< HEAD
        Funcionario funcionario = new Funcionario();
=======
        Funcionario funcionario=new Funcionario();
>>>>>>> 7c95394a7f6115ceaa38553fdc1a086196c6b9b4
        funcionario.setNome("andre");
        funcionario.setCargo(Cargo.DEV_JR);
        funcionario.setEmail("teste123@hotmail.com");
        funcionario.setPassword("algo");
        funcionario.getTarefas().add(tarefa);
<<<<<<< HEAD
        tarefa.setFuncionario(funcionario);
        tarefa.setProjeto(projeto);
        projeto.atualizarTarefa(tarefa1);
        assertEquals(true, tarefa1.getConcluida());
    }

    @Test
    void adicionaClienteTest(){
        Cliente cliente= new Cliente();
        cliente.setNome("Bruno");
        Projeto projeto= new Projeto();
        projeto.adicionaCliente(cliente);
        assertEquals(cliente,projeto.getCliente());
=======
        tarefa.setMyFuncionario(funcionario);
        tarefa.setMyProjeto(projeto);
        projeto.atualizarTarefa(tarefa1);
        assertEquals(true,tarefa1.getConcluida());
>>>>>>> 7c95394a7f6115ceaa38553fdc1a086196c6b9b4
    }
}