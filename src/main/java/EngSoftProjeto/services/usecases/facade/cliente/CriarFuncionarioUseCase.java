package EngSoftProjeto.services.usecases.facade.cliente;

import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Models.Funcionario;
import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.Repositories.ClienteRepository;
import EngSoftProjeto.Repositories.FuncionarioRepository;
import EngSoftProjeto.Repositories.ProjetoRepository;
import EngSoftProjeto.Repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CriarFuncionarioUseCase {

    private final FuncionarioRepository funcionarioRepository;
    private final TarefaRepository tarefaRepository;

    @Autowired
    public CriarFuncionarioUseCase(FuncionarioRepository funcionarioRepository, TarefaRepository tarefaRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.tarefaRepository = tarefaRepository;
    }

    public Optional<Funcionario> criarfuncionario(Funcionario funcionario) {
        Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(funcionario.getId());//email mudar
        if (optionalFuncionario.isEmpty()) {
            funcionarioRepository.save(funcionario);
            List<Tarefa> tarefas = new ArrayList<>();
            funcionario.getTarefas().forEach(tarefa -> {
                Optional<Tarefa> optionalTarefa = tarefaRepository.findById(tarefa.getId());//nome mudar
                if (optionalTarefa.isPresent()) {
                    tarefas.add(tarefa);
                    tarefa.setFuncionario(funcionario);
                    tarefaRepository.save(optionalTarefa.get());
                }
            });
            funcionario.setTarefas(tarefas);
            return Optional.of(funcionarioRepository.save(funcionario));
        }
        return Optional.empty();
    }
}
