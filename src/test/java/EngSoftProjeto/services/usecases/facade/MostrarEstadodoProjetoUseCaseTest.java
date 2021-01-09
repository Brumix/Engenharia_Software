package EngSoftProjeto.services.usecases.facade;

import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Repositories.ProjetoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

        projeto.setNome("andre");

       when(projetoRepository.findById(1L)).thenReturn(Optional.of(projeto));
        assertEquals(0,mostrarEstadodoProjetoUseCase.mostrarEstadoProjeto(1L));

    }
}