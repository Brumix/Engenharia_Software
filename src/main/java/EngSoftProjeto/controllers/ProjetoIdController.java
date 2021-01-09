package EngSoftProjeto.controllers;


import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.dtos.DTOStaticFactory;
import EngSoftProjeto.dtos.ProjetoDTO;
import EngSoftProjeto.dtos.TarefaDTO;
import EngSoftProjeto.services.usecases.facade.ProjetoServiceFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/projeto")
public class ProjetoIdController {

    private final ProjetoServiceFacade projetoServiceFacade;
    private final DTOStaticFactory dtoStaticFactory = DTOStaticFactory.getInstance();

    public ProjetoIdController(ProjetoServiceFacade projetoServiceFacade) {
        this.projetoServiceFacade = projetoServiceFacade;
    }


    @PostMapping
    public ResponseEntity<ProjetoDTO> postProjeto(@RequestBody ProjetoDTO projetoDTO) {
        Optional<Projeto> optionalProjeto = projetoServiceFacade.criarprojeto(dtoStaticFactory.convertToProjeto(projetoDTO));
        return optionalProjeto.map(projeto -> ResponseEntity.ok(dtoStaticFactory.convertToProjetoDTO(projeto))).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PatchMapping("/tarefa/{idProjeto}")
    public ResponseEntity<ProjetoDTO> patchAdicionaTarefa(@RequestBody TarefaDTO tarefaDTO, @PathVariable Long idProjeto) {
        Optional<Projeto> optionalProjeto = projetoServiceFacade.adicionaTarefa(idProjeto, dtoStaticFactory.convertToTarefa(tarefaDTO));
        return optionalProjeto.map(projeto -> ResponseEntity.ok(dtoStaticFactory.convertToProjetoDTO(projeto))).orElseGet(() -> ResponseEntity.badRequest().build());
    }


    @GetMapping("/{id}/valor")
    public ResponseEntity<Float> getPrecoProjetoById(@PathVariable Long id) {
        Optional<Float> optionalProjeto = Optional.ofNullable(projetoServiceFacade.precoProjeto(id));
        if(optionalProjeto.isPresent()&&optionalProjeto.get().isNaN())
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok().build();
    }


    @GetMapping("/{id}/tempo")
    public ResponseEntity<Integer> getTempoProjetoById(@PathVariable Long id) {
        Optional<Integer> optionalProjeto = Optional.ofNullable(projetoServiceFacade.mostrarTempoProjeto(id));
        if(optionalProjeto.isPresent()&&optionalProjeto.get()==-1)
            return ResponseEntity.badRequest().build();

      return ResponseEntity.ok().build();
    }
}
