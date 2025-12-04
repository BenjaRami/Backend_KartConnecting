package com.Kartconnecting.Backend.controller;

import com.Kartconnecting.Backend.model.MiembroEquipo;
import com.Kartconnecting.Backend.service.MiembroEquipoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/miembros-equipo")
@CrossOrigin("*")
public class MiembroEquipoController {

    private final MiembroEquipoService service;

    public MiembroEquipoController(MiembroEquipoService service) {
        this.service = service;
    }

    @GetMapping
    public List<MiembroEquipo> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MiembroEquipo> obtener(@PathVariable Integer id) {
        MiembroEquipo miembro = service.obtenerPorId(id);
        return miembro != null ? ResponseEntity.ok(miembro) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public MiembroEquipo crear(@RequestBody MiembroEquipo miembro) {
        return service.crear(miembro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MiembroEquipo> actualizar(@PathVariable Integer id, @RequestBody MiembroEquipo miembro) {
        MiembroEquipo actualizado = service.actualizar(id, miembro);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

