package pt.ufp.info.esof.lectures.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.ufp.info.esof.lectures.models.Empressa;

@Repository
public interface EmpressaRepository extends CrudRepository<Empressa,Long> {
}
