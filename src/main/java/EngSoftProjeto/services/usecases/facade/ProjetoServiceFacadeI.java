package EngSoftProjeto.services.usecases.facade;

import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;

import java.util.Optional;

public interface ProjetoServiceFacadeI {
    Optional<Projeto> adicionaTarefa(Long projetoid, Tarefa tarefa);

    Optional<Projeto> criarprojeto(Projeto projeto);

    Float mostrarEstadoProjeto(Long projetoid);

    Float precoProjeto(Long projetoid);

    Integer mostrarTempoProjeto(Long projetoid);
}
