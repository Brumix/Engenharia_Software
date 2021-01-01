package EngSoftProjeto.services.usecases.facade;


import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CriarProjetoUseCase {

    private final ProjetoRepository projetoRepository;

    @Autowired
    public CriarProjetoUseCase( ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public Optional<Projeto> criarprojeto(Projeto projeto) {
        Optional<Projeto> optionalprojeto = projetoRepository.findByNome(projeto.getNome());
        if (optionalprojeto.isEmpty()) {
            projetoRepository.save(projeto);
            return Optional.of(projeto);
        }
        return Optional.empty();
    }
}
