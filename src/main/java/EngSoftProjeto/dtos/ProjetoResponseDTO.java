package EngSoftProjeto.dtos;

import EngSoftProjeto.Models.Projeto;
import lombok.*;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjetoResponseDTO {
    private String nome;
    private int duracao;
    private int precoFinal;
    private float percentagemDeConclusao;
    private String nomeCliente;
    public List<TarefaDTO> tarefas =new ArrayList<>();

    public ProjetoResponseDTO(Projeto projeto){
        duracao=projeto.duracaoProjeto();
    }
}
