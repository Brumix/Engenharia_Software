package EngSoftProjeto.services;

import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Models.Projeto;

import java.util.List;
import java.util.Optional;


public interface ClientService {

    List<Cliente> encontraTodos();

    Optional<Cliente> encontraId(Long id);

    Optional<Cliente> criaCliente(Cliente converter);

    Optional<Cliente> adicionaProjecto(Long clienteId, Projeto projecto);
}
