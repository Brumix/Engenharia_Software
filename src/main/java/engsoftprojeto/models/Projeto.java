package engsoftprojeto.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

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