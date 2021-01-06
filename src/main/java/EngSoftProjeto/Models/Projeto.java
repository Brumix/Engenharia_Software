package EngSoftProjeto.Models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Projeto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @EqualsAndHashCode.Include
    private String nome;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "projeto",cascade=CascadeType.ALL )
    public List<Tarefa> tarefas = new ArrayList<>();


    public float calcularPrecoProjeto() {
        float custo = 0;
        for (Tarefa tarefa : tarefas) {
            custo += tarefa.calculaPreco();
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
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getConcluida()) count++;
        }
        return (count / tarefas.size()) * 100;
    }

    public void atualizarTarefa(Tarefa tarefa) {
        for (Tarefa tar : tarefas) {
            if (tar.getNome().equals(tarefa.getNome())) tar.setConcluida(true);
        }
    }


}