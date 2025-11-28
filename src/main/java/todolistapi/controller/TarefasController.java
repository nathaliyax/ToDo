package todolistapi.controller;


import com.nathy.todolistapi.entity.Tarefas;
import com.nathy.todolistapi.repository.TarefasRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {
    private final TarefasRepository tasks;

    public TarefasController(TarefasRepository tarefas) {
        this.tasks = tarefas;
    }

    @PostMapping("salvar")
    public Tarefas salvar(@RequestBody Tarefas tarefas) {
        return tasks.save(tarefas);
    }

    @GetMapping("mostrar")
    public List<Tarefas> mostrar() {
        List<Tarefas> Tarefas = tasks.findAll();
        return Tarefas;
    }

    @GetMapping("mostrar1")
    public String mostrar1() {
        List<Tarefas> Tarefas = tasks.findAll();
        return "Deivao tem encontro a luz de velas e so com roupas intimas com o fabbri no sabado";
    }

}