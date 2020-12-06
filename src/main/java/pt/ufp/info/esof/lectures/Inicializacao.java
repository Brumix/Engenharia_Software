package pt.ufp.info.esof.lectures;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pt.ufp.info.esof.lectures.models.*;
import pt.ufp.info.esof.lectures.repositories.*;

@Component
public class Inicializacao implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EmpresaRepository empresaRepository;
    @Autowired
    private TarefaRepository tarefaRepository;
    @Autowired
    private CargoRepository cargoRepository;

    @SneakyThrows
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("\n\n\nInicializou\n\n\n");


        Cargo gestor = new Cargo();
        gestor.setNome("Bruno");
        gestor.setSalarioHora(50);

        Cargo administrador = new Cargo();
        administrador.setNome("Andre");
        administrador.setSalarioHora(12);


        Empresa fantastica = new Empresa();
        fantastica.setNome("Fantastica");

        Empresa incrivel = new Empresa();
        incrivel.setNome("Incrivel");


        Projecto api = new Projecto();
        api.setNome("Api");

        Projecto alojamentos = new Projecto();
        alojamentos.setNome("Alojamentos");

        Projecto progama_senhas = new Projecto();
        progama_senhas.setNome("Progama de Senhas");


        Tarefa digramaClasses = new Tarefa();
        digramaClasses.setNome("Diagrama de Classes");

        Tarefa implementarCodigo = new Tarefa();
        implementarCodigo.setNome("Implementar Codigo");

        Tarefa teste = new Tarefa();
        teste.setNome("Testes");


        Funcionario funcionario = new Funcionario();
        funcionario.setName("Bruno");
        funcionario.setEmail("bruno@gmail.com");

        Funcionario funcionario1 = new Funcionario();
        funcionario1.setName("Andre Batista");
        funcionario1.setEmail("Abatista@gmail.com");


        Cliente cliente = new Cliente();
        cliente.setEmail("cliente@gmail.com");
        cliente.setName("cliente");

        // api.adicionaTarefa(digramaClasses);
        // api.adicionaTarefa(implementarCodigo);
        // alojamentos.adicionaTarefa(implementarCodigo);
        // alojamentos.adicionaTarefa(teste);
        // progama_senhas.adicionaTarefa(digramaClasses);
        // progama_senhas.adicionaTarefa(teste);


        gestor.adicionaFuncionario(funcionario);
        administrador.adicionaFuncionario(funcionario1);


        fantastica.adicionaProjecto(api);
        fantastica.adicionaProjecto(alojamentos);
        incrivel.adicionaProjecto(progama_senhas);

       // cliente.adicionaProjecto(api);


        this.cargoRepository.save(gestor);
        this.cargoRepository.save(administrador);

        this.empresaRepository.save(fantastica);
        this.empresaRepository.save(incrivel);

        this.clienteRepository.save(cliente);

        this.funcionarioRepository.save(funcionario);
        this.funcionarioRepository.save(funcionario1);

        this.tarefaRepository.save(digramaClasses);
        this.tarefaRepository.save(implementarCodigo);
        this.tarefaRepository.save(teste);


    }
}
