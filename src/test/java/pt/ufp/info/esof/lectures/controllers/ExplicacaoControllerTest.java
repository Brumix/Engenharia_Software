package pt.ufp.info.esof.lectures.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pt.ufp.info.esof.lectures.models.Cliente;
import pt.ufp.info.esof.lectures.models.Disponibilidade;
import pt.ufp.info.esof.lectures.models.Explicacao;
import pt.ufp.info.esof.lectures.models.Funcionario;
import pt.ufp.info.esof.lectures.repositories.ClienteRepository;
import pt.ufp.info.esof.lectures.repositories.ExplicacaoRepository;
import pt.ufp.info.esof.lectures.repositories.FuncionarioRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ExplicacaoController.class)
class ExplicacaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExplicacaoRepository explicacaoRepository;
    @MockBean
    private FuncionarioRepository funcionarioRepository;
    @MockBean
    private ClienteRepository clienteRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void marcaAtendimento() throws Exception {

        Cliente cliente =new Cliente();
        cliente.setId(1L);

        Disponibilidade disponibilidade=new Disponibilidade();
        disponibilidade.setHoraInicio(LocalTime.of(8,0));
        disponibilidade.setHoraFim(LocalTime.of(12,0));
        disponibilidade.setDiaDaSemana(LocalDate.now().getDayOfWeek());

        Funcionario funcionario =new Funcionario();
        funcionario.adicionaDisponibilidade(disponibilidade);
        funcionario.setId(1L);

        Explicacao explicacao=new Explicacao();
        explicacao.setHora(LocalDateTime.of(
                LocalDate.now(),
                LocalTime.of(8,0)
        ));

        explicacao.setFuncionario(funcionario);
        explicacao.setCliente(cliente);

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
        when(funcionarioRepository.findById(1L)).thenReturn(Optional.of(funcionario));
        when(explicacaoRepository.save(explicacao)).thenReturn(explicacao);

        String explicacaoJson=objectMapper.writeValueAsString(explicacao);

        mockMvc.perform(post("/explicacao").contentType(MediaType.APPLICATION_JSON).content(explicacaoJson))
                .andExpect(status().isOk());

        mockMvc.perform(post("/explicacao").contentType(MediaType.APPLICATION_JSON).content(explicacaoJson))
                .andExpect(status().isBadRequest());



    }
}