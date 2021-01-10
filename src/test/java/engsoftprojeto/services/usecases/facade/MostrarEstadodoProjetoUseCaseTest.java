package engsoftprojeto.services.usecases.facade;

import engsoftprojeto.models.Projeto;
import engsoftprojeto.repositories.ProjetoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest(classes=MostrarEstadodoProjetoUseCase.class)
class MostrarEstadodoProjetoUseCaseTest {
    @Autowired
    MostrarEstadodoProjetoUseCase mostrarEstadodoProjetoUseCase;
    @MockBean
    ProjetoRepository projetoRepository;
    @Test
    void mostrarEstadoProjeto() {
        Projeto projeto=new Projeto();
        projeto.setId(2L);
        projeto.setNome("andre");

       when(projetoRepository.findById(projeto.getId())).thenReturn(Optional.of(projeto));
        assertTrue(mostrarEstadodoProjetoUseCase.mostrarEstadoProjeto(projeto.getId()).isPresent());

    }
}