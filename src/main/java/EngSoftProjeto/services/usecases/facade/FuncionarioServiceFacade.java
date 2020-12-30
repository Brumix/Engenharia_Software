package EngSoftProjeto.services.usecases.facade;

import EngSoftProjeto.Models.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioServiceFacade {
    private final CriarFuncionarioUseCase criarFuncionarioUseCase;

        @Autowired
    public FuncionarioServiceFacade(CriarFuncionarioUseCase criarFuncionarioUseCase) {
        this.criarFuncionarioUseCase = criarFuncionarioUseCase;
    }

    public Optional<Funcionario>criarfuncionario(Funcionario funcionario){
        return criarFuncionarioUseCase.criarfuncionario(funcionario);
    }
}
