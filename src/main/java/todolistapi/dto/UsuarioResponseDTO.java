package todolistapi.dto;

import com.nathy.todolistapi.entity.Usuario;

public class UsuarioResponseDTO {

    private long id;
    private String nome;
    private String email;

    public UsuarioResponseDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
