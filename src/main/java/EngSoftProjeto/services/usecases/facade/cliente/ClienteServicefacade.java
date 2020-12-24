package EngSoftProjeto.services.usecases.facade.cliente;

import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Models.Projeto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicefacade implements ClienteServiceFacadeI {

    private final AdicionarProjectoClienteUseCase adicionarProjectoClienteUseCase ;
    private final CriarClienteUseCase criarClienteUseCase;
    private final MostrarPorIdClienteUseCase mostrasPorIdUseCase;
    private final MostrarTodosClientesUseCase mostrarTodosClientesUseCase;


    public ClienteServicefacade(AdicionarProjectoClienteUseCase adicionarProjectoClienteUseCase, CriarClienteUseCase criarClienteUseCase, MostrarPorIdClienteUseCase mostrasPorIdUseCase, MostrarTodosClientesUseCase mostrarTodosClientesUseCase) {
        this.adicionarProjectoClienteUseCase = adicionarProjectoClienteUseCase;
        this.criarClienteUseCase = criarClienteUseCase;
        this.mostrasPorIdUseCase = mostrasPorIdUseCase;
        this.mostrarTodosClientesUseCase = mostrarTodosClientesUseCase;
    }

    @Override
    public List<Cliente> encontraTodos() {
        return mostrarTodosClientesUseCase.findAll();
    }

    @Override
    public Optional<Cliente> encontraId(Long id) {
        return mostrasPorIdUseCase.findById(id);
    }

    @Override
    public Optional<Cliente> criaCliente(Cliente converter) {
        return criarClienteUseCase.criarcliente(converter);
    }

    @Override
    public Optional<Cliente> adicionaProjecto(Long clienteId, Projeto projecto) {
        return adicionarProjectoClienteUseCase.adicionaProjetos(clienteId,projecto);
    }
}
