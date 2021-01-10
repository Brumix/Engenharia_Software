package engsoftprojeto.services.usecases.facade;

import engsoftprojeto.models.Funcionario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = FuncionarioServiceFacade.class)
class FuncionarioServiceFacadeTest {
    @Autowired
    private FuncionarioServiceFacade facade;
    @MockBean
    private CriarFuncionarioUseCase criarFuncionarioUseCase;

    @Test
    void criarfuncionario() {
        assertNotNull(facade);
        assertNotNull(criarFuncionarioUseCase);

        Funcionario funcionario=new Funcionario();
        when(criarFuncionarioUseCase.criarfuncionario(funcionario)).thenReturn(Optional.of(funcionario));

        assertNotNull(facade.criarfuncionario(funcionario));
    }
}