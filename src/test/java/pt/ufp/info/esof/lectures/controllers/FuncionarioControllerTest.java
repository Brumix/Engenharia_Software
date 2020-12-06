package pt.ufp.info.esof.lectures.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pt.ufp.info.esof.lectures.models.Funcionario;
import pt.ufp.info.esof.lectures.repositories.FuncionarioRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ExplicadorController.class)
class FuncionarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllExplicador() throws Exception {
        Funcionario funcionario1 =new Funcionario();
        Funcionario funcionario2 =new Funcionario();
        Funcionario funcionario3 =new Funcionario();

        List<Funcionario> explicadores= Arrays.asList(funcionario1, funcionario2, funcionario3);

        String listExplicadoresAsJsonString=new ObjectMapper().writeValueAsString(explicadores);

        when(funcionarioRepository.findAll()).thenReturn(explicadores);

        String httpResponseAsString=mockMvc.perform(get("/explicador")).andDo(print()).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        assertNotNull(httpResponseAsString);

        assertEquals(listExplicadoresAsJsonString,httpResponseAsString);

    }

    @Test
    void getExplicadorById() throws Exception {
        Funcionario funcionario =new Funcionario();
        String explicadorAsJsonString=new ObjectMapper().writeValueAsString(funcionario);

        when(funcionarioRepository.findById(1L)).thenReturn(Optional.of(funcionario));

        String httpResponseAsString=mockMvc.perform(get("/explicador/1")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        assertNotNull(httpResponseAsString);
        assertEquals(explicadorAsJsonString,httpResponseAsString);

        mockMvc.perform(get("/explicador/2")).andExpect(status().isNotFound());
    }

    @Test
    void createExplicador() throws Exception {
        Funcionario funcionario =new Funcionario();
        funcionario.setEmail("novoexplicador@mail.com");

        when(this.funcionarioRepository.save(funcionario)).thenReturn(funcionario);

        String explicadorAsJsonString=new ObjectMapper().writeValueAsString(funcionario);

        mockMvc.perform(post("/explicador").content(explicadorAsJsonString).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        Funcionario funcionarioExistente =new Funcionario();
        funcionarioExistente.setEmail("explicador@mail.com");
        String explicadorExistenteAsJsonString=new ObjectMapper().writeValueAsString(funcionarioExistente);
        when(this.funcionarioRepository.findByEmail("explicador@mail.com")).thenReturn(Optional.of(funcionarioExistente));

        mockMvc.perform(post("/explicador").content(explicadorExistenteAsJsonString).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());

    }

    
}