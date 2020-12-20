package EngSoftProjeto.services.usecases.facade;

import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Repositories.ClienteRepository;
import EngSoftProjeto.Repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CriarClienteUseCase {
    private final ClienteRepository clienteRepository;
    private final ProjetoRepository projetoRepository;

    @Autowired
    public CriarClienteUseCase(ClienteRepository clienteRepository, ProjetoRepository projetoRepository) {
        this.clienteRepository = clienteRepository;
        this.projetoRepository = projetoRepository;
    }


    public Optional<Cliente> createExplicador(Cliente cliente) {
        Optional<Cliente> optionalcliente = clienteRepository.findById(cliente.getId());//email mudar
        if (optionalcliente.isEmpty()) {
            clienteRepository.save(cliente);
            List<Projeto> projetos = new ArrayList<>();
            cliente.getProjetos().forEach(projeto -> {
                Optional<Projeto> optionalProjeto = projetoRepository.findById(projeto.getId());//nome mudar
                if (optionalProjeto.isPresent()) {
                    projetos.add(projeto);
                    projeto.adicionaCliente(cliente);
                    projetoRepository.save(optionalProjeto.get());
                }
            });
            cliente.setProjetos(projetos);
            return Optional.of(clienteRepository.save(cliente));
        }
        return Optional.empty();
    }
}




