package EngSoftProjeto.services.usecases.facade.cliente;

import EngSoftProjeto.Models.Funcionario;
import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.Repositories.TarefaRepository;

import java.util.ArrayList;
import java.util.List;

public class MostrarTarefasPorFuncionarioUseCase {


    private final TarefaRepository tarefaRepository;

    public MostrarTarefasPorFuncionarioUseCase (TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;

    }

    public List<Tarefa> mostraTarefasPorPojeto(Funcionario funcionario) {
        List<Tarefa> tarefas = new ArrayList<>();
        tarefaRepository.findAll().forEach(tarefa -> {
            if (funcionario.getId().equals(tarefa.getProjeto().getId()))
                tarefas.add(tarefa);
        });
        return tarefas;
    }
}
