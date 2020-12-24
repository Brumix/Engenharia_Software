package EngSoftProjeto.services.usecases.facade.cliente;


import EngSoftProjeto.Models.Funcionario;
import EngSoftProjeto.Models.Tarefa;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioServiceFacade implements FuncionarioServiceFacadeI {

    private final MostraPorIdFuncionarioUseCase mostraPorIdFuncionarioUseCase;
    private final MostraTodosFuncionarioUseCase mostraTodosFuncionarioUseCase;
    private final MostrarTarefasPorFuncionarioUseCase mostrarTarefasPorFuncionarioUseCase;
    private final CriarFuncionarioUseCase criarFuncionarioUseCase;

    public FuncionarioServiceFacade(MostraPorIdFuncionarioUseCase mostraPorIdFuncionarioUseCase, MostraTodosFuncionarioUseCase mostraTodosFuncionarioUseCase, MostrarTarefasPorFuncionarioUseCase mostrarTarefasPorFuncionarioUseCase, CriarFuncionarioUseCase criarFuncionarioUseCase) {
        this.mostraPorIdFuncionarioUseCase=mostraPorIdFuncionarioUseCase;
        this.mostraTodosFuncionarioUseCase=mostraTodosFuncionarioUseCase;
        this.mostrarTarefasPorFuncionarioUseCase = mostrarTarefasPorFuncionarioUseCase;
        this.criarFuncionarioUseCase = criarFuncionarioUseCase;
    }

    @Override
    public List<Funcionario> mostrarTodosProjetos() {
        return mostraTodosFuncionarioUseCase.findAll();
    }

    @Override
    public Optional<Funcionario> encontraProjetosId(Long id) {
        return mostraPorIdFuncionarioUseCase.findById(id);
    }

    @Override
    public Optional<Funcionario> criaFuncionario(Funcionario funcionario){
        return  criaFuncionario(funcionario);
    }

    @Override
    public List<Tarefa> mostrarTarefasorFuncionario(Funcionario funcionario){
        return mostrarTarefasorFuncionario(funcionario);
    }

}
