package EngSoftProjeto.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Tarefa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  private int duracao;

  private Integer preco;

  private Boolean concluida;

  @ManyToOne
  private Funcionario funcionario;


  @ManyToOne
  private Projeto projeto;


}