package todolistapi.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_tarefa")
public class Tarefas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String nome;

    @Column(length = 100)
    private String tarefa;

    @Enumerated(EnumType.STRING)
    private StatusTarefa status;

    @Column(length = 100)
    private Date prazo;

    public Tarefas() {
    }

    public Tarefas(com.nathy.todolistapi.entity.TarefasRequestDTO task) {
        this.nome = task.getNome();
        this.tarefa = task.getTarefa();
        this.status = StatusTarefa.PENDENTE;
    }

    public String getNome() {
        return nome;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }
}
