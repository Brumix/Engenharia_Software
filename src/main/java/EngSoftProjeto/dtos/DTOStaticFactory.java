package EngSoftProjeto.dtos;

import EngSoftProjeto.Models.Cargo;
import EngSoftProjeto.Models.Funcionario;
import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class DTOStaticFactory {
    /**
     * Implementa a lógica necessária para garantir uma única instância da fábrica estática
     */
    private static DTOStaticFactory dtoAbstractFactory;

    private DTOStaticFactory() {
    }

    public static DTOStaticFactory getInstance() {
        if (dtoAbstractFactory == null) {
            dtoAbstractFactory = new DTOStaticFactory();
        }
        return dtoAbstractFactory;
    }

    public ProjetoDTO convertToProjetoDTO(Projeto projeto) {
        return ProjetoDTO.builder().nome(projeto.getNome()).build();
    }

    public Projeto convertToProjeto(ProjetoDTO projetoDTO) {
        return Projeto.builder().nome(projetoDTO.getNome()).build();

    }

    public TarefaDTO convertToTarefasDTO(Tarefa tarefa) {
        return TarefaDTO.builder().nome(tarefa.getNome()).duracao(tarefa.getDuracao())
                .build();
    }

    public Tarefa convertToTarefa(TarefaDTO tarefaDTO) {
        return Tarefa.builder().nome(tarefaDTO.getNome())
                .duracao(tarefaDTO.getDuracao())
                .build();
    }

    public FuncionarioDTO convertToFuncionarioDTO(Funcionario funcionario){
        return FuncionarioDTO.builder().cargo( funcionario.getCargo().toString())
                .email(funcionario.getEmail())
                .password(funcionario.getPassword())
                .nome(funcionario.getNome())
                .build();
    }

    public  Funcionario convertToFuncionario(FuncionarioDTO funcionarioDTO){
        return Funcionario.builder().nome(funcionarioDTO.getNome())
                .cargo(funcionarioDTO.getCargoFromStr(funcionarioDTO.getCargo()))
                .Password(funcionarioDTO.getPassword())
                .email(funcionarioDTO.getEmail())
                .build();
    }
}
