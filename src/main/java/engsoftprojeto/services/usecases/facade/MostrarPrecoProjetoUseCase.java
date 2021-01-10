package engsoftprojeto.services.usecases.facade;

import engsoftprojeto.models.Projeto;
import engsoftprojeto.repositories.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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
