package EngSoftProjeto.services.usecases.facade.cliente;

import EngSoftProjeto.Models.Funcionario;
import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Repositories.FuncionarioRepository;
import EngSoftProjeto.Repositories.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MostraTodosProjetoUseCase {
    private final ProjetoRepository projetoRepository;

    public MostraTodosProjetoUseCase(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public List<Projeto> findAll() {
        return (List<Projeto>) projetoRepository.findAll();
    }
}
