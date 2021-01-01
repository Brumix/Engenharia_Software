package EngSoftProjeto.dtos;

import EngSoftProjeto.Models.Funcionario;
import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TarefaCreateDTO implements CreateDTO<Tarefa>{

    private String nome;
    private float duracao;
    private Boolean concluida;
    private String nomeFuncionario;
    private String nomeProjeto;

    @Override
    public Tarefa converter() {
        Tarefa tarefa=new Tarefa();
        tarefa.setNome(nome);
        tarefa.setDuracao(duracao);
        return tarefa;
    }
}
