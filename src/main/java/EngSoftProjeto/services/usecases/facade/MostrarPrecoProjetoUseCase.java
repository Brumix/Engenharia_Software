package EngSoftProjeto.services.usecases.facade;

import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class MostrarPrecoProjetoUseCase {

    private final ProjetoRepository projetoRepository;

    public MostrarPrecoProjetoUseCase(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public Optional<Float> precoProjeto(Long projetoId){

        Optional<Projeto> optionalProjeto= projetoRepository.findById(projetoId);
        return optionalProjeto.map(Projeto::calcularPrecoProjeto);
    }
}
