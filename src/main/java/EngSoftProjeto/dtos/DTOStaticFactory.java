package EngSoftProjeto.dtos;

import EngSoftProjeto.Models.Projeto;

import java.util.stream.Collectors;

public class DTOStaticFactory {
    /**
     *
     * Implementa a lógica necessária para garantir uma única instância da fábrica estática
     */
    private static DTOStaticFactory dtoAbstractFactory;

    private DTOStaticFactory() {
    }

    public static DTOStaticFactory getInstance(){
        if(dtoAbstractFactory==null){
            dtoAbstractFactory=new DTOStaticFactory();
        }
        return dtoAbstractFactory;
    }

    public ProjetoDTO convertToProjetoDTO(Projeto projeto) {
        return ProjetoDTO.builder()
                .duracao(projeto.duracaoProjeto())
                .nome(projeto.getNome())
                .precoFinal((int)projeto.calcularPrecoProjeto())
                .percentagemDeConclusao(projeto.calcularPercentagemConclusao())
                .build();
    }
}
