package pt.ufp.info.esof.lectures.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pt.ufp.info.esof.lectures.models.Cliente;
import pt.ufp.info.esof.lectures.models.Funcionario;
import pt.ufp.info.esof.lectures.repositories.ClienteRepository;
import pt.ufp.info.esof.lectures.repositories.FuncionarioRepository;

import java.util.Optional;

@Controller
@RequestMapping("/explicacao")
public class ExplicacaoController {

    private final FuncionarioRepository funcionarioRepository;
    private final ClienteRepository clienteRepository;

    @Autowired
    public ExplicacaoController(FuncionarioRepository funcionarioRepository, ClienteRepository clienteRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.clienteRepository = clienteRepository;
    }

}
