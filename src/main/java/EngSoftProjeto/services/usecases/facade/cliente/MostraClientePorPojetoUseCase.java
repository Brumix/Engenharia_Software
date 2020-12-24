package EngSoftProjeto.services.usecases.facade.cliente;


import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MostraClientePorPojetoUseCase {
    private final ClienteRepository clienteRepository;

    public MostraClientePorPojetoUseCase(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;

    }

    public Optional<Cliente> mostraClientePorPojeto(Projeto projeto) {
        return clienteRepository.findById(projeto.getId());
    }
}
