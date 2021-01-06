package EngSoftProjeto.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TarefaDTO {
    private String nome;
    private float duracao;
   // private FuncionarioDTO funcionario;
    //private ProjetoDTO projeto;
}
