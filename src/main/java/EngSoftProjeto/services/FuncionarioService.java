package EngSoftProjeto.services;


import EngSoftProjeto.Models.Funcionario;
import EngSoftProjeto.Models.Tarefa;

import java.util.List;
import java.util.Optional;

public interface FuncionarioService {

    List<Funcionario> encontraTodos();

    Optional<Funcionario> encontraId(Long id);

    Optional<Funcionario> criaCliente(Funcionario converter);

    Optional<Funcionario> adicionaProjecto(Long funcionarioId, Tarefa tarefa);
}
