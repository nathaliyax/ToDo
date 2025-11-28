package todolistapi.dto;

import com.nathy.todolistapi.entity.StatusTarefa;
import com.nathy.todolistapi.entity.Tarefas;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TarefasResponseDTO {

    private int id;
    private String nome;
    private String tarefa;
    private StatusTarefa status;
    private Date prazo;
    private Date dataRestante;

    public TarefasResponseDTO(Tarefas tarefas) {
        this.prazo = tarefas.getPrazo();
        this.status = tarefas.getStatus();
        this.tarefa = tarefas.getTarefa();
        this.nome = tarefas.getNome();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTarefa() {
        return tarefa;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public Date getPrazo() {
        return prazo;
    }

    public long getDiasRestantes() {
        if (prazo == null) return 0;
        Date hoje = new Date();
        long diffMillis = prazo.getTime() - hoje.getTime();
        return TimeUnit.DAYS.convert(diffMillis, TimeUnit.MILLISECONDS);
    }

    public String getMensagemStatus() {
        long dias = getDiasRestantes();
        if (dias > 0) return "Faltam " + dias + " dias";
        if (dias == 0) return "Vence hoje!";
        return "Atrasada há " + Math.abs(dias) + " dias";
    }
}
