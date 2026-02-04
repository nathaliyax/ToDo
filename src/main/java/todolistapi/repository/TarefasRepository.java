package todolistapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import todolistapi.entity.Tarefas;

@Repository
public interface TarefasRepository extends JpaRepository<Tarefas, Long> {
}