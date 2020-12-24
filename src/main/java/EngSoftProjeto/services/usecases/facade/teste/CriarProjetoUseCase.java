package EngSoftProjeto.services.usecases.facade.teste;


import EngSoftProjeto.Models.Projeto;

import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.Repositories.ProjetoRepository;
import EngSoftProjeto.Repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CriarProjetoUseCase {
    private final TarefaRepository tarefaRepository;
    private final ProjetoRepository projetoRepository;

    @Autowired
    public CriarProjetoUseCase(TarefaRepository tarefaRepository, ProjetoRepository projetoRepository) {
        this.tarefaRepository = tarefaRepository;
        this.projetoRepository = projetoRepository;
    }

    public Optional<Projeto> criarprojeto(Projeto projeto) {
        Optional<Projeto> optionalprojeto = projetoRepository.findById(projeto.getId());
        if (optionalprojeto.isEmpty()) {
            projetoRepository.save(projeto);
            List<Tarefa> tarefas = new ArrayList<>();
            projeto.getTarefas().forEach(tarefa -> {
                Optional<Tarefa> optionalTarefa = tarefaRepository.findById(tarefa.getId());
                if (optionalTarefa.isPresent()) {
                    tarefas.add(tarefa);
                    tarefa.setProjeto(projeto);
                    tarefaRepository.save(optionalTarefa.get());
                }
            });
            projeto.setTarefas(tarefas);
            return Optional.of(projetoRepository.save(projeto));
        }
        return Optional.empty();
    }
}
