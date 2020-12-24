package EngSoftProjeto.services.usecases.facade.cliente;

import EngSoftProjeto.Models.Funcionario;

import java.util.List;
import java.util.Optional;

public interface FuncionarioServiceFacadeI {

    List<Funcionario> mostrarTodosProjetos();

    Optional<Funcionario> encontraProjetosId(Long id);
}
