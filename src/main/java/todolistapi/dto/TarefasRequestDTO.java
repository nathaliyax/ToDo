package todolistapi.dto;


import jakarta.validation.constraints.NotNull;
import todolistapi.entity.StatusTarefa;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public class TarefasRequestDTO {

    @NotBlank(message = "Digite um nome valido")
    private String nome;

    @NotBlank(message = "Digite uma tarefa valida")
    private String tarefa;

    @NotNull(message = "Digite um status valido")
    private StatusTarefa status;

    @NotNull(message = "Digite uma data valida")
    private Date prazo;

    public TarefasRequestDTO(String nome, String tarefa, StatusTarefa status, Date prazo) {
        this.nome = nome;
        this.tarefa = tarefa;
        this.status = status;
        this.prazo = prazo;
    }

    public String getNome() {
        return nome;
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

    public StatusTarefa getStatus() {
        return status;
    }

    public void setStatus(StatusTarefa status) {
        this.status = status;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }
}
