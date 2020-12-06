package pt.ufp.info.esof.lectures.models;


import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    private List<Projecto> projectos =new ArrayList<>();




    public void adicionaProjecto(Projecto projecto){
        if(!this.projectos.contains(projecto)) {
            projectos.add(projecto);
            projecto.setCliente(this);
        }
    }

}
