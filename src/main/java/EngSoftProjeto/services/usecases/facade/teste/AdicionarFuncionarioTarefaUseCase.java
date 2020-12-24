package EngSoftProjeto.services.usecases.facade.teste;


import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Models.Funcionario;
import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.Repositories.ClienteRepository;
import EngSoftProjeto.Repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdicionarFuncionarioTarefaUseCase {
    private final TarefaRepository tarefaRepository;


    @Autowired
    public AdicionarFuncionarioTarefaUseCase(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }


    public Optional<Tarefa> adicionaFuncionario(Long tarefaId, Funcionario funcionario) {
        Optional<Tarefa> optionalTarefa = this.tarefaRepository.findById(tarefaId);
        if (optionalTarefa.isPresent()) {
            Tarefa tarefa = optionalTarefa.get();
            if (!tarefa.getFuncionario().equals(funcionario)) {
                tarefa.setFuncionario(funcionario);
                return  Optional.of(tarefa);
            }
        }
        return Optional.empty();
    }
}
