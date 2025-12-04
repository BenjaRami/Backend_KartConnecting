package com.Kartconnecting.Backend.service;

import com.Kartconnecting.Backend.model.Equipo;
import java.util.List;

public interface EquipoService {

    List<Equipo> listar();
    Equipo obtenerPorId(Integer id);
    Equipo crear(Equipo equipo);
    Equipo actualizar(Integer id, Equipo equipo);
    void eliminar(Integer id);

}
