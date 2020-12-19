package EngSoftProjeto.Models;

import EngSoftProjeto.Models.Cliente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Projeto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  private int duracao;

  private Integer precoFinal;

  private float percentagemDeConclusao;

  @ManyToOne
  private Cliente cliente;

  @OneToMany(mappedBy = "projeto")
  public List<Tarefa> tarefas =new ArrayList<Tarefa>();


  public float calcularPrecoProjeto() {
    float custo = 0;
    for (Tarefa tarefa : tarefas) {
      custo += tarefa.getPreco();
    }
    return custo;
  }

  public int duracaoProjeto() {
    int custoTemporal = 0;
    for (Tarefa tarefa : tarefas) {
      custoTemporal += tarefa.getDuracao();
    }
    return custoTemporal;
  }

  public float calcularPercentagemConclusao() {
    float count = 0;
    for (Tarefa tarefa:tarefas) {
      if(tarefa.getConcluida())count++;
    }
    return (count/tarefas.size())*100;
  }

  public void atualizarTarefa(Tarefa tarefa){
    for (Tarefa tar: tarefas) {
      if(tar.getNome().equals(tarefa.getNome())) tar.setConcluida(true);
    }
  }

}