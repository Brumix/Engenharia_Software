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

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest(classes=AdicionarFuncionarioTarefaUseCase.class)
class AdicionarFuncionarioTarefaUseCaseTest {
    @Autowired
    AdicionarFuncionarioTarefaUseCase adicionarFuncionarioTarefaUseCase;
    @MockBean
    TarefaRepository tarefaRepository;
    @MockBean
    FuncionarioRepository funcionarioRepository;

    @Test
    void adicionaFuncionario() {

        Tarefa tarefa=new Tarefa();
        tarefa.setId(1L);
        Funcionario funcionario=new Funcionario();
        funcionario.setId(1L);
        funcionario.setNome("andre");

    //when(adicionarFuncionarioTarefaUseCase.adicionaFuncionario(tarefa.getId(), funcionario)).thenReturn( Optional.of(tarefa));
        when(tarefaRepository.findById(1L)).thenReturn(Optional.of(tarefa));
    assertTrue(adicionarFuncionarioTarefaUseCase.adicionaFuncionario(tarefa.getId(), funcionario).isPresent());



    }
}

