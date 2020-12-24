package EngSoftProjeto.services.usecases.facade;


import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class MostrarPorIdClienteUseCase {
    private final ClienteRepository clienteRepository;

    public MostrarPorIdClienteUseCase(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }
}




