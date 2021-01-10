package engsoftprojeto.services.usecases.facade;

import engsoftprojeto.models.Funcionario;

import java.util.Optional;

public interface FuncionarioServiceFacadeI {
    Optional<Funcionario> criarfuncionario(Funcionario funcionario);
}
