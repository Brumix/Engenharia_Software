package engsoftprojeto.services.usecases.facade;

import engsoftprojeto.models.Projeto;
import engsoftprojeto.models.Tarefa;

import java.util.Optional;

public interface ProjetoServiceFacadeI {
    Optional<Projeto> adicionaTarefa(Long projetoid, Tarefa tarefa);

    Optional<Projeto> criarprojeto(Projeto projeto);

    Optional<Float> mostrarEstadoProjeto(Long projetoid);

    Optional<Float> precoProjeto(Long projetoid);

    Optional<Integer> mostrarTempoProjeto(Long projetoid);
}
