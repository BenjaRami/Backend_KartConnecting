package com.Kartconnecting.Backend.service.impl;

import com.Kartconnecting.Backend.model.Carrera;
import com.Kartconnecting.Backend.repository.CarreraRepository;
import com.Kartconnecting.Backend.service.CarreraService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreraServiceImpl implements CarreraService {

    private final CarreraRepository repo;

    public CarreraServiceImpl(CarreraRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Carrera> listar() {
        return repo.findAll();
    }

    @Override
    public Carrera obtenerPorId(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Carrera crear(Carrera carrera) {
        return repo.save(carrera);
    }

    @Override
    public Carrera actualizar(Integer id, Carrera carrera) {
        Carrera existente = obtenerPorId(id);
        if (existente == null) return null;

        existente.setTorneo(carrera.getTorneo());
        existente.setPista(carrera.getPista());
        existente.setFecha(carrera.getFecha());
        existente.setHora(carrera.getHora());

        return repo.save(existente);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}

