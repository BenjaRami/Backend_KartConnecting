package com.Kartconnecting.Backend.service;

import com.Kartconnecting.Backend.model.MiembroEquipo;
import java.util.List;

public interface MiembroEquipoService {

    List<MiembroEquipo> listar();
    MiembroEquipo obtenerPorId(Integer id);
    MiembroEquipo crear(MiembroEquipo miembro);
    MiembroEquipo actualizar(Integer id, MiembroEquipo miembro);
    void eliminar(Integer id);
}
