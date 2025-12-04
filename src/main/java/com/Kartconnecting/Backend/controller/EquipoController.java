package com.Kartconnecting.Backend.controller;

import com.Kartconnecting.Backend.model.Equipo;
import com.Kartconnecting.Backend.service.EquipoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
@CrossOrigin("*")
public class EquipoController {

    private final EquipoService service;

    public EquipoController(EquipoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Equipo> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> obtener(@PathVariable Integer id) {
        Equipo equipo = service.obtenerPorId(id);
        return equipo != null ? ResponseEntity.ok(equipo) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Equipo crear(@RequestBody Equipo equipo) {
        return service.crear(equipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipo> actualizar(@PathVariable Integer id, @RequestBody Equipo equipo) {
        Equipo actualizado = service.actualizar(id, equipo);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
