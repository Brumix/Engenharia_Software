package EngSoftProjeto.Repositories;

import EngSoftProjeto.Models.Tarefa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TarefaRepository extends CrudRepository<Tarefa, Long> {
    Optional<Tarefa> findByNome(String nome);
}
