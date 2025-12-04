package com.Kartconnecting.Backend.service.impl;

import com.Kartconnecting.Backend.model.Equipo;
import com.Kartconnecting.Backend.repository.EquipoRepository;
import com.Kartconnecting.Backend.service.EquipoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoServiceImpl implements EquipoService {

    private final EquipoRepository repo;

    public EquipoServiceImpl(EquipoRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Equipo> listar() {
        return repo.findAll();
    }

    @Override
    public Equipo obtenerPorId(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Equipo crear(Equipo equipo) {
        return repo.save(equipo);
    }

    @Override
    public Equipo actualizar(Integer id, Equipo equipo) {
        Equipo existente = obtenerPorId(id);
        if (existente == null) return null;

        existente.setNombre(equipo.getNombre());
        existente.setRegion(equipo.getRegion());
        existente.setFundacion(equipo.getFundacion());

        return repo.save(existente);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
