package EngSoftProjeto.services;


import EngSoftProjeto.Models.Funcionario;
import EngSoftProjeto.Models.Tarefa;


import java.util.List;
import java.util.Optional;


public interface FuncionarioService {

    Optional<Funcionario> encontraId(Long id);

    List<Tarefa> listarTarefasorFuncionario(Funcionario funcionario); //lista todas as tarrefas de um funcionario

    Optional<Funcionario> criaFuncionario(Funcionario funcionario);

}