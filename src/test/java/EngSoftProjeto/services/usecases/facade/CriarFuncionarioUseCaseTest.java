package EngSoftProjeto.services.usecases.facade;

import EngSoftProjeto.Models.Funcionario;
import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.Repositories.FuncionarioRepository;
import EngSoftProjeto.Repositories.TarefaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@SpringBootTest(classes=CriarFuncionarioUseCase.class)
class CriarFuncionarioUseCaseTest {
    @Autowired
   CriarFuncionarioUseCase criarFuncionarioUseCase;
    @MockBean
    FuncionarioRepository funcionarioRepository;

    @Test
    void criarfuncionario() {

        Funcionario funcionario=new Funcionario();
        funcionario.setId(50L);
        funcionario.setNome("lalalal");


        assertTrue(criarFuncionarioUseCase.criarfuncionario(funcionario).isPresent());

        when(funcionarioRepository.findByNome(funcionario.getNome())).thenReturn(Optional.of(funcionario));
        assertTrue(criarFuncionarioUseCase.criarfuncionario(funcionario).isEmpty());






    }
}