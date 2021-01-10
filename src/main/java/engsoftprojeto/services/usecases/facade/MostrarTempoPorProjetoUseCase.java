package engsoftprojeto.services.usecases.facade;

import engsoftprojeto.models.Projeto;
import engsoftprojeto.repositories.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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
