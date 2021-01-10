package engsoftprojeto.services.usecases.facade;

import engsoftprojeto.models.Projeto;
import engsoftprojeto.repositories.ProjetoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@SpringBootTest(classes=MostrarPrecoProjetoUseCase.class)
class MostrarPrecoProjetoUseCaseTest {
    @Autowired
    MostrarPrecoProjetoUseCase mostrarPrecoProjetoUseCase;
    @MockBean
    ProjetoRepository projetoRepository;
    @Test
    void precoProjeto() {
        Projeto projeto=new Projeto();
        projeto.setId(2L);
        projeto.setNome("andre");

        when(projetoRepository.findById(projeto.getId())).thenReturn(Optional.of(projeto));
        assertTrue(mostrarPrecoProjetoUseCase.precoProjeto(projeto.getId()).isPresent());
    }
}