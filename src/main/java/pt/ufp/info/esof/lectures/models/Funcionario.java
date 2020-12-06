package pt.ufp.info.esof.lectures.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@EqualsAndHashCode(callSuper = true)
public class Funcionario extends Utilizador{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    @JsonIgnore
    @ManyToMany(mappedBy = "explicadores")
    private final List<Tarefa> tarefas =new ArrayList<>();

    @JsonProperty(value = "nomeCadeiras")
    public List<String> teste(){
        return tarefas.stream().map(Tarefa::getNome).collect(Collectors.toList());
    }



    public void adicionaCadeira(Tarefa tarefa){
        if(!this.tarefas.contains(tarefa)){
            this.tarefas.add(tarefa);
            tarefa.adicionaExplicador(this);
        }
    }


}
