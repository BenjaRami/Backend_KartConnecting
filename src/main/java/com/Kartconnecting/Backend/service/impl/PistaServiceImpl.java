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

    @Override
    public List<Pista> findAll() {
        return pistaRepository.findAll();
    }

    @Override
    public Pista findById(Integer id) {
        return pistaRepository.findById(id).orElse(null);
    }

    @Override
    public Pista save(Pista pista) {
        return pistaRepository.save(pista);
    }

    @Override
    public Pista update(Integer id, Pista pista) {

        Pista existente = pistaRepository.findById(id).orElse(null);
        if (existente == null) return null;

        existente.setNombre(pista.getNombre());
        existente.setEscenario(pista.getEscenario());
        existente.setDificultad(pista.getDificultad());

        return pistaRepository.save(existente);
    }

    @Override
    public void delete(Integer id) {
        pistaRepository.deleteById(id);
    }
}

