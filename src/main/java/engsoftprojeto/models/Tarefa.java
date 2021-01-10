package engsoftprojeto.models;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;

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

  @ManyToOne(cascade = CascadeType.ALL)
  private Funcionario funcionario;

  @ManyToOne
  private Projeto projeto;

  public float calculaPreco(){
    return this.getFuncionario().getValorHora()*this.getDuracao();
  }


}