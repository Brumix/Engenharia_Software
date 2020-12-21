package EngSoftProjeto.services.usecases.facade.cliente;

import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Models.Projeto;

import java.util.Optional;

public interface AdicionarProjectoClienteUseCaseI {
    Optional<Cliente> adicionaProjetos(Long clienteId, Projeto projeto);
}
