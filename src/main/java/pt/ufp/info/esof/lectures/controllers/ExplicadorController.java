package pt.ufp.info.esof.lectures.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pt.ufp.info.esof.lectures.models.Disponibilidade;
import pt.ufp.info.esof.lectures.models.Funcionario;
import pt.ufp.info.esof.lectures.repositories.FuncionarioRepository;

import java.util.Optional;

@Controller
@RequestMapping("/explicador")
public class ExplicadorController {
    private final FuncionarioRepository funcionarioRepository;

    public ExplicadorController(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @GetMapping()
    public ResponseEntity<Iterable<Funcionario>> getAllExplicador(){
        return ResponseEntity.ok(funcionarioRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getExplicadorById(@PathVariable Long id){
        Optional<Funcionario> optionalExplicador= funcionarioRepository.findById(id);
        return optionalExplicador.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Funcionario> createExplicador(@RequestBody Funcionario funcionario){
        Optional<Funcionario> optionalExplicador= funcionarioRepository.findByEmail(funcionario.getEmail());
        if(optionalExplicador.isEmpty()){
           return ResponseEntity.ok(funcionarioRepository.save(funcionario));
        }
        return ResponseEntity.badRequest().build();
    }

    @PatchMapping("/{explicadorId}")
    public ResponseEntity<Funcionario> adicionaDisponibilidade(@PathVariable Long explicadorId, @RequestBody Disponibilidade disponibilidade){
        Optional<Funcionario> optionalExplicador=this.funcionarioRepository.findById(explicadorId);
        if(optionalExplicador.isPresent()){
            Funcionario funcionario =optionalExplicador.get();
            int quantidadeDeDisponibilidadesAntes= funcionario.getDisponibilidades().size();
            funcionario.adicionaDisponibilidade(disponibilidade);
            int quantidadedeDisponibilidadesDepois= funcionario.getDisponibilidades().size();
            if(quantidadeDeDisponibilidadesAntes!=quantidadedeDisponibilidadesDepois) {
                return ResponseEntity.ok(funcionario);
            }
        }
        return ResponseEntity.badRequest().build();
    }
}
