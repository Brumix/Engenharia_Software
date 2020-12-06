package pt.ufp.info.esof.lectures.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.ufp.info.esof.lectures.models.Funcionario;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario,Long> {
    Optional<Funcionario> findByEmail(String email);
}
