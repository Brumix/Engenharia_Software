package EngSoftProjeto.services.usecases.facade;

import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Repositories.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MostrarTempoPorProjetoUseCase {
    private final ProjetoRepository projetoRepository;

    public MostrarTempoPorProjetoUseCase(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public Integer mostrarTempoProjeto(Long projetoId){
        Optional<Projeto>optionalProjeto=projetoRepository.findById(projetoId);
        if(optionalProjeto.isPresent()){
            return optionalProjeto.get().duracaoProjeto();
        }
        return -1 ;
    }
}
