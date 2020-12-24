package EngSoftProjeto.services.usecases.facade;

import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MostraClientePorPojetoUseCase.class)
class MostraClientePorPojetoUseCaseTest {

    @Autowired
    MostraClientePorPojetoUseCase mostraClientePorPojetoUseCase;

    @MockBean
    ClienteRepository clienteRepository;

    @Test
    void mostraClientePorPojeto() {
        Projeto projeto=new Projeto();
        projeto.setId(1L);

        //mostraClientePorPojetoUseCase.mostraClientePorPojeto(1L)
    }
}