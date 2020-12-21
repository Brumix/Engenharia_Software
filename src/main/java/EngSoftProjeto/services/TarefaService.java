package EngSoftProjeto.services;


import EngSoftProjeto.Models.Funcionario;
import EngSoftProjeto.Models.Tarefa;

import java.util.List;
import java.util.Optional;

public interface TarefaService {

    List<Tarefa> encontraTodos();

    Optional<Tarefa> encontraId(Long id);

    Optional<Funcionario> adicionaFuncionario(Funcionario converter);

}
