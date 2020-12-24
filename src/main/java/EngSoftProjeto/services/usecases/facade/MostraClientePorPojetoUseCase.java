package EngSoftProjeto.services.usecases.facade;


import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Repositories.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class MostraClientePorPojetoUseCase {
    private final ClienteRepository clienteRepository;



    public MostraClientePorPojetoUseCase(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;

    }

    public Optional<Cliente> mostraClientePorPojeto(Projeto projeto) {
        log.info("Acesso aos clientes do projeto: "+projeto.getNome());
        return clienteRepository.findById(projeto.getId());
    }
}
