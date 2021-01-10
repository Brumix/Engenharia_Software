package engsoftprojeto.controllers;


import engsoftprojeto.models.Projeto;
import engsoftprojeto.models.Tarefa;
import engsoftprojeto.services.usecases.facade.ProjetoServiceFacade;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ProjetoIdController.class)
class ProjetoIdControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProjetoServiceFacade projetoServiceFacade;

    @Test
    void postProjeto() throws Exception {

        Projeto projeto=Projeto.builder().nome("teste").build();
        String projetoAsjsonString=new ObjectMapper().writeValueAsString(projeto);

        when(this.projetoServiceFacade.criarprojeto(projeto)).thenReturn(Optional.of(projeto));
        mockMvc.perform(post("/projeto").content(projetoAsjsonString).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        Projeto projetoexistente=Projeto.builder().nome("testeexistente").build();
        String projetoexistenteAsjsonString=new ObjectMapper().writeValueAsString(projetoexistente);
        mockMvc.perform(post("/projeto").content(projetoexistenteAsjsonString).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
    }

    @Test
    void patchAdicionaTarefa() throws Exception {

        Projeto projeto= Projeto.builder().nome("teste").id(1L).build();
        Tarefa tarefa=Tarefa.builder().nome("teste").duracao(30).build();

        String tarefaJson=new ObjectMapper().writeValueAsString(tarefa);

        when(projetoServiceFacade.adicionaTarefa(1L,tarefa)).thenReturn(Optional.of(projeto));

        mockMvc.perform(patch("/projeto/tarefa/1")
                .content(tarefaJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        mockMvc.perform(patch("/projeto/tarefa/2")
                .content(tarefaJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isBadRequest());
    }

    @Test
    void getPrecoProjetoById() throws Exception {

        float preco = 0;
        when(projetoServiceFacade.precoProjeto(1L)).thenReturn(Optional.of(preco));
        String httpResponseAsString=mockMvc.perform(get("/projeto/1/valor")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        assertNotNull(httpResponseAsString);

        mockMvc.perform(get("/projeto/2/valor")).andExpect(status().isNotFound());
    }


    @Test
    void getTempoProjetoById() throws Exception {

        int tempo = 0;
        when(projetoServiceFacade.mostrarTempoProjeto(1L)).thenReturn(Optional.of(tempo));
        String httpResponseAsString=mockMvc.perform(get("/projeto/1/tempo")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        assertNotNull(httpResponseAsString);

        mockMvc.perform(get("/projeto/2/valor")).andExpect(status().isNotFound());
    }
}