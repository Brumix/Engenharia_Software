package pt.ufp.inf.esof.projeto.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter

public class Projeto {
    private Integer id;

    private String nome;
    private int duracao;

    private Integer precoFinal;

    private float PercentagemDeConclusao;

    private Cliente myCliente;

    /**
     * @element-type Tarefa
     */
    private List<Tarefa> tarefas = new ArrayList<>();

    public float calcularPrecoProjeto() {
        float custo = 0;
        for (Tarefa tarefa : tarefas) {
            custo += tarefa.getPreco();
        }
        return custo;
    }

    public int duracaoProjeto() {
        int custoTemporal = 0;
        for (Tarefa tarefa : tarefas) {
            custoTemporal += tarefa.getDuracao();
        }
        return custoTemporal;
    }

    public float calcularPercentagemConclusao() {
        float count = 0;
        for (Tarefa tarefa:tarefas) {
            if(tarefa.getConcluida())count++;
        }
        return (count/tarefas.size())*100;
    }

    public void atualizarTarefa(Tarefa tarefa){
        for (Tarefa tar: tarefas) {
            if(tar.getNome().equals(tarefa.getNome())) tar.setConcluida(true);
        }
    }
}