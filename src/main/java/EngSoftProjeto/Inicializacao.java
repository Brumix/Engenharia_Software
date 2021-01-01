package EngSoftProjeto;

import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Models.Funcionario;
import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.Repositories.ClienteRepository;
import EngSoftProjeto.Repositories.FuncionarioRepository;
import EngSoftProjeto.Repositories.ProjetoRepository;
import EngSoftProjeto.Repositories.TarefaRepository;
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

        Cliente cl= new Cliente();
        cl.setNome("Joao B");

        clienteRepository.save(cl);

        /* Projeto */

        Projeto p1 = new Projeto();
        p1.setId(5L);
        p1.setNome("Projeto ESOF");
        p1.setCliente(cl);

        projetoRepository.save(p1);

        /* Empregado    */

        Funcionario emp = new Funcionario();
        emp.setNome("Andre B");

        funcionarioRepository.save(emp);


        /* Tarefa */
        Tarefa tf = new Tarefa();

        tf.setId(5L);
        tf.setDuracao(60);
        tf.setConcluida(true);
        p1.tarefas.add(tf);

        tarefaRepository.save(tf);
    }
}
