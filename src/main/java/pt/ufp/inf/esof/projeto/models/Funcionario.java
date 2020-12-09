package pt.ufp.inf.esof.projeto.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class Funcionario {

  private String nome;

  private String email;

  private String Password;

  private Cargo cargo;

  /**
   * @element-type Tarefa
   */
  private  ArrayList<Tarefa> tarefas = new ArrayList<>();

  public float getValorHora(){
    if(cargo.equals(Cargo.DEV_JR)){
      return 10;
    }
    if(cargo.equals(Cargo.DEV_SR)){
      return 40;
    }
    if(cargo.equals(Cargo.AN_JR)){
      return 20;
    }
    if(cargo.equals(Cargo.AN_SR)){
      return 80;
    }
    return 0;
  }

  public ArrayList<Tarefa> consultarTarefasNaoConcluidas() {
    ArrayList<Tarefa> PorAcabar=new ArrayList<>();
    for (Tarefa tarefa : tarefas) {
      if(!tarefa.getConcluida()){
        PorAcabar.add(tarefa);
      }

    }
    return PorAcabar;

  }

  public void DitarTempo(Integer duracao, Tarefa tar) {
    for (Tarefa tarefa : tarefas) {
      if(tar.getNome().equals(tarefa.getNome())){
        tarefa.setDuracao(duracao);
      }
    }
  }

  public void atualizaPercentagemTarefa(Tarefa tar){
    for (Tarefa tarefa : tarefas){
      if (tar.getNome().equals(tarefa.getNome())){
        tarefa.setConcluida(true);
        tarefa.getMyProjeto().atualizarTarefa(tar);
      }
    }
  }
}