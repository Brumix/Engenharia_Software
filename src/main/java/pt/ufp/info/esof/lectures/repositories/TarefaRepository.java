package pt.ufp.info.esof.lectures.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.ufp.info.esof.lectures.models.Tarefa;

@Repository
public interface TarefaRepository extends CrudRepository<Tarefa,Long> {
}
