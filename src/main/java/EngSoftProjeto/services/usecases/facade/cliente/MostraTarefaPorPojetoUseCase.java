package EngSoftProjeto.services.usecases.facade.cliente;

import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.Repositories.ClienteRepository;
import EngSoftProjeto.Repositories.ProjetoRepository;
import EngSoftProjeto.Repositories.TarefaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MostraTarefaPorPojetoUseCase {

    private final ProjetoRepository projetoRepository;
    private final TarefaRepository tarefaRepository;

    public MostraTarefaPorPojetoUseCase(ProjetoRepository projetoRepository, TarefaRepository tarefaRepository) {
        this.projetoRepository = projetoRepository;
        this.tarefaRepository = tarefaRepository;

    }

    public List<Tarefa> mostraTarefasPorPojeto(Projeto projeto) {
        List<Tarefa> tarefas = new ArrayList<>();
        tarefaRepository.findAll().forEach(tarefa -> {
            if (projeto.getId().equals(tarefa.getProjeto().getId()))
                tarefas.add(tarefa);
        });
        return tarefas;
    }
}
