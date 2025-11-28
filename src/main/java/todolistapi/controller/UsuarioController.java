package todolistapi.controller;

import com.nathy.todolistapi.dto.UsuarioRequestDTO;
import com.nathy.todolistapi.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UsuarioController {

    // Injeção de dependencias
    @Autowired
    UsuarioService usuarioService;

    // Cadastrar usuarios
    @PostMapping
    public ResponseEntity<?> saveUser(@Valid @RequestBody UsuarioRequestDTO user){
        return ResponseEntity.ok(usuarioService.saveUser(user));
    }

    @GetMapping
    public ResponseEntity<?> listUsers(){
        return ResponseEntity.ok(usuarioService.listUsers());
    }


    // Deletar Usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        return ResponseEntity.ok(usuarioService.deleteUser(id));
    }

    // Procurar pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<?> searchUser(@PathVariable int id){
        return ResponseEntity.ok(usuarioService.searchUser(id));
    }

    // Atualizar o usur
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody UsuarioRequestDTO user) {
        return ResponseEntity.ok(usuarioService.updateUser(id, user));
    }
}


