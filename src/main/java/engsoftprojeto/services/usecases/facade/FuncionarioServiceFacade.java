package engsoftprojeto.services.usecases.facade;

import engsoftprojeto.models.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioServiceFacade implements FuncionarioServiceFacadeI {
    private final CriarFuncionarioUseCase criarFuncionarioUseCase;

        @Autowired
    public FuncionarioServiceFacade(CriarFuncionarioUseCase criarFuncionarioUseCase) {
        this.criarFuncionarioUseCase = criarFuncionarioUseCase;
    }

    @Override
    public Optional<Funcionario>criarfuncionario(Funcionario funcionario){
        return criarFuncionarioUseCase.criarfuncionario(funcionario);
    }
}
