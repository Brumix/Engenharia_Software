package EngSoftProjeto.services.usecases.facade;

import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MostrarTodosOsClientesUseCase {
    private final ClienteRepository clienteRepository;

    public MostrarTodosOsClientesUseCase(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }

}