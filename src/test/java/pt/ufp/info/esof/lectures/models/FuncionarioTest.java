package pt.ufp.info.esof.lectures.models;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

    @Test
    void adicionarExplicacao() {
        Funcionario funcionario =new Funcionario();

        Disponibilidade disponibilidade=new Disponibilidade();
        disponibilidade.setDiaDaSemana(LocalDate.now().getDayOfWeek());
        disponibilidade.setHoraInicio(LocalTime.of(8,0));
        disponibilidade.setHoraFim(LocalTime.of(9,0));

        funcionario.adicionaDisponibilidade(disponibilidade);

        assertEquals(0, funcionario.getExplicacoes().size());

        Explicacao explicacaoComecaAntesTerminaDurante=new Explicacao();
        explicacaoComecaAntesTerminaDurante.setHora(LocalDateTime.of(
                LocalDate.now(),
                LocalTime.of(7,30)
        ));
        funcionario.adicionarExplicacao(explicacaoComecaAntesTerminaDurante);
        assertEquals(0, funcionario.getExplicacoes().size());

        Explicacao explicacaoDiaSeguinte=new Explicacao();
        explicacaoDiaSeguinte.setHora(LocalDateTime.of(
                LocalDate.now().plusDays(1),
                LocalTime.of(8,0)
        ));

        funcionario.adicionarExplicacao(explicacaoDiaSeguinte);
        assertEquals(0, funcionario.getExplicacoes().size());

        Explicacao explicacaoOk=new Explicacao();
        explicacaoOk.setHora(LocalDateTime.of(
                LocalDate.now(),
                LocalTime.of(8,0)
        ));

        funcionario.adicionarExplicacao(explicacaoOk);
        assertEquals(1, funcionario.getExplicacoes().size());

        funcionario.adicionarExplicacao(explicacaoOk);
        assertEquals(1, funcionario.getExplicacoes().size());

    }
}