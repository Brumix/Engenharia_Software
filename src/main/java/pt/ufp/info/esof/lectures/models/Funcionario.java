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
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @ManyToOne
    private Cargo cargo;

    @JsonIgnore
    @ManyToMany(mappedBy = "funcionarios")
    private final List<Tarefa> tarefas =new ArrayList<>();

   /*@JsonProperty(value = "nomeCadeiras")
   public List<String> teste(){
        return tarefas.stream().map(Tarefa::getNome).collect(Collectors.toList());
    }*/





}
