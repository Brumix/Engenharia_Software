package EngSoftProjeto.services.usecases.facade;

import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Repositories.ProjetoRepository;
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

        projeto.setNome("andre");

        when(projetoRepository.findById(1L)).thenReturn(Optional.of(projeto));
        assertEquals(0,mostrarPrecoProjetoUseCase.precoProjeto(1L));
    }
}