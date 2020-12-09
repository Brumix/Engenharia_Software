package pt.ufp.inf.esof.projeto.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

    @Test
    void consultarTarefasNaoConcluidas() {
        Projeto projeto=new Projeto ();
        projeto.setId(1);
        projeto.setNome("projeto");
        projeto.setDuracao(2000);
        projeto.setPercentagemDeConclusao(20);
        projeto.setPrecoFinal(5000);
        Tarefa tarefa=new Tarefa();
        tarefa.setPreco(1000);
        tarefa.setNome("classes");
        tarefa.setConcluida(false);
        Funcionario funcionario=new Funcionario();
        funcionario.setNome("andre");
        funcionario.setCargo(Cargo.DEV_JR);
        funcionario.setEmail("teste123@hotmail.com");
        funcionario.setPassword("algo");
        funcionario.getTarefas().add(tarefa);
        tarefa.setMyFuncionario(funcionario);
        tarefa.setMyProjeto(projeto);
        assertEquals(1,funcionario.consultarTarefasNaoConcluidas().size());


    }

    @Test
    void ditarTempo() {
        Projeto projeto=new Projeto ();
        projeto.setId(1);
        projeto.setNome("projeto");
        projeto.setDuracao(2000);
        projeto.setPercentagemDeConclusao(20);
        projeto.setPrecoFinal(5000);
        Tarefa tarefa=new Tarefa();
        tarefa.setPreco(1000);
        tarefa.setNome("classes");
        tarefa.setConcluida(false);
        Funcionario funcionario=new Funcionario();
        funcionario.setNome("andre");
        funcionario.setCargo(Cargo.DEV_JR);
        funcionario.setEmail("teste123@hotmail.com");
        funcionario.setPassword("algo");
        funcionario.getTarefas().add(tarefa);
        tarefa.setMyFuncionario(funcionario);
        tarefa.setMyProjeto(projeto);
        funcionario.DitarTempo(10,tarefa);
        assertEquals(10,tarefa.getDuracao());

    }

    @Test
    void atualizaPercentagemTarefa() {
        Projeto projeto=new Projeto ();
        projeto.setId(1);
        projeto.setNome("projeto");
        projeto.setDuracao(2000);
        projeto.setPercentagemDeConclusao(20);
        projeto.setPrecoFinal(5000);
        Tarefa tarefa=new Tarefa();
        tarefa.setPreco(1000);
        tarefa.setNome("classes");
        tarefa.setConcluida(false);
        Funcionario funcionario=new Funcionario();
        funcionario.setNome("andre");
        funcionario.setCargo(Cargo.DEV_JR);
        funcionario.setEmail("teste123@hotmail.com");
        funcionario.setPassword("algo");
        funcionario.getTarefas().add(tarefa);
        tarefa.setMyFuncionario(funcionario);
        tarefa.setMyProjeto(projeto);
        funcionario.atualizaPercentagemTarefa(tarefa);
        assertEquals(true,tarefa.getConcluida());

    }

    @Test
    void getValorHora() {
        Funcionario funcionario=new Funcionario();
        funcionario.setNome("andre");
        funcionario.setCargo(Cargo.DEV_JR);
        funcionario.setEmail("teste123@hotmail.com");
        funcionario.setPassword("algo");
        assertEquals(10,funcionario.getValorHora());
    }
}