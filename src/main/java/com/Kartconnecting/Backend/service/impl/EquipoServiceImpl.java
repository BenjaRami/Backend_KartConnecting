package com.Kartconnecting.Backend.service.impl;

import com.Kartconnecting.Backend.model.Equipo;
import com.Kartconnecting.Backend.repository.EquipoRepository;
import com.Kartconnecting.Backend.service.EquipoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoServiceImpl implements EquipoService {

    private final EquipoRepository equipoRepository;

    public EquipoServiceImpl(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    // ========================
    // LISTAR
    // ========================
    @Override
    public List<Equipo> listar() {
        return equipoRepository.findAll();
    }

    // ========================
    // OBTENER POR ID
    // ========================
    @Override
    public Equipo obtenerPorId(Integer id) {
        return equipoRepository.findById(id).orElse(null);
    }

    // ========================
    // CREAR
    // ========================
    @Override
    public Equipo crear(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    // ========================
    // ACTUALIZAR (update completo)
    // ========================
    @Override
    public Equipo actualizar(Integer id, Equipo equipoActualizado) {

        return equipoRepository.findById(id)
                .map(equipo -> {

                    equipo.setNombre(equipoActualizado.getNombre());
                    equipo.setRegion(equipoActualizado.getRegion());

                    return equipoRepository.save(equipo);
                })
                .orElse(null);
    }

    // ========================
    // ELIMINAR
    // ========================
    @Override
    public void eliminar(Integer id) {
        equipoRepository.deleteById(id);
    }
}


