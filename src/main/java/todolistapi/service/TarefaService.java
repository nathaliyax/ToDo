package todolistapi.service;

import com.bernardo.todolistapi.dto.TarefasRequestDTO;
import com.nathy.todolistapi.dto.TarefasResponseDTO;
import com.nathy.todolistapi.entity.Tarefas;
import com.nathy.todolistapi.repository.TarefasRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    private final TarefasRepository tarefasRepository;

    public TarefaService(TarefasRepository tarefasRepository) {
        this.tarefasRepository = tarefasRepository;
    }

    // Cadastrar usuarios
    public String saveTasks(TarefasRequestDTO tasks){
        Tarefas tarefa = new Tarefas(tasks);
        tarefasRepository.save(tarefa);
        return "Tarefa salva com sucesso";
    }

    // Listar todos os usuarios

    // Metodo novo com lambda
    public List<TarefasResponseDTO> listTasks(){
        List<Tarefas> tarefas = tarefasRepository.findAll();
        List<TarefasResponseDTO> tarefasDTO = tarefas.stream()
                .map(tarefa -> new TarefasResponseDTO(tarefa))
                .toList();
        return tarefasDTO;
    }

    // Deletar Usuario
    public String deleteTasks(long id){
        if (!tarefasRepository.existsById(id)) {
            return "Tarefa nao encontrada";
        } else {
            tarefasRepository.deleteById(id);
        return "Tarefa deletada com sucesso";
        }
    }

    // Procurar pelo ID
    public TarefasResponseDTO searchTask(@PathVariable long id){
        Optional<Tarefas> tarefas = tarefasRepository.findById(id);
        if (tarefas.isEmpty()) {
            return null;
        }
        TarefasResponseDTO tarefasResponseDTO = new TarefasResponseDTO(tarefas.get());
        return tarefasResponseDTO;
    }

    // Atualizar o usuario
    public String updateTasks(long id, TarefasRequestDTO user) {
        if (!tarefasRepository.existsById(id)) {
            return "Tarefa nao encontrada";
        } else {
            Tarefas updateTasks = tarefasRepository.findById(id).get();
            updateTasks.setTarefa(user.getTarefa());
            updateTasks.setTarefa(user.getTarefa());
            updateTasks.setPrazo(user.getPrazo());
            tarefasRepository.save(updateTasks);
            return "Tarefa deletada com sucesso";
        }
    }

}
