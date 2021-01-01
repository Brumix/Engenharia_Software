package EngSoftProjeto.dtos;

import EngSoftProjeto.Models.Projeto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoCreateDTO implements CreateDTO<Projeto>{
    Logger logger= LoggerFactory.getLogger(this.getClass());

    private String nome;
    private int precoFinal;
    private int duracao;
    private String nomeCliente;

    @Override
    public Projeto converter(){
        logger.info("Convertido para Modelo");
        Projeto projeto=new Projeto();
        projeto.setNome(this.getNome());
        return projeto;
    }
}