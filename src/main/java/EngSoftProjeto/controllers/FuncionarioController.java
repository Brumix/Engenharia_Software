package EngSoftProjeto.controllers;

import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.dtos.DTOStaticFactory;
import EngSoftProjeto.dtos.FuncionarioDTO;
import EngSoftProjeto.dtos.ProjetoDTO;
import EngSoftProjeto.services.usecases.facade.FuncionarioServiceFacade;
import EngSoftProjeto.services.usecases.facade.ProjetoServiceFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {
    private final ProjetoServiceFacade projetoServiceFacade;
    private final DTOStaticFactory dtoStaticFactory=DTOStaticFactory.getInstance();

    public FuncionarioController(ProjetoServiceFacade funcionarioService) {
        this.projetoServiceFacade = funcionarioService;
    }

    @GetMapping()
    public ResponseEntity<ProjetoDTO> getAllExplicador(){
        //List<ExplicadorResponseDTO> responseDTOS=new ArrayList<>();
        //explicadorService.findAll().forEach(explicador -> responseDTOS.add(dtoStaticFactory.explicadorResponseDTO(explicador)));
        List<FuncionarioDTO> funcionarioDTOS=new ArrayList<>();

        Optional<Projeto> option=projetoServiceFacade.mostrarEstadoProjeto(1L);
        return option.map(projeto -> ResponseEntity.ok(dtoStaticFactory.convertToProjetoDTO(projeto))).orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
