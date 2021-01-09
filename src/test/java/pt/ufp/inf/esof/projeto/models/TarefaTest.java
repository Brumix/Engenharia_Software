package pt.ufp.inf.esof.projeto.models;

import EngSoftProjeto.Models.Tarefa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TarefaTest {


    @Test
    void getIdTarefaTest(){

        Tarefa tarefa= new Tarefa();
        tarefa.setId(1L);
        assertEquals(1L,tarefa.getId());
    }
}
