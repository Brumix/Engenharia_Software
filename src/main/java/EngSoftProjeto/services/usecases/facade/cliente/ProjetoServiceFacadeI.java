package EngSoftProjeto.services.usecases.facade.cliente;

import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;

import java.util.List;
import java.util.Optional;

public interface ProjetoServiceFacadeI {
    List<Projeto> encontraTodos();

    Optional<Cliente> encontraId(Long id);

    Optional<Projeto> criarProjeto(Projeto converter);

    Optional<Projeto> adicionaTarefaProjecto(Long projetoId, Tarefa tarefa);

    List<Tarefa> mostraTarefasPorPojeto(Projeto projeto);

    Optional<Cliente> mostraClientePorPojeto(Projeto projeto);
}
