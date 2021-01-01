package EngSoftProjeto.Models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Tarefa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @EqualsAndHashCode.Include
  private String nome;

  private float duracao;

  private Boolean concluida;

  @ManyToOne
  private Funcionario funcionario;

  @ManyToOne
  private Projeto projeto;

  public float calculaPreco(){
    return this.getFuncionario().getValorHora()*this.getDuracao();
  }


}