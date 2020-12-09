package pt.ufp.inf.esof.projeto.models;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class Tarefa {

  private String nome;

  private int duracao;

  private Integer preco;

  private Funcionario myFuncionario;

  private Projeto myProjeto;

  private Boolean concluida;

}