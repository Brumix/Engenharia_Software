package pt.ufp.inf.esof.projeto.models;

<<<<<<< HEAD
import EngSoftProjeto.Models.Cargo;
import EngSoftProjeto.Models.Funcionario;
import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;
=======
>>>>>>> 7c95394a7f6115ceaa38553fdc1a086196c6b9b4
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

<<<<<<< HEAD

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
=======
    @Test
    void consultarTarefasNaoConcluidas() {
        Projeto projeto=new Projeto ();
        projeto.setId(1);
>>>>>>> 7c95394a7f6115ceaa38553fdc1a086196c6b9b4
        projeto.setNome("projeto");
        projeto.setDuracao(2000);
        projeto.setPercentagemDeConclusao(20);
        projeto.setPrecoFinal(5000);
<<<<<<< HEAD
        Tarefa tarefa = new Tarefa();
        tarefa.setPreco(1000);
        tarefa.setNome("classes");
        tarefa.setConcluida(false);
        Funcionario funcionario = new Funcionario();
=======
        Tarefa tarefa=new Tarefa();
        tarefa.setPreco(1000);
        tarefa.setNome("classes");
        tarefa.setConcluida(false);
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
        assertEquals(1, funcionario.consultarTarefasNaoConcluidas().size());
=======
        tarefa.setMyFuncionario(funcionario);
        tarefa.setMyProjeto(projeto);
        assertEquals(1,funcionario.consultarTarefasNaoConcluidas().size());
>>>>>>> 7c95394a7f6115ceaa38553fdc1a086196c6b9b4


    }

    @Test
    void ditarTempo() {
<<<<<<< HEAD
        Projeto projeto = new Projeto();
        projeto.setId(1L);
=======
        Projeto projeto=new Projeto ();
        projeto.setId(1);
>>>>>>> 7c95394a7f6115ceaa38553fdc1a086196c6b9b4
        projeto.setNome("projeto");
        projeto.setDuracao(2000);
        projeto.setPercentagemDeConclusao(20);
        projeto.setPrecoFinal(5000);
<<<<<<< HEAD
        Tarefa tarefa = new Tarefa();
        tarefa.setPreco(1000);
        tarefa.setNome("classes");
        tarefa.setConcluida(false);
        Funcionario funcionario = new Funcionario();
=======
        Tarefa tarefa=new Tarefa();
        tarefa.setPreco(1000);
        tarefa.setNome("classes");
        tarefa.setConcluida(false);
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
        funcionario.DitarTempo(10, tarefa);
        assertEquals(10, tarefa.getDuracao());
=======
        tarefa.setMyFuncionario(funcionario);
        tarefa.setMyProjeto(projeto);
        funcionario.DitarTempo(10,tarefa);
        assertEquals(10,tarefa.getDuracao());
>>>>>>> 7c95394a7f6115ceaa38553fdc1a086196c6b9b4

    }

    @Test
    void atualizaPercentagemTarefa() {
<<<<<<< HEAD
        Projeto projeto = new Projeto();
        projeto.setId(1L);
=======
        Projeto projeto=new Projeto ();
        projeto.setId(1);
>>>>>>> 7c95394a7f6115ceaa38553fdc1a086196c6b9b4
        projeto.setNome("projeto");
        projeto.setDuracao(2000);
        projeto.setPercentagemDeConclusao(20);
        projeto.setPrecoFinal(5000);
<<<<<<< HEAD
        Tarefa tarefa = new Tarefa();
        tarefa.setPreco(1000);
        tarefa.setNome("classes");
        tarefa.setConcluida(false);
        Funcionario funcionario = new Funcionario();
=======
        Tarefa tarefa=new Tarefa();
        tarefa.setPreco(1000);
        tarefa.setNome("classes");
        tarefa.setConcluida(false);
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
        funcionario.atualizaPercentagemTarefa(tarefa);
        assertEquals(true, tarefa.getConcluida());
=======
        tarefa.setMyFuncionario(funcionario);
        tarefa.setMyProjeto(projeto);
        funcionario.atualizaPercentagemTarefa(tarefa);
        assertEquals(true,tarefa.getConcluida());
>>>>>>> 7c95394a7f6115ceaa38553fdc1a086196c6b9b4

    }

    @Test
<<<<<<< HEAD
    void getValorHoraCargoDEV_JR() {
        Funcionario funcionario = new Funcionario();
=======
    void getValorHora() {
        Funcionario funcionario=new Funcionario();
>>>>>>> 7c95394a7f6115ceaa38553fdc1a086196c6b9b4
        funcionario.setNome("andre");
        funcionario.setCargo(Cargo.DEV_JR);
        funcionario.setEmail("teste123@hotmail.com");
        funcionario.setPassword("algo");
<<<<<<< HEAD
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
=======
        assertEquals(10,funcionario.getValorHora());
>>>>>>> 7c95394a7f6115ceaa38553fdc1a086196c6b9b4
    }
}