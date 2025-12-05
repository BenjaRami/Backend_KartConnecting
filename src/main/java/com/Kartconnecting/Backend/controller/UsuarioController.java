package com.Kartconnecting.Backend.controller;

import com.Kartconnecting.Backend.model.User;
import com.Kartconnecting.Backend.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    private final UserRepository repo;

    public UsuarioController(UserRepository repo) {
        this.repo = repo;
    }

    // Listar todos los usuarios
    @GetMapping
    public List<User> getAll() {
        return repo.findAll();
    }

    // Obtener usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear usuario
    @PostMapping
    public User create(@RequestBody User user) {
        return repo.save(user);
    }

    // Actualizar usuario
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {

        return repo.findById(id)
                .map(u -> {
                    u.setEmail(user.getEmail());
                    u.setPassword(user.getPassword());
                    u.setName(user.getName());
                    return ResponseEntity.ok(repo.save(u));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


