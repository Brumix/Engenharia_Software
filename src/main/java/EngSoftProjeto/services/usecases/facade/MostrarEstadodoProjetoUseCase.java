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

    public Float mostrarEstadoProjeto(Long projetoId){

        Optional<Projeto> optionalProjeto= projetoRepository.findById(projetoId);
        //return optionalProjeto.orElse(Projeto::calcularPercentagemConclusao);
        if(optionalProjeto.isPresent()){
            return optionalProjeto.get().calcularPercentagemConclusao();
        }
        return Float.NaN;
    }
}
