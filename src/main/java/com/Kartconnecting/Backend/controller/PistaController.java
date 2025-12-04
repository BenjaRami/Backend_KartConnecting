package com.Kartconnecting.Backend.controller;

import com.Kartconnecting.Backend.model.Pista;
import com.Kartconnecting.Backend.service.PistaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pistas")
public class PistaController {

    private final PistaService pistaService;

    public PistaController(PistaService pistaService) {
        this.pistaService = pistaService;
    }

    @GetMapping
    public List<Pista> getAll() {
        return pistaService.findAll();
    }

    @GetMapping("/{id}")
    public Pista getById(@PathVariable Integer id) {
        return pistaService.findById(id);
    }

    @PostMapping
    public Pista create(@RequestBody Pista pista) {
        return pistaService.save(pista);
    }

    @PutMapping("/{id}")
    public Pista update(@PathVariable Integer id, @RequestBody Pista pista) {
        return pistaService.update(id, pista);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        pistaService.delete(id);
    }
}
