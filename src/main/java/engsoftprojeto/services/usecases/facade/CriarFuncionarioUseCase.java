package engsoftprojeto.services.usecases.facade;


import engsoftprojeto.models.Funcionario;
import engsoftprojeto.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CriarFuncionarioUseCase  {

    private final FuncionarioRepository funcionarioRepository;


    @Autowired
    public CriarFuncionarioUseCase(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;

    }


    public Optional<Funcionario> criarfuncionario(Funcionario funcionario) {
        Optional<Funcionario> optionalFuncionario = funcionarioRepository.findByNome(funcionario.getNome());

        if (optionalFuncionario.isEmpty()) {

            funcionarioRepository.save(funcionario);
            return Optional.of(funcionario);
        }
        return Optional.empty();
    }


    }

