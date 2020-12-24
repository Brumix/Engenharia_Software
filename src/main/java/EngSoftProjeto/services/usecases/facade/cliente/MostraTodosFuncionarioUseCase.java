package EngSoftProjeto.services.usecases.facade.cliente;


import EngSoftProjeto.Models.Funcionario;
import EngSoftProjeto.Repositories.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MostraTodosFuncionarioUseCase {

    private final FuncionarioRepository funcionarioRepository;

    public MostraTodosFuncionarioUseCase(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> findAll() {
        return (List<Funcionario>) funcionarioRepository.findAll();
    }

}
