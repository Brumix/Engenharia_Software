package EngSoftProjeto.services.usecases.facade.teste;


import EngSoftProjeto.Models.Funcionario;
import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.Repositories.FuncionarioRepository;
import EngSoftProjeto.Repositories.ProjetoRepository;
import EngSoftProjeto.Repositories.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CriarTarefaUseCase {

    private final TarefaRepository tarefaRepository;
    private final ProjetoRepository projetoRepository;
    private final FuncionarioRepository funcionarioRepository;


    public CriarTarefaUseCase(TarefaRepository tarefaRepository, ProjetoRepository projetoRepository, FuncionarioRepository funcionarioRepository) {
        this.tarefaRepository = tarefaRepository;
        this.projetoRepository = projetoRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    public Optional<Tarefa> criarTarefa(Tarefa tarefa) {
        Optional<Tarefa> optionalTarefa = tarefaRepository.findById(tarefa.getId());
        if (optionalTarefa.isEmpty()) {

            Optional<Projeto> optionalProjeto = projetoRepository.findById(tarefa.getProjeto().getId());
            if (optionalProjeto.isPresent()) {
                optionalProjeto.get().tarefas.add(tarefa);
                projetoRepository.save(optionalProjeto.get());
            }

            Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(tarefa.getFuncionario().getId());
            if (optionalFuncionario.isPresent()) {
                optionalFuncionario.get().tarefas.add(tarefa);
                funcionarioRepository.save(optionalFuncionario.get());
            }
            return Optional.of(tarefaRepository.save(tarefa));
        }
    return Optional.empty();
    }
}
