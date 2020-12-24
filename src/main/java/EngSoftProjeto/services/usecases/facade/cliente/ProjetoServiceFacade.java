package EngSoftProjeto.services.usecases.facade.cliente;

import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProjetoServiceFacade implements ProjetoServiceFacadeI {
    private final AdicionaTarefaProjetoUseCase adicionaTarefaProjetoUseCase ;
    private final CriarProjetoUseCase criarProjetoUseCase;
    private final MostrarPorIdClienteUseCase mostrasPorIdUseCase;
    private final MostraTodosProjetoUseCase mostrarTodosProjetosUseCase;


    public ProjetoServiceFacade(AdicionaTarefaProjetoUseCase adicionaTarefaProjetoUseCase, CriarProjetoUseCase criarProjetoUseCase, MostrarPorIdClienteUseCase mostrasPorIdUseCase, MostraTodosProjetoUseCase mostrarTodosProjetosUseCase) {
        this.adicionaTarefaProjetoUseCase = adicionaTarefaProjetoUseCase;
        this.criarProjetoUseCase = criarProjetoUseCase;
        this.mostrasPorIdUseCase = mostrasPorIdUseCase;
        this.mostrarTodosProjetosUseCase = mostrarTodosProjetosUseCase;
    }

    @Override
    public List<Tarefa> listaTarefasPorPojeto(Projeto projeto) {
        return null;
    }

    @Override
    public List<Cliente> listaClientePorPojeto(Projeto projeto) {
        return null;
    }

    @Override
    public List<Projeto> encontraTodos() {
        return mostrarTodosProjetosUseCase.findAll();
    }

    @Override
    public Optional<Cliente> encontraId(Long id) {
        return mostrasPorIdUseCase.findById(id);
    }

    @Override
    public Optional<Projeto> criarProjeto(Projeto converter) {
        return criarProjetoUseCase.criarprojeto(converter);
    }

    @Override
    public Optional<Projeto> adicionaTarefaProjecto(Long projetoId, Tarefa tarefa) {
        return adicionaTarefaProjetoUseCase.adicionaTarefa(projetoId,tarefa);
    }
}
