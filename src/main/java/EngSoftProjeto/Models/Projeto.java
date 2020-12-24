package EngSoftProjeto.Models;

import EngSoftProjeto.Models.Cliente;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class Projeto {

  public Projeto() {
  }

  public Projeto(Long id, String nome, int duracao, Integer precoFinal, float percentagemDeConclusao, Cliente cliente, List<Tarefa> tarefas) {
    this.id = id;
    this.nome = nome;
    this.duracao = duracao;
    this.precoFinal = precoFinal;
    this.percentagemDeConclusao = percentagemDeConclusao;
    this.cliente = cliente;
    this.tarefas = tarefas;
  }

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