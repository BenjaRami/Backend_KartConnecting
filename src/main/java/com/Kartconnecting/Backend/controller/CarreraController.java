package com.Kartconnecting.Backend.controller;

import com.Kartconnecting.Backend.model.Carrera;
import com.Kartconnecting.Backend.service.CarreraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carreras")
@CrossOrigin("*")
public class CarreraController {

    private final CarreraService service;

    public CarreraController(CarreraService service) {
        this.service = service;
    }

    @GetMapping
    public List<Carrera> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrera> obtener(@PathVariable Integer id) {
        Carrera carrera = service.obtenerPorId(id);
        return carrera != null ? ResponseEntity.ok(carrera) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Carrera crear(@RequestBody Carrera carrera) {
        return service.crear(carrera);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrera> actualizar(@PathVariable Integer id, @RequestBody Carrera carrera) {
        Carrera actualizado = service.actualizar(id, carrera);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

