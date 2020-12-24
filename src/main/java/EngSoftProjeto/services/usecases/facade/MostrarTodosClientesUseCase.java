package EngSoftProjeto.services.usecases.facade;

import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MostrarTodosClientesUseCase {
    private final ClienteRepository clienteRepository;

    public MostrarTodosClientesUseCase(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }

}