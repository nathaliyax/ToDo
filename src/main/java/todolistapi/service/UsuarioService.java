package todolistapi.service;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import todolistapi.dto.UsuarioRequestDTO;
import todolistapi.dto.UsuarioResponseDTO;
import todolistapi.entity.Usuario;
import todolistapi.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public String saveUser(UsuarioRequestDTO user){
        Usuario usuario = new Usuario(user);
        usuarioRepository.save(usuario);
        return "Usuario salvo com sucesso";
    }

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

    public List<UsuarioResponseDTO> listUsers(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioResponseDTO> usuariosDTO = usuarios.stream()
                .map(usuario -> new UsuarioResponseDTO(usuario))
                .toList();
        return usuariosDTO;
    }

    public String deleteUser(long id){
        if (!usuarioRepository.existsById(id)) {
            return "Usuario nao encontrado";
        } else {
            usuarioRepository.deleteById(id);
        return "Usuario deletado com sucesso";
        }
    }

    public UsuarioResponseDTO searchUser(@PathVariable long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()) {
            return null;
        }
        UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO(usuario.get());
        return usuarioResponseDTO;
    }

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
