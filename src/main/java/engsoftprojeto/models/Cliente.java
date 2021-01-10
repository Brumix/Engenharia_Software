package engsoftprojeto.models;

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
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String nome;

  @OneToMany(mappedBy = "cliente")
  public  List<Projeto> projetos=new ArrayList<>();  //array de projetos de cada cliente


   public String consultarEstadoProjeto(Projeto p) {
    for (Projeto projeto : projetos)
      if (p.getNome().equals(projeto.getNome()))
        return (projeto.getNome() + " " + projeto.calcularPercentagemConclusao());


    return null;
  }

  public String  consultarDuracaoProjeto(Projeto p) {
    for (Projeto projeto : projetos)
      if (p.getNome().equals(projeto.getNome()))
        return (projeto.getNome() + " " + projeto.duracaoProjeto());


    return null;
  }

  public String  ConsultarPrecoProjeto(Projeto p) {
    for (Projeto projeto : projetos)
      if (p.getNome().equals(projeto.getNome()))
        return (projeto.getNome() + " " + projeto.calcularPrecoProjeto());

      return null;
  }

}