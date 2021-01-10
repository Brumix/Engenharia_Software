package pt.ufp.inf.esof.projeto.models;


import engsoftprojeto.models.Cliente;
import engsoftprojeto.models.Funcionario;
import engsoftprojeto.models.Projeto;
import engsoftprojeto.models.Tarefa;
import engsoftprojeto.models.Cargo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProjetoTest {

    @Test
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
        projeto.setNome("projeto");
        Tarefa tarefa = new Tarefa();
        tarefa.setNome("classes");
        tarefa.setConcluida(false);
        tarefa.setDuracao(2);
        projeto.getTarefas().add(tarefa);
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("andre");
        funcionario.setCargo(Cargo.AN_JR);
        funcionario.setEmail("teste123@hotmail.com");
        funcionario.setPassword("algo");
        funcionario.getTarefas().add(tarefa);
        tarefa.setFuncionario(funcionario);
        tarefa.setProjeto(projeto);
        Tarefa tarefa1 = new Tarefa();
        tarefa1.setNome("classes");
        tarefa1.setConcluida(false);
        tarefa1.setDuracao(3);
        projeto.getTarefas().add(tarefa1);
        Funcionario funcionario1 = new Funcionario();
        funcionario1.setNome("andre");
        funcionario1.setCargo(Cargo.DEV_JR);
        funcionario1.setEmail("teste123@hotmail.com");
        funcionario1.setPassword("algo");
        funcionario1.getTarefas().add(tarefa1);
        tarefa1.setFuncionario(funcionario1);
        tarefa1.setProjeto(projeto);
        assertEquals(70, projeto.calcularPrecoProjeto());

    }

    @Test
    void duracaoProjeto() {
        Projeto projeto = new Projeto();
        projeto.setId(1L);
        projeto.setNome("projeto");
        Tarefa tarefa = new Tarefa();
        tarefa.setNome("classes");
        tarefa.setConcluida(false);
        tarefa.setDuracao(100);
        projeto.getTarefas().add(tarefa);
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("andre");
        funcionario.setCargo(Cargo.DEV_JR);
        funcionario.setEmail("teste123@hotmail.com");
        funcionario.setPassword("algo");
        funcionario.getTarefas().add(tarefa);
        tarefa.setFuncionario(funcionario);
        tarefa.setProjeto(projeto);

        assertEquals(100, projeto.duracaoProjeto());

    }

    @Test
    void calcularPercentagemConclusao() {
        Projeto projeto = new Projeto();
        projeto.setId(1L);
        projeto.setNome("projeto");
        Tarefa tarefa = new Tarefa();

        tarefa.setNome("classes");
        tarefa.setConcluida(true);
        Tarefa tarefa1 = new Tarefa();
        tarefa1.setDuracao(100);

        tarefa1.setNome("classes1");
        tarefa1.setConcluida(false);
        tarefa1.setDuracao(100);
        projeto.getTarefas().add(tarefa);
        projeto.getTarefas().add(tarefa1);
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("andre");
        funcionario.setCargo(Cargo.DEV_JR);
        funcionario.setEmail("teste123@hotmail.com");
        funcionario.setPassword("algo");
        funcionario.getTarefas().add(tarefa);
        tarefa.setFuncionario(funcionario);
        tarefa.setProjeto(projeto);
        assertEquals(funcionario, tarefa.getFuncionario());
        assertEquals(50, projeto.calcularPercentagemConclusao());
    }

    @Test
    void atualizarTarefa() {
        Projeto projeto = new Projeto();
        projeto.setId(1L);
        projeto.setNome("projeto");
        Tarefa tarefa = new Tarefa();
        tarefa.setNome("classes");
        tarefa.setConcluida(true);
        Tarefa tarefa1 = new Tarefa();
        tarefa1.setDuracao(100);
        tarefa1.setNome("classes1");
        tarefa1.setConcluida(false);
        tarefa1.setDuracao(100);
        projeto.getTarefas().add(tarefa);
        projeto.getTarefas().add(tarefa1);
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("andre");
        funcionario.setCargo(Cargo.DEV_JR);
        funcionario.setEmail("teste123@hotmail.com");
        funcionario.setPassword("algo");
        funcionario.getTarefas().add(tarefa);
        tarefa.setFuncionario(funcionario);
        tarefa.setProjeto(projeto);
        projeto.atualizarTarefa(tarefa1);
        assertEquals(true, tarefa1.getConcluida());
    }

    @Test
    void adicionaClienteTest() {
        Projeto projeto = new Projeto();
        Cliente cliente = new Cliente();
        projeto.setCliente(cliente);
        assertEquals(cliente, projeto.getCliente());
    }
}