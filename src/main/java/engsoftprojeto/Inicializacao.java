package engsoftprojeto;


import engsoftprojeto.models.*;
import engsoftprojeto.repositories.ClienteRepository;
import engsoftprojeto.repositories.FuncionarioRepository;
import engsoftprojeto.repositories.ProjetoRepository;
import engsoftprojeto.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class Inicializacao implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private TarefaRepository tarefaRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        /* Cliente */

        Cliente cl = new Cliente();
        cl.setNome("Bruno");

        clienteRepository.save(cl);

        /* Projeto */

        Projeto p1 = new Projeto();
        p1.setId(5L);
        p1.setNome("Projeto ESOF");
        p1.setCliente(cl);

        // projetoRepository.save(p1);

        /* Empregado    */

        Funcionario emp = new Funcionario();
        emp.setNome("Andre B");
        emp.setCargo(Cargo.DEV_JR);



        /* Tarefa */
        Tarefa tf = new Tarefa();

        tf.setId(5L);
        tf.setDuracao(60);
        tf.setConcluida(true);
        tf.setFuncionario(emp);

        emp.tarefas.add(tf);

        funcionarioRepository.save(emp);
        projetoRepository.save(p1);
        tarefaRepository.save(tf);
    }
}
