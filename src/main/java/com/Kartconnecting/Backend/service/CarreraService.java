package com.Kartconnecting.Backend.service;

import com.Kartconnecting.Backend.model.Carrera;
import java.util.List;

public interface CarreraService {

    List<Carrera> listar();
    Carrera obtenerPorId(Integer id);
    Carrera crear(Carrera carrera);
    Carrera actualizar(Integer id, Carrera carrera);
    void eliminar(Integer id);
}
