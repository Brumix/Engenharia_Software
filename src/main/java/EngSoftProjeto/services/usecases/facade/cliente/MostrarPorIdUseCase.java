package EngSoftProjeto.services.usecases.facade.cliente;


import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Repositories.ClienteRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class MostrarPorIdUseCase {
    private final ClienteRepository clienteRepository;

    public MostrarPorIdUseCase(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }
}




