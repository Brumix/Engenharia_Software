package EngSoftProjeto.services.usecases.facade.teste;


import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.Repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdicionaTarefaProjetoUseCase {
    private final ProjetoRepository projetoRepository;

    @Autowired
    public AdicionaTarefaProjetoUseCase(ProjetoRepository projetoRepository) {
        this.projetoRepository=projetoRepository;
    }

    public Optional<Projeto> adicionaTarefa(Long projetoId, Tarefa tarefa) {
        Optional<Projeto> optionalProjeto=this.projetoRepository.findById(projetoId);
        if(optionalProjeto.isPresent()){
            Projeto projeto =optionalProjeto.get();
            int quantidadeDeTarefasAntes=projeto.getTarefas().size();
            projeto.tarefas.add(tarefa);
            int quantidadedeTarefasDepois=projeto.getTarefas().size();
            if(quantidadeDeTarefasAntes!=quantidadedeTarefasDepois) {
                return Optional.of(projeto);
            }
        }
        return Optional.empty();
    }
}
