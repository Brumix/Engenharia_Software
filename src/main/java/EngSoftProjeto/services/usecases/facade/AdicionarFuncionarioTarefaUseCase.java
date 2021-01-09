package EngSoftProjeto.services.usecases.facade;


import EngSoftProjeto.Models.Funcionario;
import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.Repositories.FuncionarioRepository;
import EngSoftProjeto.Repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdicionarFuncionarioTarefaUseCase {
    private final TarefaRepository tarefaRepository;
    private final FuncionarioRepository funcionarioRepository;


    @Autowired
    public AdicionarFuncionarioTarefaUseCase(TarefaRepository tarefaRepository,FuncionarioRepository funcionarioRepository) {
        this.tarefaRepository = tarefaRepository;
        this.funcionarioRepository=funcionarioRepository;
    }

    public Optional<Tarefa> adicionaFuncionario(Long tarefaId, Funcionario funcionario) {

        Optional<Tarefa> optionalTarefa = this.tarefaRepository.findById(tarefaId);
        Optional<Funcionario> optionalFuncionario = this.funcionarioRepository.findByNome(funcionario.getNome());
        if (optionalTarefa.isPresent() && optionalFuncionario.isPresent()) {
            Tarefa tarefa = optionalTarefa.get();
            Funcionario funcionario1= optionalFuncionario.get();
            if (tarefa.getFuncionario()==null || !tarefa.getFuncionario().equals(funcionario)) {
                tarefa.setFuncionario(funcionario);
                funcionario1.tarefas.add(tarefa);
                funcionarioRepository.save(funcionario);
                tarefaRepository.save(tarefa);
                return Optional.of(tarefa);
            }
        }
        return Optional.empty();
    }
}
