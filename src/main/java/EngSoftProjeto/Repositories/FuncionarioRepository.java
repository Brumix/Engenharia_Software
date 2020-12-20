package EngSoftProjeto.Repositories;

import EngSoftProjeto.Models.Funcionario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario,Long > {
}
