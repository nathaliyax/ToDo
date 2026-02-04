package todolistapi.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todolistapi.dto.UsuarioRequestDTO;
import todolistapi.service.UsuarioService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> saveUser(@Valid @RequestBody UsuarioRequestDTO user){
        return ResponseEntity.ok(usuarioService.saveUser(user));
    }

    @GetMapping
    public ResponseEntity<?> listUsers(){
        return ResponseEntity.ok(usuarioService.listUsers());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        return ResponseEntity.ok(usuarioService.deleteUser(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> searchUser(@PathVariable int id){
        return ResponseEntity.ok(usuarioService.searchUser(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody UsuarioRequestDTO user) {
        return ResponseEntity.ok(usuarioService.updateUser(id, user));
    }
}


