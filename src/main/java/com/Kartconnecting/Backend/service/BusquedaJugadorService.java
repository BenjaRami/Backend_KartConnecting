package com.Kartconnecting.Backend.service;

import com.Kartconnecting.Backend.model.BusquedaJugador;
import java.util.List;

public interface BusquedaJugadorService {

    List<BusquedaJugador> listar();
    BusquedaJugador obtenerPorId(Integer id);
    BusquedaJugador crear(BusquedaJugador busqueda);
    BusquedaJugador actualizar(Integer id, BusquedaJugador busqueda);
    void eliminar(Integer id);
}
