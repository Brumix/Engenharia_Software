package EngSoftProjeto.services;


import EngSoftProjeto.Models.Funcionario;
import EngSoftProjeto.Models.Tarefa;

import java.util.List;
import java.util.Optional;

public interface FuncionarioService {

    List<Funcionario> encontraTodos();

    Optional<Funcionario> encontraId(Long id);

    List<Funcionario> listarTareProjetosncionario(Projeto pojeto);  //lista todos os pojetFuncio funcionario

    Optional<Funcionario> criaFuncionario(Funcionario funcionario);

}
