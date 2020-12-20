package EngSoftProjeto.services.usecases.facade.cliente;

import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.services.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicefacade implements ClientService {

    private final AdicionarProjectoClienteUseCase adicionarProjectoClienteUseCase ;
    private final CriarClienteUseCase criarClienteUseCase;
    private final MostrarPorIdUseCase mostrasPorIdUseCase;
    private final MostrarTodosOsClientesUseCase mostrarTodosOsClientesUseCase;


    public ClienteServicefacade(AdicionarProjectoClienteUseCase adicionarProjectoClienteUseCase, CriarClienteUseCase criarClienteUseCase, MostrarPorIdUseCase mostrasPorIdUseCase, MostrarTodosOsClientesUseCase mostrarTodosOsClientesUseCase) {
        this.adicionarProjectoClienteUseCase = adicionarProjectoClienteUseCase;
        this.criarClienteUseCase = criarClienteUseCase;
        this.mostrasPorIdUseCase = mostrasPorIdUseCase;
        this.mostrarTodosOsClientesUseCase = mostrarTodosOsClientesUseCase;
    }

    @Override
    public List<Cliente> encontraTodos() {
        return mostrarTodosOsClientesUseCase.findAll();
    }

    @Override
    public Optional<Cliente> encontraId(Long id) {
        return mostrasPorIdUseCase.findById(id);
    }

    @Override
    public Optional<Cliente> criaCliente(Cliente converter) {
        return criarClienteUseCase.createExplicador(converter);
    }

    @Override
    public Optional<Cliente> adicionaProjecto(Long clienteId, Projeto projecto) {
        return adicionarProjectoClienteUseCase.adicionaProjetos(clienteId,projecto);
    }
}
