package com.Kartconnecting.Backend.service;

import com.Kartconnecting.Backend.model.Torneo;
import java.util.List;

public interface TorneoService {

    List<Torneo> listar();
    Torneo obtenerPorId(Integer id);
    Torneo crear(Torneo torneo);
    Torneo actualizar(Integer id, Torneo torneo);
    void eliminar(Integer id);
}
