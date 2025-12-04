package com.Kartconnecting.Backend.service.impl;

import com.Kartconnecting.Backend.model.Torneo;
import com.Kartconnecting.Backend.repository.TorneoRepository;
import com.Kartconnecting.Backend.service.TorneoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TorneoServiceImpl implements TorneoService {

    private final TorneoRepository repo;

    public TorneoServiceImpl(TorneoRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Torneo> listar() {
        return repo.findAll();
    }

    @Override
    public Torneo obtenerPorId(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Torneo crear(Torneo torneo) {
        return repo.save(torneo);
    }

    @Override
    public Torneo actualizar(Integer id, Torneo torneo) {
        Torneo existente = obtenerPorId(id);
        if (existente == null) return null;

        existente.setNombre(torneo.getNombre());
        existente.setFechaInicio(torneo.getFechaInicio());
        existente.setFechaFin(torneo.getFechaFin());
        existente.setPremio(torneo.getPremio());

        return repo.save(existente);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
