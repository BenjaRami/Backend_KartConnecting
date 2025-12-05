package com.Kartconnecting.Backend.service.impl;

import com.Kartconnecting.Backend.model.Jugador;
import com.Kartconnecting.Backend.repository.JugadorRepository;
import com.Kartconnecting.Backend.service.JugadorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorServiceImpl implements JugadorService {

    private final JugadorRepository jugadorRepository;

    public JugadorServiceImpl(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    // ========================
    //  LISTAR
    // ========================
    @Override
    public List<Jugador> listar() {
        return jugadorRepository.findAll();
    }

    // ========================
    //  OBTENER POR ID
    // ========================
    @Override
    public Jugador obtenerPorId(Integer id) {
        return jugadorRepository.findById(id).orElse(null);
    }

    // ========================
    //  CREAR
    // ========================
    @Override
    public Jugador crear(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    // ========================
    //  ACTUALIZAR (update COMPLETO)
    // ========================
    @Override
    public Jugador actualizar(Integer id, Jugador jugadorActualizado) {

        return jugadorRepository.findById(id)
                .map(jugador -> {

                    // Reemplaza todos los campos
                    jugador.setNombreGamer(jugadorActualizado.getNombreGamer());
                    jugador.setCorreo(jugadorActualizado.getCorreo());
                    jugador.setPais(jugadorActualizado.getPais());
                    jugador.setNivel(jugadorActualizado.getNivel());
                    jugador.setBio(jugadorActualizado.getBio());

                    return jugadorRepository.save(jugador);
                })
                .orElse(null);
    }

    // ========================
    //  ELIMINAR
    // ========================
    @Override
    public void eliminar(Integer id) {
        jugadorRepository.deleteById(id);
    }
}



