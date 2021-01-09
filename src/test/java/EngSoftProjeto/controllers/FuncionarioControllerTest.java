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

        Funcionario funcionario1=Funcionario.builder().nome("teste1").cargo(Cargo.DEV_SR).email("teste1@teste.com").Password("pass1").build();
        String funcionario1AsjsonString=new ObjectMapper().writeValueAsString(funcionario1);
        when(this.funcionarioServiceFacade.criarfuncionario(funcionario1)).thenReturn(Optional.of(funcionario1));
        mockMvc.perform(post("/funcionario").content(funcionario1AsjsonString).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        Funcionario funcionario2=Funcionario.builder().nome("teste").cargo(Cargo.SEMCARGO).email("teste@teste.com").Password("pass").build();
        String funcionario2AsjsonString=new ObjectMapper().writeValueAsString(funcionario2);
        when(this.funcionarioServiceFacade.criarfuncionario(funcionario2)).thenReturn(Optional.of(funcionario2));
        mockMvc.perform(post("/funcionario").content(funcionario2AsjsonString).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        Funcionario funcionarioexistente=Funcionario.builder().nome("teste4").cargo(Cargo.AN_SR).email("teste4@teste.com").Password("pass4").build();
        String funcionarioexistenteAsjsonString=new ObjectMapper().writeValueAsString(funcionarioexistente);
        mockMvc.perform(post("/funcionario").content(funcionarioexistenteAsjsonString).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
    }
}


