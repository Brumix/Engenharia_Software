package EngSoftProjeto.services.usecases.facade;

import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjetoServiceFacade implements ProjetoServiceFacadeI {
    private final AdicionaTarefaProjetoUseCase adicionaTarefaProjetoUseCase;
    private final CriarProjetoUseCase criarProjetoUseCase;
    private final MostrarEstadodoProjetoUseCase mostrarEstadodoProjetoUseCase;
    private final MostrarPrecoProjetoUseCase mostrarPrecoProjetoUseCase;
    private final MostrarTempoPorProjetoUseCase mostrarTempoPorProjetoUseCase;
    //DUVIDA
@Autowired
    public ProjetoServiceFacade(AdicionaTarefaProjetoUseCase adicionaTarefaProjetoUseCase,
                                CriarProjetoUseCase criarProjetoUseCase, MostrarEstadodoProjetoUseCase mostrarEstadodoProjetoUseCase,
                                MostrarPrecoProjetoUseCase mostrarPrecoProjetoUseCase, MostrarTempoPorProjetoUseCase mostrarTempoPorProjetoUseCase) {
        this.adicionaTarefaProjetoUseCase = adicionaTarefaProjetoUseCase;
        this.criarProjetoUseCase = criarProjetoUseCase;
        this.mostrarEstadodoProjetoUseCase = mostrarEstadodoProjetoUseCase;
        this.mostrarPrecoProjetoUseCase = mostrarPrecoProjetoUseCase;
        this.mostrarTempoPorProjetoUseCase = mostrarTempoPorProjetoUseCase;
    }
    @Override
    public Optional<Projeto> adicionaTarefa(Long projetoid, Tarefa tarefa){
        return adicionaTarefaProjetoUseCase.adicionaTarefa(projetoid,tarefa);
    }
    @Override
    public Optional<Projeto>criarprojeto(Projeto projeto){
         return criarProjetoUseCase.criarprojeto(projeto);
    }
    @Override
    public Float mostrarEstadoProjeto(Long projetoid){
        return mostrarEstadodoProjetoUseCase.mostrarEstadoProjeto(projetoid);
    }
    @Override
    public Float precoProjeto(Long projetoid){
       return mostrarPrecoProjetoUseCase.precoProjeto(projetoid);
    }
    @Override
    public Integer mostrarTempoProjeto(Long projetoid){
        return mostrarTempoPorProjetoUseCase.mostrarTempoProjeto(projetoid);
    }
}
