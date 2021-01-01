package EngSoftProjeto.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjetoDTO {
    private String nome;
    private int duracao;
    private int precoFinal;
    private float percentagemDeConclusao;
}
