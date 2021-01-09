package EngSoftProjeto.services.usecases.facade;

import EngSoftProjeto.Models.Funcionario;
import EngSoftProjeto.Models.Tarefa;

import java.util.Optional;

public interface TarefaServiceFacadeI {
    Optional<Tarefa> adicionaFuncionario(Long tarefaid, Funcionario funcionario);

    Optional<Tarefa> atualizaTarefa(Long tarefaid);

    Optional<Tarefa> criarTarefa(Tarefa tarefa);

    Optional<Float> tempoExecucaoTarefa(Long tarefaid);
}
