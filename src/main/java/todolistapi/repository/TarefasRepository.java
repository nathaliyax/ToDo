package todolistapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import todolistapi.entity.Tarefas;

import java.util.List;

@Repository
public interface TarefasRepository extends JpaRepository<Tarefas, Long> {
    List<Tarefas> findByCliente_Id(Long cliente);
}