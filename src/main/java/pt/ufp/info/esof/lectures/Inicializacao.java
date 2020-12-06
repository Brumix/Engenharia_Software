package pt.ufp.info.esof.lectures;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pt.ufp.info.esof.lectures.models.*;
import pt.ufp.info.esof.lectures.repositories.ClienteRepository;
import pt.ufp.info.esof.lectures.repositories.TarefaRepository;
import pt.ufp.info.esof.lectures.repositories.FuncionarioRepository;
import pt.ufp.info.esof.lectures.repositories.EmpressaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class Inicializacao implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EmpressaRepository empressaRepository;
    @Autowired
    private TarefaRepository tarefaRepository;

    @SneakyThrows
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("\n\n\nInicializou\n\n\n");

        Empressa fct=new Empressa();
        fct.setNome("FCT");

        Projecto engenhariaInformatica=new Projecto();
        engenhariaInformatica.setNome("Engenharia Informática");

        Tarefa matematicaInformatica=new Tarefa();
        matematicaInformatica.setNome("Matemática");

        Tarefa fisicaInformatica=new Tarefa();
        fisicaInformatica.setNome("Física");

        Tarefa esof=new Tarefa();
        esof.setNome("Engenharia de Software");

        engenhariaInformatica.adicionaCadeira(matematicaInformatica);
        engenhariaInformatica.adicionaCadeira(fisicaInformatica);
        engenhariaInformatica.adicionaCadeira(esof);

        Projecto engenhariaCivil=new Projecto();
        engenhariaCivil.setNome("Engenharia Civil");

        Tarefa matematica=new Tarefa();
        matematica.setNome("Matemática");

        Tarefa fisica=new Tarefa();
        fisica.setNome("Física");

        engenhariaCivil.adicionaCadeira(matematica);
        engenhariaCivil.adicionaCadeira(fisica);

        fct.adicionaCurso(engenhariaInformatica);
        fct.adicionaCurso(engenhariaCivil);

        this.empressaRepository.save(fct);

        Funcionario funcionario =new Funcionario();
        funcionario.setEmail("explicador@gmail.com");

        Cliente cliente =new Cliente();
        this.clienteRepository.save(cliente);


        funcionario.adicionaCadeira(esof);
        funcionario.adicionaCadeira(matematicaInformatica);

        this.funcionarioRepository.save(funcionario);
        this.tarefaRepository.save(esof);
        this.tarefaRepository.save(matematicaInformatica);
    }
}
