package engsoftprojeto.services.usecases.facade;

import engsoftprojeto.models.Cargo;
import engsoftprojeto.models.Funcionario;
import engsoftprojeto.models.Tarefa;
import engsoftprojeto.repositories.FuncionarioRepository;
import engsoftprojeto.repositories.TarefaRepository;
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
        tarefa.setNome("tarefa");
        tarefa.setDuracao(60);
        Funcionario funcionario=new Funcionario();
        funcionario.setId(1L);
        funcionario.setNome("andre");
        funcionario.setCargo(Cargo.AN_JR);
        funcionario.setPassword("1234");
        funcionario.setEmail("teste@teste.com");
        when(tarefaRepository.findById(1L)).thenReturn(Optional.of(tarefa));
        when(funcionarioRepository.findByNome("andre")).thenReturn(Optional.of(funcionario));
    assertTrue(adicionarFuncionarioTarefaUseCase.adicionaFuncionario(tarefa.getId(), funcionario).isPresent());

        assertTrue(adicionarFuncionarioTarefaUseCase.adicionaFuncionario(tarefa.getId(), funcionario).isEmpty());

    }
}

