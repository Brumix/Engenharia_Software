package EngSoftProjeto.controllers;

import EngSoftProjeto.services.usecases.facade.FuncionarioServiceFacade;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;


@WebMvcTest(FuncionarioController.class)
class FuncionarioControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FuncionarioServiceFacade funcionarioServiceFacade;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void postFuncionario() {
    }
}

  /*  @Test
    void createExplicador() throws Exception {
        Explicador explicador=new Explicador();
        explicador.setEmail("novoexplicador@mail.com");

        when(this.explicadorService.createExplicador(explicador)).thenReturn(Optional.of(explicador));

        String explicadorAsJsonString=new ObjectMapper().writeValueAsString(explicador);

        mockMvc.perform(post("/explicador").content(explicadorAsJsonString).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        Explicador explicadorExistente=new Explicador();
        explicadorExistente.setEmail("explicador@mail.com");
        String explicadorExistenteAsJsonString=new ObjectMapper().writeValueAsString(explicadorExistente);

        mockMvc.perform(post("/explicador").content(explicadorExistenteAsJsonString).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());

    }*/