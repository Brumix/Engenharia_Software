package EngSoftProjeto.services.usecases.facade;


import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;;
import EngSoftProjeto.Repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;



public class MostraTarefaPorPojetoUseCase {

    private final TarefaRepository tarefaRepository;

    public MostraTarefaPorPojetoUseCase(TarefaRepository tarefaRepository) {
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
