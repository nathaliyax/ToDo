package todolistapi.service;

import com.nathy.todolistapi.dto.UsuarioRequestDTO;
import com.nathy.todolistapi.dto.UsuarioResponseDTO;
import com.nathy.todolistapi.entity.Usuario;
import com.nathy.todolistapi.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Cadastrar usuarios
    public String saveUser(UsuarioRequestDTO user){
        Usuario usuario = new Usuario(user);
        usuarioRepository.save(usuario);
        return "Usuario salvo com sucesso";
    }

    // Login com email e senha
    public String findUser(Usuario user){
        Usuario findUser = usuarioRepository.findByEmail(user.getEmail());
        if (findUser == null) {
            return "Logado com sucesso";
        } else {
            if (findUser.getSenha().equals(user.getSenha())) {
                return "Logado com sucesso";
            } else {
                return "Senha está incorreta";
            }
        }
    }

    // Listar todos os usuarios

    // Metodo novo com lambda
    public List<UsuarioResponseDTO> listUsers(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioResponseDTO> usuariosDTO = usuarios.stream()
                .map(usuario -> new UsuarioResponseDTO(usuario))
                .toList();
        return usuariosDTO;
    }

    // Deletar Usuario
    public String deleteUser(long id){
        if (!usuarioRepository.existsById(id)) {
            return "Usuario nao encontrado";
        } else {
            usuarioRepository.deleteById(id);
        return "Usuario deletado com sucesso";
        }
    }

    // Procurar pelo ID
    public UsuarioResponseDTO searchUser(@PathVariable long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()) {
            return null;
        }
        UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO(usuario.get());
        return usuarioResponseDTO;
    }

    // Atualizar o usuario
    public String updateUser(long id, UsuarioRequestDTO user) {
        if (!usuarioRepository.existsById(id)) {
            return "Usuario nao encontrado";
        } else {
            Usuario updateUser = usuarioRepository.findById(id).get();
            updateUser.setNome(user.getNome());
            updateUser.setEmail(user.getEmail());
            usuarioRepository.save(updateUser);
            return "Usuario deletado com sucesso";
        }
    }

}
