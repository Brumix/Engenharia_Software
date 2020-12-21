package EngSoftProjeto.services.usecases.facade.cliente;


import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdicionarProjectoClienteUseCase {
    private final ClienteRepository clienteRepository;

    @Autowired
    public AdicionarProjectoClienteUseCase(ClienteRepository clienteRepository) {
        this.clienteRepository=clienteRepository;
    }




    public Optional<Cliente> adicionaProjetos(Long clienteId, Projeto projeto) {
        Optional<Cliente> optionalCliente=this.clienteRepository.findById(clienteId);
        if(optionalCliente.isPresent()){
           Cliente cliente=optionalCliente.get();
            int quantidadeDeDisponibilidadesAntes=cliente.getProjetos().size();
            cliente.adicionaProjecto(projeto);
            int quantidadedeDisponibilidadesDepois=cliente.getProjetos().size();
            if(quantidadeDeDisponibilidadesAntes!=quantidadedeDisponibilidadesDepois) {
                return Optional.of(cliente);
            }
        }
        return Optional.empty();
    }
}