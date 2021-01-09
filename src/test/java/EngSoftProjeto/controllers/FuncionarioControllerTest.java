package EngSoftProjeto.controllers;

import EngSoftProjeto.Models.Cargo;
import EngSoftProjeto.Models.Funcionario;
import EngSoftProjeto.services.usecases.facade.FuncionarioServiceFacade;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(FuncionarioController.class)
class FuncionarioControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private FuncionarioServiceFacade funcionarioServiceFacade;


    @Test
    void postFuncionario() throws Exception {

        Funcionario funcionario=Funcionario.builder().nome("teste").cargo(Cargo.AN_JR).email("teste@teste.com").Password("pass").build();
        String funcionarioAsjsonString=new ObjectMapper().writeValueAsString(funcionario);

        when(this.funcionarioServiceFacade.criarfuncionario(funcionario)).thenReturn(Optional.of(funcionario));
        mockMvc.perform(post("/funcionario").content(funcionarioAsjsonString).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());


        Funcionario funcionarioexistente=Funcionario.builder().nome("teste1").cargo(Cargo.AN_JR).email("teste1@teste.com").Password("pass1").build();
        String funcionarioexistenteAsjsonString=new ObjectMapper().writeValueAsString(funcionarioexistente);
        mockMvc.perform(post("/funcionario").content(funcionarioexistenteAsjsonString).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
    }
}


