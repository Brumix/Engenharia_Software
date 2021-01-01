package EngSoftProjeto.controllers;


import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.dtos.DTOStaticFactory;
import EngSoftProjeto.dtos.FuncionarioDTO;
import EngSoftProjeto.dtos.TarefaDTO;
import EngSoftProjeto.services.usecases.facade.TarefaServiceFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/tarefa")
public class TarefaController {

    private final TarefaServiceFacade tarefaServiceFacade;
    private final DTOStaticFactory dtoStaticFactory = DTOStaticFactory.getInstance();

    public TarefaController(TarefaServiceFacade tarefaServiceFacade) {
        this.tarefaServiceFacade = tarefaServiceFacade;
    }


    @PostMapping
    public ResponseEntity<TarefaDTO> postProjeto(@RequestBody TarefaDTO tarefaDTO) {
        Optional<Tarefa> optionalTarefa = tarefaServiceFacade.criarTarefa(dtoStaticFactory.convertToTarefa(tarefaDTO));
        return optionalTarefa.map(tarefa -> ResponseEntity.ok(dtoStaticFactory.convertToTarefasDTO(tarefa))).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PatchMapping("/funcionario/{idTarefa}")
    public ResponseEntity<TarefaDTO> patchAdicionaFuncionario(@RequestBody FuncionarioDTO funcionarioDTO, @PathVariable Long idTarefa) {
        Optional<Tarefa> optionalTarefa = tarefaServiceFacade.adicionaFuncionario(idTarefa,dtoStaticFactory.convertToFuncionario(funcionarioDTO));
        return optionalTarefa.map(tarefa -> ResponseEntity.ok(dtoStaticFactory.convertToTarefasDTO(tarefa))).orElseGet(() -> ResponseEntity.badRequest().build());
    }

}
