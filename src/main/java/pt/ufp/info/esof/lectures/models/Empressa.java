package pt.ufp.info.esof.lectures.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Empressa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany(mappedBy = "empressa",cascade = CascadeType.ALL)
    private List<Projecto> projectos =new ArrayList<>();

    public void adicionaCurso(Projecto projecto){
        if(!this.projectos.contains(projecto)){
            projectos.add(projecto);
            projecto.setEmpressa(this);
        }
    }

}
