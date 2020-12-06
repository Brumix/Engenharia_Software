package pt.ufp.info.esof.lectures.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pt.ufp.info.esof.lectures.models.Cliente;
import pt.ufp.info.esof.lectures.models.Explicacao;
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

    @PostMapping
    public ResponseEntity<Explicacao> marcaAtendimento(@RequestBody Explicacao explicacao){
        Optional<Funcionario> optionalExplicador= funcionarioRepository.findById(explicacao.getFuncionario().getId());
        Optional<Cliente> optionalAluno= clienteRepository.findById(explicacao.getCliente().getId());
        if(optionalAluno.isPresent()&&optionalExplicador.isPresent()){
            Funcionario funcionario =optionalExplicador.get();
            Cliente cliente =optionalAluno.get();
            if(funcionario.adicionarExplicacao(explicacao)!=null){
                cliente.addExplicacao(explicacao);
                funcionarioRepository.save(funcionario);
                clienteRepository.save(cliente);
                return ResponseEntity.ok(explicacao);
            }
        }
        return ResponseEntity.badRequest().build();
    }
}
