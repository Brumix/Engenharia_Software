package pt.ufp.inf.esof.projeto.models;

import EngSoftProjeto.Models.Cargo;
import EngSoftProjeto.Models.Funcionario;
import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {


    @Test
    void getIdTest() {

        Funcionario funcionario = new Funcionario();
        funcionario.setId(1L);
        assertEquals(1L, funcionario.getId());
    }

    @Test
    void consultarTarefasNaoConcluidas() {
        Projeto projeto = new Projeto();
        projeto.setId(1L);
        projeto.setNome("projeto");
        Tarefa tarefa = new Tarefa();
        tarefa.setNome("classes");
        tarefa.setConcluida(false);
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("andre");
        funcionario.setCargo(Cargo.DEV_JR);
        funcionario.setEmail("teste123@hotmail.com");
        funcionario.setPassword("algo");
        funcionario.getTarefas().add(tarefa);
        tarefa.setFuncionario(funcionario);
        tarefa.setProjeto(projeto);
        assertEquals(1, funcionario.consultarTarefasNaoConcluidas().size());


    }

    @Test
    void ditarTempo() {
        Projeto projeto = new Projeto();
        projeto.setId(1L);
        projeto.setNome("projeto");
        Tarefa tarefa = new Tarefa();
        tarefa.setNome("classes");
        tarefa.setConcluida(false);
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("andre");
        funcionario.setCargo(Cargo.DEV_JR);
        funcionario.setEmail("teste123@hotmail.com");
        funcionario.setPassword("algo");
        funcionario.getTarefas().add(tarefa);
        tarefa.setFuncionario(funcionario);
        tarefa.setProjeto(projeto);
        funcionario.DitarTempo(10, tarefa);
        assertEquals(10, tarefa.getDuracao());

    }

    @Test
    void atualizaPercentagemTarefa() {
        Projeto projeto = new Projeto();
        projeto.setId(1L);
        projeto.setNome("projeto");
        Tarefa tarefa = new Tarefa();
        tarefa.setNome("classes");
        tarefa.setConcluida(false);
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("andre");
        funcionario.setCargo(Cargo.DEV_JR);
        funcionario.setEmail("teste123@hotmail.com");
        funcionario.setPassword("algo");
        funcionario.getTarefas().add(tarefa);
        tarefa.setFuncionario(funcionario);
        tarefa.setProjeto(projeto);
        funcionario.atualizaPercentagemTarefa(tarefa);
        assertEquals(true, tarefa.getConcluida());

    }

    @Test
    void getValorHoraCargoDEV_JR() {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("andre");
        funcionario.setCargo(Cargo.DEV_JR);
        funcionario.setEmail("teste123@hotmail.com");
        funcionario.setPassword("algo");
        assertEquals(10, funcionario.getValorHora());
    }

    @Test
    void getValorHoraCargoDEV_SR() {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("andre");
        funcionario.setCargo(Cargo.DEV_SR);
        funcionario.setEmail("teste123@hotmail.com");
        funcionario.setPassword("algo");
        assertEquals(40, funcionario.getValorHora());
    }

    @Test
    void getValorHoraCargoAN_JR() {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("andre");
        funcionario.setCargo(Cargo.AN_JR);
        funcionario.setEmail("teste123@hotmail.com");
        funcionario.setPassword("algo");
        assertEquals(20, funcionario.getValorHora());
    }

    @Test
    void getCargoNExits() {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("andre");
        funcionario.setCargo(Cargo.SEMCARGO);
        assertEquals(0, funcionario.getValorHora());
    }

    @Test
    void getValorHoraCargoAN_SR() {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("andre");
        funcionario.setCargo(Cargo.AN_SR);
        funcionario.setEmail("teste123@hotmail.com");
        funcionario.setPassword("algo");
        assertEquals(80, funcionario.getValorHora());
    }

    @Test
    void getValorHoraZero() {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("bruno");
        assertEquals(funcionario.getValorHora(), 0);
    }

    @Test
    void testName() {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("bruno");
        assertEquals("bruno", funcionario.getNome());
    }

    @Test
    void testEmail() {
        Funcionario funcionario = new Funcionario();
        funcionario.setEmail("email@email.com");
        assertEquals("email@email.com", funcionario.getEmail());
    }

    @Test
    void testPassword() {
        Funcionario funcionario = new Funcionario();
        funcionario.setPassword("password");
        assertEquals("password", funcionario.getPassword());
    }

    @Test
    void testCargo() {
        Funcionario funcionario = new Funcionario();
        funcionario.setCargo(Cargo.DEV_JR);
        assertEquals(Cargo.DEV_JR, funcionario.getCargo());
    }
}