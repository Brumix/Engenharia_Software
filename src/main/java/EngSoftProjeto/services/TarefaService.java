package EngSoftProjeto.services;


import EngSoftProjeto.Models.Funcionario;
import EngSoftProjeto.Models.Tarefa;

import java.util.List;
import java.util.Optional;

public interface TarefaService{

    Optional<Tarefa> encontraTarefaPorId(Long id); //x

    Optional<Funcionario> adicionaFuncionarioAUmaTarefa(Long TarefaId,Funcionario funcionario);//x

    Optional<Tarefa>criarTarefa(Tarefa tarefa);

}