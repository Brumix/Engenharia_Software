package EngSoftProjeto.services.usecases.facade.cliente;

import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Repositories.ClienteRepository;
import EngSoftProjeto.Repositories.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MostrarPorIdProjetoUseCase {
    private final ProjetoRepository projetoRepository;

    public MostrarPorIdProjetoUseCase(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public Optional<Projeto> findById(Long id) {
        return projetoRepository.findById(id);
    }
}
