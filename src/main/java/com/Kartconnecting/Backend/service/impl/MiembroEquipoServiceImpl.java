package com.Kartconnecting.Backend.service.impl;

import com.Kartconnecting.Backend.model.MiembroEquipo;
import com.Kartconnecting.Backend.repository.MiembroEquipoRepository;
import com.Kartconnecting.Backend.service.MiembroEquipoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiembroEquipoServiceImpl implements MiembroEquipoService {

    private final MiembroEquipoRepository repo;

    public MiembroEquipoServiceImpl(MiembroEquipoRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<MiembroEquipo> listar() {
        return repo.findAll();
    }

    @Override
    public MiembroEquipo obtenerPorId(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public MiembroEquipo crear(MiembroEquipo miembro) {
        return repo.save(miembro);
    }

    @Override
    public MiembroEquipo actualizar(Integer id, MiembroEquipo miembro) {
        MiembroEquipo existente = obtenerPorId(id);
        if (existente == null) return null;

        existente.setJugador(miembro.getJugador());
        existente.setEquipo(miembro.getEquipo());
        existente.setFechaIngreso(miembro.getFechaIngreso());

        return repo.save(existente);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
