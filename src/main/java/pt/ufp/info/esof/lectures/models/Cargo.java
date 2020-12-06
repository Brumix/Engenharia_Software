package pt.ufp.info.esof.lectures.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nome;
    private Integer SalarioHora;

    @OneToMany(mappedBy = "cargo",cascade = CascadeType.ALL)
    private List<Funcionario> funcionariosCargos =new ArrayList<>();


    public void adicionaFuncionario(Funcionario funcionario){
        if(!this.funcionariosCargos.contains(funcionario)) {
            funcionariosCargos.add(funcionario);
            funcionario.setCargo(this);
        }
    }
}
