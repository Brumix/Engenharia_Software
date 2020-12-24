package EngSoftProjeto.services.usecases.facade.cliente;


import EngSoftProjeto.Models.Funcionario;
import EngSoftProjeto.Repositories.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MostraPorIdFuncionarioUseCase {

    private final FuncionarioRepository funcionarioRepository;

    public MostraPorIdFuncionarioUseCase(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }
    public Optional<Funcionario> findById(Long id) {
        return funcionarioRepository.findById(id);
    }
}



