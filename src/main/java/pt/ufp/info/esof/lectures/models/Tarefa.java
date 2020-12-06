package pt.ufp.info.esof.lectures.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne
    private Projecto projecto;
    @ManyToMany
    private List<Funcionario> explicadores=new ArrayList<>();

    public void adicionaExplicador(Funcionario funcionario) {
        if(!this.explicadores.contains(funcionario)){
            this.explicadores.add(funcionario);
        }
    }
}
