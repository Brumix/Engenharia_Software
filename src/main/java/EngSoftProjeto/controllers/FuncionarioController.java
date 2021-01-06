package EngSoftProjeto.controllers;


import EngSoftProjeto.Models.Funcionario;
import EngSoftProjeto.dtos.DTOStaticFactory;
import EngSoftProjeto.dtos.FuncionarioDTO;
import EngSoftProjeto.services.usecases.facade.FuncionarioServiceFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {

    private  final FuncionarioServiceFacade funcionarioServiceFacade;
    private final DTOStaticFactory dtoStaticFactory = DTOStaticFactory.getInstance();

    public FuncionarioController(FuncionarioServiceFacade funcionarioServiceFacade) {
        this.funcionarioServiceFacade = funcionarioServiceFacade;
    }

    @PostMapping
    public ResponseEntity<FuncionarioDTO> postProjeto(@RequestBody FuncionarioDTO funcionarioDTO) {
        Optional<Funcionario> optionalFuncionario = funcionarioServiceFacade.criarfuncionario(dtoStaticFactory.convertToFuncionario(funcionarioDTO));
        return optionalFuncionario.map(funcionario -> ResponseEntity.ok(dtoStaticFactory.convertToFuncionarioDTO(funcionario))).orElseGet(() -> ResponseEntity.badRequest().build());
    }

}
