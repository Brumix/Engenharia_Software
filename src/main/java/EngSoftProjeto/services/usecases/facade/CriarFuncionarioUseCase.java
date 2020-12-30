package EngSoftProjeto.services.usecases.facade;

import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Models.Funcionario;
import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.Repositories.ClienteRepository;
import EngSoftProjeto.Repositories.FuncionarioRepository;
import EngSoftProjeto.Repositories.ProjetoRepository;
import EngSoftProjeto.Repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CriarFuncionarioUseCase implements CriarFuncionarioUseCaseI {

    private final FuncionarioRepository funcionarioRepository;


    @Autowired
    public CriarFuncionarioUseCase(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;

    }

    @Override
    public Optional<Funcionario> criarfuncionario(Funcionario funcionario) {
        Optional<Funcionario> optionalFuncionario = funcionarioRepository.findByNome(funcionario.getNome());

        if (optionalFuncionario.isEmpty()) {
          //  System.out.println("nao ta empty ");
            funcionarioRepository.save(funcionario);
            return Optional.of(funcionario);
        }
        return Optional.empty();
    }


    }

