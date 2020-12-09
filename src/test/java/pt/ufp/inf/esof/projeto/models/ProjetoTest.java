package pt.ufp.inf.esof.projeto.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjetoTest {

    @Test
    void calcularPrecoProjeto() {
        Projeto projeto=new Projeto ();
        projeto.setId(1);
        projeto.setNome("projeto");
        projeto.setDuracao(2000);

        projeto.setPercentagemDeConclusao(20);
        Tarefa tarefa=new Tarefa();
        tarefa.setPreco(1000);
        tarefa.setNome("classes");
        tarefa.setConcluida(false);
        projeto.getTarefas().add(tarefa);
        Funcionario funcionario=new Funcionario();
        funcionario.setNome("andre");
        funcionario.setCargo(Cargo.DEV_JR);
        funcionario.setEmail("teste123@hotmail.com");
        funcionario.setPassword("algo");
        funcionario.getTarefas().add(tarefa);
        tarefa.setMyFuncionario(funcionario);
        tarefa.setMyProjeto(projeto);

        assertEquals(1000, projeto.calcularPrecoProjeto());

    }

    @Test
    void duracaoProjeto() {
        Projeto projeto=new Projeto ();
        projeto.setId(1);
        projeto.setNome("projeto");
        Tarefa tarefa=new Tarefa();
        tarefa.setPreco(1000);
        tarefa.setNome("classes");
        tarefa.setConcluida(false);
        tarefa.setDuracao(100);
        projeto.getTarefas().add(tarefa);
        Funcionario funcionario=new Funcionario();
        funcionario.setNome("andre");
        funcionario.setCargo(Cargo.DEV_JR);
        funcionario.setEmail("teste123@hotmail.com");
        funcionario.setPassword("algo");
        funcionario.getTarefas().add(tarefa);
        tarefa.setMyFuncionario(funcionario);
        tarefa.setMyProjeto(projeto);

        assertEquals(100, projeto.duracaoProjeto());

    }

    @Test
    void calcularPercentagemConclusao() {
        Projeto projeto=new Projeto ();
        projeto.setId(1);
        projeto.setNome("projeto");
        Tarefa tarefa=new Tarefa();
        tarefa.setPreco(1000);
        tarefa.setNome("classes");
        tarefa.setConcluida(true);
        Tarefa tarefa1=new Tarefa();
        tarefa1.setDuracao(100);
        tarefa1.setPreco(1000);
        tarefa1.setNome("classes1");
        tarefa1.setConcluida(false);
        tarefa1.setDuracao(100);
        projeto.getTarefas().add(tarefa);
        projeto.getTarefas().add(tarefa1);
        Funcionario funcionario=new Funcionario();
        funcionario.setNome("andre");
        funcionario.setCargo(Cargo.DEV_JR);
        funcionario.setEmail("teste123@hotmail.com");
        funcionario.setPassword("algo");
        funcionario.getTarefas().add(tarefa);
        tarefa.setMyFuncionario(funcionario);
        tarefa.setMyProjeto(projeto);

        assertEquals(50, projeto.calcularPercentagemConclusao());
    }

    @Test
    void atualizarTarefa() {
        Projeto projeto=new Projeto ();
        projeto.setId(1);
        projeto.setNome("projeto");
        Tarefa tarefa=new Tarefa();
        tarefa.setPreco(1000);
        tarefa.setNome("classes");
        tarefa.setConcluida(true);
        Tarefa tarefa1=new Tarefa();
        tarefa1.setDuracao(100);
        tarefa1.setPreco(1000);
        tarefa1.setNome("classes1");
        tarefa1.setConcluida(false);
        tarefa1.setDuracao(100);
        projeto.getTarefas().add(tarefa);
        projeto.getTarefas().add(tarefa1);
        Funcionario funcionario=new Funcionario();
        funcionario.setNome("andre");
        funcionario.setCargo(Cargo.DEV_JR);
        funcionario.setEmail("teste123@hotmail.com");
        funcionario.setPassword("algo");
        funcionario.getTarefas().add(tarefa);
        tarefa.setMyFuncionario(funcionario);
        tarefa.setMyProjeto(projeto);
        projeto.atualizarTarefa(tarefa1);
        assertEquals(true,tarefa1.getConcluida());
    }
}