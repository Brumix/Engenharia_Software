package EngSoftProjeto.services;


import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;

import java.util.List;
import java.util.Optional;

public interface ProjetoService {

    List<Tarefa> mostraTarefasPorPojeto(Projeto projeto);

    List<Cliente> mostraClientePorPojeto(Projeto projeto);

    List<Projeto> encontraTodos();

    Optional<Cliente> encontraId(Long id);

    Optional<Projeto> criarProjeto(Projeto converter);

    Optional<Projeto> adicionaTarefaProjecto(Long projetoId, Tarefa tarefa);
}
