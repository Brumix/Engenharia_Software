package engsoftprojeto.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Transient;
import javax.persistence.OneToMany;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @EqualsAndHashCode.Include
    private String nome;

    private String email;

    private String Password;

    //@Transient
    private Cargo cargo;


    @Builder.Default
    @OneToMany(mappedBy = "funcionario")
    public List<Tarefa> tarefas = new ArrayList<>();


    public int getValorHora() {
        if(cargo==null)
            return 0;
        else if (cargo.equals(Cargo.DEV_JR)) {
            return 10;
        } else if (cargo.equals(Cargo.DEV_SR)) {
            return 40;
        } else if (cargo.equals(Cargo.AN_JR)) {
            return 20;
        } else if (cargo.equals(Cargo.AN_SR)) {
            return 80;
        }
        return 0;
    }

    public ArrayList<Tarefa> consultarTarefasNaoConcluidas() {
        ArrayList<Tarefa> PorAcabar = new ArrayList<>();
        for (Tarefa tarefa : tarefas) {
            if (!tarefa.getConcluida()) {
                PorAcabar.add(tarefa);
            }

        }
        return PorAcabar;

    }

    public void DitarTempo(Integer duracao, Tarefa tar) {
        for (Tarefa tarefa : tarefas) {
            if (tar.getNome().equals(tarefa.getNome())) {
                tarefa.setDuracao(duracao);
            }
        }
    }

    public void atualizaPercentagemTarefa(Tarefa tar) {
        for (Tarefa tarefa : tarefas) {
            if (tar.getNome().equals(tarefa.getNome())) {
                tarefa.setConcluida(true);
                tarefa.getProjeto().atualizarTarefa(tar);
            }
        }
    }



}