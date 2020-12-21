package EngSoftProjeto.services;


import EngSoftProjeto.Models.Tarefa;

import java.util.List;
import java.util.Optional;

public interface TarefaService {

    List<Tarefa> encontraTodos();

    Optional<Tarefa> encontraId(Long id);

    Optional<Tarefa> criaProjecto(Tarefa converter);

}
