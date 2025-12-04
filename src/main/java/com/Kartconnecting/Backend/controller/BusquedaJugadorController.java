package com.Kartconnecting.Backend.controller;

import com.Kartconnecting.Backend.model.BusquedaJugador;
import com.Kartconnecting.Backend.service.BusquedaJugadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/busquedas")
@CrossOrigin("*")
public class BusquedaJugadorController {

    private final BusquedaJugadorService service;

    public BusquedaJugadorController(BusquedaJugadorService service) {
        this.service = service;
    }

    @GetMapping
    public List<BusquedaJugador> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusquedaJugador> obtener(@PathVariable Integer id) {
        BusquedaJugador busqueda = service.obtenerPorId(id);
        return busqueda != null ? ResponseEntity.ok(busqueda) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public BusquedaJugador crear(@RequestBody BusquedaJugador busqueda) {
        return service.crear(busqueda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusquedaJugador> actualizar(@PathVariable Integer id, @RequestBody BusquedaJugador busqueda) {
        BusquedaJugador actualizado = service.actualizar(id, busqueda);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

