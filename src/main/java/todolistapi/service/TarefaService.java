package todolistapi.service;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import todolistapi.dto.TarefasRequestDTO;
import todolistapi.dto.TarefasResponseDTO;
import todolistapi.entity.Tarefas;
import todolistapi.repository.TarefasRepository;
import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    private final TarefasRepository tarefasRepository;

    public TarefaService(TarefasRepository tarefasRepository) {
        this.tarefasRepository = tarefasRepository;
    }

    public String saveTasks(TarefasRequestDTO tasks){
        Tarefas tarefa = new Tarefas(tasks);
        tarefasRepository.save(tarefa);
        return "Tarefa salva com sucesso";
    }

    public List<TarefasResponseDTO> listTasks(){
        List<Tarefas> tarefas = tarefasRepository.findAll();
        List<TarefasResponseDTO> tarefasDTO = tarefas.stream()
                .map(tarefa -> new TarefasResponseDTO(tarefa))
                .toList();
        return tarefasDTO;
    }

    public String deleteTasks(long id){
        if (!tarefasRepository.existsById(id)) {
            return "Tarefa nao encontrada";
        } else {
            tarefasRepository.deleteById(id);
        return "Tarefa OUT";
        }
    }

    public TarefasResponseDTO searchTask(@PathVariable long id){
        Optional<Tarefas> tarefas = tarefasRepository.findById(id);
        if (tarefas.isEmpty()) {
            return null;
        }
        TarefasResponseDTO tarefasResponseDTO = new TarefasResponseDTO(tarefas.get());
        return tarefasResponseDTO;
    }

    public String updateTarefas(long id, TarefasRequestDTO user) {
        if (!tarefasRepository.existsById(id)) {
            return "não achei, bb :/";
        } else {
            Tarefas updateTarefas = tarefasRepository.findById(id).get();
            updateTarefas.setTarefa(user.getTarefa());
            updateTarefas.setTarefa(user.getTarefa());
            updateTarefas.setPrazo(user.getPrazo());
            tarefasRepository.save(updateTarefas);
            return "Tarefa OUT";
        }
    }

}
