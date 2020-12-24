package EngSoftProjeto.services;


import EngSoftProjeto.Models.Funcionario;
import EngSoftProjeto.Models.Tarefa;

import java.util.List;
import java.util.Optional;

public interface TarefaService{

    Optional<Tarefa> encontraTarefaPorId(Long id);

    Optional<Funcionario> adicionaFuncionarioAUmaTarefa(Funcionario funcionario,Tarefa tarefa);

    Optional<Tarefa>criarTarefa(Tarefa tarefa);

}