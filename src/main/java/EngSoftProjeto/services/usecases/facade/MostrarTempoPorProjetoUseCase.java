package EngSoftProjeto.services.usecases.facade;

import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.Repositories.ProjetoRepository;

import java.util.Optional;

public class MostrarTempoPorProjetoUseCase {
    private final ProjetoRepository projetoRepository;

    public MostrarTempoPorProjetoUseCase(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public Optional<Integer> mostrarTempoProjeto(Long projetoId){
        Optional<Projeto>optionalProjeto=projetoRepository.findById(projetoId);
        return optionalProjeto.map(Projeto::duracaoProjeto);
    }
}
