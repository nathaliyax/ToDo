package todolistapi.entity;

import com.nathy.todolistapi.dto.UsuarioRequestDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100)
    private String nome;
    @Column(length = 80, unique = true)
    private String email;
    @Column(length = 50)
    private String senha;


    public Usuario() {
    }

    public Usuario(UsuarioRequestDTO user) {
        this.nome = user.getNome();
        this.senha = user.getSenha();
        this.email = user.getEmail();
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}