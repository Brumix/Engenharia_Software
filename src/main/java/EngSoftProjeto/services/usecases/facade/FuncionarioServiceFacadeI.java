package EngSoftProjeto.services.usecases.facade;

import EngSoftProjeto.Models.Funcionario;

import java.util.Optional;

public interface FuncionarioServiceFacadeI {
    Optional<Funcionario> criarfuncionario(Funcionario funcionario);
}
