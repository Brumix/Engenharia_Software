package EngSoftProjeto.services.usecases.facade;


import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.Repositories.ProjetoRepository;
import EngSoftProjeto.Repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdicionaTarefaProjetoUseCase {
    private final ProjetoRepository projetoRepository;
    private final TarefaRepository tarefaRepository;

    @Autowired
    public AdicionaTarefaProjetoUseCase(ProjetoRepository projetoRepository,TarefaRepository tarefaRepository) {
        this.projetoRepository = projetoRepository;
        this.tarefaRepository=tarefaRepository;
    }

    public Optional<Projeto> adicionaTarefa(Long projetoId, Tarefa tarefa) {
        Optional<Projeto> optionalProjeto = this.projetoRepository.findById(projetoId);
        if (optionalProjeto.isPresent()) {
            Projeto projeto = optionalProjeto.get();
            if (projeto.tarefas.isEmpty() || !projeto.tarefas.contains(tarefa)) {
                projeto.tarefas.add(tarefa);
                tarefa.setProjeto(projeto);
                projetoRepository.save(projeto);
                tarefaRepository.save(tarefa);
                return Optional.of(projeto);
            }
        }
        return Optional.empty();
    }
}
