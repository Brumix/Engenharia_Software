package engsoftprojeto.controllers;


import engsoftprojeto.models.Cargo;
import engsoftprojeto.models.Funcionario;
import engsoftprojeto.models.Tarefa;
import engsoftprojeto.services.usecases.facade.TarefaServiceFacade;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(TarefaController.class)
class TarefaControllerTest {


    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TarefaServiceFacade tarefaServiceFacade;

    @Test
    void postTarefa() throws Exception {

        Tarefa tarefa = Tarefa.builder().nome("teste").duracao(60).build();
        String tarefaAsjsonString = new ObjectMapper().writeValueAsString(tarefa);

        when(this.tarefaServiceFacade.criarTarefa(tarefa)).thenReturn(Optional.of(tarefa));
        mockMvc.perform(post("/tarefa").content(tarefaAsjsonString).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        Tarefa tarefaexistente = Tarefa.builder().nome("testeexistente").duracao(60).build();
        String funcionarioexistenteAsjsonString = new ObjectMapper().writeValueAsString(tarefaexistente);
        mockMvc.perform(post("/tarefa").content(funcionarioexistenteAsjsonString).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
    }

    @Test
    void patchAdicionaFuncionario() throws Exception {

        Tarefa tarefa = Tarefa.builder().nome("teste").duracao(60).build();
        Funcionario funcionario = Funcionario.builder().nome("funcionario").cargo(Cargo.DEV_JR).build();

        String funcionarioAsString = new ObjectMapper().writeValueAsString(funcionario);

        when(tarefaServiceFacade.adicionaFuncionario(1L, funcionario)).thenReturn(Optional.of(tarefa));

        mockMvc.perform(patch("/tarefa/funcionario/1")
                .content(funcionarioAsString)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        mockMvc.perform(patch("/tarefa/funcionario/2")
                .content(funcionarioAsString)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isBadRequest());
    }
}