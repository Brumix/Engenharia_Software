package EngSoftProjeto.services.usecases.facade;

import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Repositories.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MostrarEstadodoProjetoUseCase {

    private final ProjetoRepository projetoRepository;

    public MostrarEstadodoProjetoUseCase(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public Optional<Projeto> mostrarEstadoProjeto(Long projetoId){

        Optional<Projeto> optionalProjeto= projetoRepository.findById(projetoId);
        if(optionalProjeto.isPresent()) {
            optionalProjeto.get().setPercentagemDeConclusao(optionalProjeto.get().calcularPercentagemConclusao());
            return optionalProjeto;
        }
        return Optional.empty();
    }
}
