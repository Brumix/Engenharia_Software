package EngSoftProjeto.services.usecases.facade;

import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;

import java.util.Optional;

public interface ProjetoServiceFacadeI {
    Optional<Projeto> adicionaTarefa(Long projetoid, Tarefa tarefa);

    Optional<Projeto> criarprojeto(Projeto projeto);

    Optional<Projeto> mostrarEstadoProjeto(Long projetoid);

    Optional<Float> precoProjeto(Long projetoid);

    Optional<Integer> mostrarTempoProjeto(Long projetoid);
}
