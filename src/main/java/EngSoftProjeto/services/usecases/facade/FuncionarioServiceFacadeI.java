package EngSoftProjeto.services.usecases.facade;

import EngSoftProjeto.Models.Funcionario;
import EngSoftProjeto.Models.Tarefa;

import java.util.List;
import java.util.Optional;

public interface FuncionarioServiceFacadeI {
    List<Funcionario> mostrarTodos();

    Optional<Funcionario> encontraProjetosId(Long id);

    Optional<Funcionario> criaFuncionario(Funcionario funcionario);

    List<Tarefa> mostrarTarefasorFuncionario(Funcionario funcionario);
}
