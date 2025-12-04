package com.Kartconnecting.Backend.controller;

import com.Kartconnecting.Backend.model.Jugador;
import com.Kartconnecting.Backend.service.JugadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
@CrossOrigin("*")
public class JugadorController {

    private final JugadorService service;

    public JugadorController(JugadorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Jugador> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jugador> obtener(@PathVariable Integer id) {
        Jugador jugador = service.obtenerPorId(id);
        return jugador != null ? ResponseEntity.ok(jugador) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Jugador crear(@RequestBody Jugador jugador) {
        return service.crear(jugador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jugador> actualizar(@PathVariable Integer id, @RequestBody Jugador jugador) {
        Jugador actualizado = service.actualizar(id, jugador);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

