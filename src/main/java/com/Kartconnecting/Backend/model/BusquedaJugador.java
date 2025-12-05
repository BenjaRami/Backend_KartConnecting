package com.Kartconnecting.Backend.model;

import com.Kartconnecting.Backend.converter.EstadoBusquedaConverter;
import com.Kartconnecting.Backend.converter.NivelCompetitivoConverter;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "BUSQUEDAS_JUGADORES")
public class BusquedaJugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BUSQUEDA")
    private Long id_busqueda;

    @Column(name = "ID_EQUIPO")
    private Long id_equipo;

    @Column(name = "ROL_NECESARIO")
    private String rolNecesario;

    @Column(name = "NIVEL_MINIMO")
    @Convert(converter = NivelCompetitivoConverter.class)
    private NivelCompetitivo nivelMinimo;

    @Column(name = "ESTADO")
    @Convert(converter = EstadoBusquedaConverter.class)
    private EstadoBusqueda estado;
}


