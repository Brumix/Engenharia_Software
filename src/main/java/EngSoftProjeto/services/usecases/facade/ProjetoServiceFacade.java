package EngSoftProjeto.services.usecases.facade;

import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.services.usecases.facade.teste.AdicionaTarefaProjetoUseCase;
import EngSoftProjeto.services.usecases.facade.teste.CriarProjetoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProjetoServiceFacade implements ProjetoServiceFacadeI {
    private final AdicionaTarefaProjetoUseCase adicionaTarefaProjetoUseCase ;
    private final CriarProjetoUseCase criarProjetoUseCase;
    private final MostrarPorIdClienteUseCase mostrasPorIdUseCase;
    private final MostraTodosProjetoUseCase mostrarTodosProjetosUseCase;
    private final MostraClientePorPojetoUseCase mostraClientePorPojetoUseCase;
    private final MostraTarefaPorPojetoUseCase mostraTarefaPorPojetoUseCase;

    @Autowired
    public ProjetoServiceFacade(AdicionaTarefaProjetoUseCase adicionaTarefaProjetoUseCase, CriarProjetoUseCase criarProjetoUseCase, MostrarPorIdClienteUseCase mostrasPorIdUseCase, MostraTodosProjetoUseCase mostrarTodosProjetosUseCase, MostraClientePorPojetoUseCase mostraClientePorPojetoUseCase, MostraTarefaPorPojetoUseCase mostraTarefaPorPojetoUseCase) {
        this.adicionaTarefaProjetoUseCase = adicionaTarefaProjetoUseCase;
        this.criarProjetoUseCase = criarProjetoUseCase;
        this.mostrasPorIdUseCase = mostrasPorIdUseCase;
        this.mostrarTodosProjetosUseCase = mostrarTodosProjetosUseCase;
        this.mostraClientePorPojetoUseCase = mostraClientePorPojetoUseCase;
        this.mostraTarefaPorPojetoUseCase = mostraTarefaPorPojetoUseCase;
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

    @Override
    public List<Tarefa> mostraTarefasPorPojeto(Projeto projeto){
        return mostraTarefaPorPojetoUseCase.mostraTarefasPorPojeto(projeto);
    }

    @Override
    public Optional<Cliente> mostraClientePorPojeto(Projeto projeto){
        return mostraClientePorPojetoUseCase.mostraClientePorPojeto(projeto);
    }
}
