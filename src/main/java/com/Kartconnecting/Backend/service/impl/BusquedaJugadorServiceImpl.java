package com.Kartconnecting.Backend.service.impl;

import com.Kartconnecting.Backend.model.BusquedaJugador;
import com.Kartconnecting.Backend.repository.BusquedaJugadorRepository;
import com.Kartconnecting.Backend.service.BusquedaJugadorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusquedaJugadorServiceImpl implements BusquedaJugadorService {

    private final BusquedaJugadorRepository repo;

    public BusquedaJugadorServiceImpl(BusquedaJugadorRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<BusquedaJugador> listar() {
        return repo.findAll();
    }

    @Override
    public BusquedaJugador obtenerPorId(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public BusquedaJugador crear(BusquedaJugador busqueda) {
        return repo.save(busqueda);
    }

    @Override
    public BusquedaJugador actualizar(Integer id, BusquedaJugador busqueda) {
        BusquedaJugador existente = obtenerPorId(id);
        if (existente == null) return null;

        existente.setEstado(busqueda.getEstado());
        existente.setId_equipo(busqueda.getId_equipo());
        existente.setNivelMinimo(busqueda.getNivelMinimo());
        existente.setRolNecesario(busqueda.getRolNecesario());
        return repo.save(existente);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}

