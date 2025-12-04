package com.Kartconnecting.Backend.controller;

import com.Kartconnecting.Backend.model.Torneo;
import com.Kartconnecting.Backend.service.TorneoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/torneos")
@CrossOrigin("*")
public class TorneoController {

    private final TorneoService service;

    public TorneoController(TorneoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Torneo> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Torneo> obtener(@PathVariable Integer id) {
        Torneo torneo = service.obtenerPorId(id);
        return torneo != null ? ResponseEntity.ok(torneo) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Torneo crear(@RequestBody Torneo torneo) {
        return service.crear(torneo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Torneo> actualizar(@PathVariable Integer id, @RequestBody Torneo torneo) {
        Torneo actualizado = service.actualizar(id, torneo);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
