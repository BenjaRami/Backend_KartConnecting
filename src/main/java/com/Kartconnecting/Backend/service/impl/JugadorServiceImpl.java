package com.Kartconnecting.Backend.service.impl;

import com.Kartconnecting.Backend.model.Jugador;
import com.Kartconnecting.Backend.model.User;
import com.Kartconnecting.Backend.repository.JugadorRepository;
import com.Kartconnecting.Backend.repository.UserRepository;
import com.Kartconnecting.Backend.service.JugadorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorServiceImpl implements JugadorService {

    private final JugadorRepository jugadorRepository;
    private final UserRepository userRepository;

    public JugadorServiceImpl(JugadorRepository jugadorRepository, UserRepository userRepository) {
        this.jugadorRepository = jugadorRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Jugador> listar() {
        return jugadorRepository.findAll();
    }

    @Override
    public Jugador obtenerPorId(Integer id) {
        return jugadorRepository.findById(id).orElse(null);
    }

    @Override
    public Jugador crear(Jugador jugador) {

        // Guardar jugador
        Jugador nuevo = jugadorRepository.save(jugador);

        // Crear usuario
        User user = new User();
        user.setEmail(jugador.getCorreo());
        user.setPassword(jugador.getPassword());
        user.setNombre(jugador.getNombreGamer());

        userRepository.save(user);

        return nuevo;
    }

    @Override
    public Jugador actualizar(Integer id, Jugador jugador) {
        Jugador existente = jugadorRepository.findById(id).orElse(null);

        if (existente == null) {
            return null;
        }

        existente.setNombreGamer(jugador.getNombreGamer());
        existente.setCorreo(jugador.getCorreo());
        existente.setPais(jugador.getPais());
        existente.setNivelCompetitivo(jugador.getNivelCompetitivo());
        existente.setBio(jugador.getBio());
        existente.setDisponible(jugador.getDisponible());
        existente.setPassword(jugador.getPassword());

        return jugadorRepository.save(existente);
    }

    @Override
    public void eliminar(Integer id) {
        jugadorRepository.deleteById(id);
    }
}


