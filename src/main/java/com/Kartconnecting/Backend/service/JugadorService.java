package com.Kartconnecting.Backend.service;

import com.Kartconnecting.Backend.model.Jugador;
import java.util.List;

public interface JugadorService {

    List<Jugador> listar();
    Jugador obtenerPorId(Integer id);
    Jugador crear(Jugador jugador);
    Jugador actualizar(Integer id, Jugador jugador);
    void eliminar(Integer id);
}
