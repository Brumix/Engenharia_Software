package EngSoftProjeto.services.usecases.facade;

import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Repositories.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MostrarPrecoProjetoUseCase {

    private final ProjetoRepository projetoRepository;

    public MostrarPrecoProjetoUseCase(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public Float precoProjeto(Long projetoId){

        Optional<Projeto> optionalProjeto= projetoRepository.findById(projetoId);
        return optionalProjeto.map(Projeto::calcularPrecoProjeto).orElse(Float.NaN);
    }
}
