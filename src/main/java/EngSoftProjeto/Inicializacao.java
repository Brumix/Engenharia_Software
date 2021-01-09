package EngSoftProjeto;

import EngSoftProjeto.Models.*;
import EngSoftProjeto.Repositories.ClienteRepository;
import EngSoftProjeto.Repositories.FuncionarioRepository;
import EngSoftProjeto.Repositories.ProjetoRepository;
import EngSoftProjeto.Repositories.TarefaRepository;
import EngSoftProjeto.services.usecases.facade.ProjetoServiceFacade;
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

    @Autowired
    private ProjetoServiceFacade projetoServiceFacade;



    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

       /* Cliente */

        Cliente cl= Cliente.builder().nome("cliente").build();

        clienteRepository.save(cl);

        /* Funcionario    */

        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Andre B");


        funcionarioRepository.save(funcionario);

        /* Tarefa */

        Tarefa tf = new Tarefa();
        tf.setDuracao(60);
        tf.setConcluida(true);

        tarefaRepository.save(tf);


        /* Projeto */

        Projeto p1 = new Projeto();
        p1.setNome("Projeto ESOF");
        p1.setCliente(cl);
        projetoRepository.save(p1);


    }
}
