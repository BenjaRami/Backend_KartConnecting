package com.Kartconnecting.Backend.model;

import com.Kartconnecting.Backend.converter.NivelCompetitivoConverter;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "JUGADORES")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_JUGADOR")
    private Long id_jugador;

    @Column(name = "NOMBRE_GAMER")
    private String nombreGamer;

    @Column(name = "CORREO")
    private String correo;

    @Column(name = "PAIS")
    private String pais;

    @Column(name = "NIVEL")
    @Convert(converter = NivelCompetitivoConverter.class)
    private NivelCompetitivo nivel;

    @Column(name = "BIO")
    private String bio;
}

