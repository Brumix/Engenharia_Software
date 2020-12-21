package EngSoftProjeto.Repositories;

import EngSoftProjeto.Models.Funcionario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //String pq chave primaria de Empregado é o nome pq é unico
public interface FuncionarioRepository extends CrudRepository<Funcionario,Long > {
}
