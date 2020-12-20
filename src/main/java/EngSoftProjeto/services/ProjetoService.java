package EngSoftProjeto.services;

import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;

import java.util.List;
import java.util.Optional;

public interface ProjetoService {

    List<Projeto> encontraTodos();

    Optional<Projeto> encontraId(Long id);

    Optional<Projeto> criaProjecto(Projeto converter);

    Optional<Projeto> adicionaTarefa(Long clienteId, Tarefa tarefa);
}
