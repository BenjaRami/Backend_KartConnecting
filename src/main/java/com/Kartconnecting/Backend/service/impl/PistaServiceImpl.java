package com.Kartconnecting.Backend.service.impl;

import com.Kartconnecting.Backend.model.Pista;
import com.Kartconnecting.Backend.repository.PistaRepository;
import com.Kartconnecting.Backend.service.PistaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PistaServiceImpl implements PistaService {

    private final PistaRepository pistaRepository;

    public PistaServiceImpl(PistaRepository pistaRepository) {
        this.pistaRepository = pistaRepository;
    }

    // ========================
    // LISTAR
    // ========================
    @Override
    public List<Pista> findAll() {
        return pistaRepository.findAll();
    }

    // ========================
    // OBTENER POR ID
    // ========================
    @Override
    public Pista findById(Integer id) {
        return pistaRepository.findById(id).orElse(null);
    }

    // ========================
    // CREAR
    // ========================
    @Override
    public Pista save(Pista pista) {
        return pistaRepository.save(pista);
    }

    // ========================
    // ACTUALIZAR (Update completo)
    // ========================
    @Override
    public Pista update(Integer id, Pista pistaActualizada) {

        return pistaRepository.findById(id)
                .map(pista -> {

                    pista.setNombre(pistaActualizada.getNombre());
                    pista.setEscenario(pistaActualizada.getEscenario());
                    pista.setDificultad(pistaActualizada.getDificultad());

                    return pistaRepository.save(pista);
                })
                .orElse(null);
    }

    // ========================
    // ELIMINAR
    // ========================
    @Override
    public void delete(Integer id) {
        pistaRepository.deleteById(id);
    }
}

