package pt.ufp.info.esof.lectures.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Projecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany(mappedBy = "projecto",cascade = CascadeType.ALL)
    private List<Tarefa> tarefas =new ArrayList<>();
    @ManyToOne
    private Empressa empressa;

    public void adicionaCadeira(Tarefa tarefa){
        if(!this.tarefas.contains(tarefa)){
            tarefas.add(tarefa);
            tarefa.setProjecto(this);
        }
    }

}
