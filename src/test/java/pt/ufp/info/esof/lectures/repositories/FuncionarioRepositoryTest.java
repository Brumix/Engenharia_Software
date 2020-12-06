package pt.ufp.info.esof.lectures.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pt.ufp.info.esof.lectures.models.Cliente;
import pt.ufp.info.esof.lectures.models.Disponibilidade;
import pt.ufp.info.esof.lectures.models.Explicacao;
import pt.ufp.info.esof.lectures.models.Funcionario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class FuncionarioRepositoryTest {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private DisponibilidadeRepository disponibilidadeRepository;
    @Autowired
    private ExplicacaoRepository explicacaoRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void testaCriacaoExplicador(){
        String explicadorEmail="explicador@gmail.com";
        Funcionario funcionario =new Funcionario();
        funcionario.setEmail(explicadorEmail);

        Disponibilidade disponibilidade=new Disponibilidade();

        disponibilidade.setDiaDaSemana(LocalDate.now().getDayOfWeek());
        disponibilidade.setHoraInicio(LocalTime.of(8,0));
        disponibilidade.setHoraFim(disponibilidade.getHoraInicio().plusHours(3));

        funcionario.setDisponibilidades(Collections.singletonList(disponibilidade));

        Explicacao explicacao=new Explicacao();
        explicacao.setFuncionario(funcionario);
        explicacao.setHora(LocalDateTime.of(
                LocalDate.now(),
                LocalTime.of(8,0)
        ));

        Cliente cliente =new Cliente();

        assertNull(cliente.getId());
        clienteRepository.save(cliente);
        assertNotNull(cliente.getId());

        cliente.addExplicacao(explicacao);
        funcionario.adicionarExplicacao(explicacao);

        assertEquals(0, funcionarioRepository.count());
        assertEquals(0,disponibilidadeRepository.count());

        assertNull(disponibilidade.getId());
        assertNull(funcionario.getId());
        funcionarioRepository.save(funcionario);
        assertNotNull(funcionario.getId());
        assertNotNull(disponibilidade.getId());

        assertEquals(1, funcionarioRepository.count());
        assertEquals(1,disponibilidadeRepository.count());
        assertTrue(funcionarioRepository.findByEmail(explicadorEmail).isPresent());


        assertEquals(1,explicacaoRepository.count());

    }
}