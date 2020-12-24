package EngSoftProjeto.services.usecases.facade.cliente;


import EngSoftProjeto.Models.Funcionario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioServiceFacade implements FuncionarioServiceFacadeI {

    private final MostraPorIdFuncionarioUseCase mostraPorIdFuncionarioUseCase;
    private final MostraTodosFuncionarioUseCase mostraTodosFuncionarioUseCase;

    public FuncionarioServiceFacade(MostraPorIdFuncionarioUseCase mostraPorIdFuncionarioUseCase,MostraTodosFuncionarioUseCase mostraTodosFuncionarioUseCase) {
        this.mostraPorIdFuncionarioUseCase=mostraPorIdFuncionarioUseCase;
        this.mostraTodosFuncionarioUseCase=mostraTodosFuncionarioUseCase;
    }

    @Override
    public List<Funcionario> mostrarTodosProjetos() {
        return mostraTodosFuncionarioUseCase.findAll();
    }

    @Override
    public Optional<Funcionario> encontraProjetosId(Long id) {
        return mostraPorIdFuncionarioUseCase.findById(id);
    }


}
