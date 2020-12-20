package EngSoftProjeto.Models;

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

  @Column(unique = true)
  private String nome;

  @OneToMany(mappedBy = "cliente")
  public  List<Projeto> projetos=new ArrayList<>();  //array de projetos de cada cliente



   public String consultarEstadoProjeto(Projeto p) {
    for (Projeto projeto : projetos)
      if (p.getNome().equals(projeto.getNome()))
        return (projeto.getNome() + " " + projeto.getPercentagemDeConclusao());


    return null;
  }

  public String  consultarDuracaoProjeto(Projeto p) {
    for (Projeto projeto : projetos)
      if (p.getNome().equals(projeto.getNome()))
        return (projeto.getNome() + " " + projeto.getDuracao());


    return null;
  }

  public String  ConsultarPrecoProjeto(Projeto p) {
    for (Projeto projeto : projetos)
      if (p.getNome().equals(projeto.getNome()))
        return (projeto.getNome() + " " + projeto.getPrecoFinal());

      return null;
  }

  public void adicionaProjecto(Projeto projeto){
     this.projetos.add(projeto);
  }

}