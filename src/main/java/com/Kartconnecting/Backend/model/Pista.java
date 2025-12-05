package com.Kartconnecting.Backend.model;

import com.Kartconnecting.Backend.converter.DificultadPistaConverter;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PISTAS")
public class Pista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PISTA")
    private Long id_pista;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "ESCENARIO")
    private String escenario;

    @Column(name = "DIFICULTAD")
    @Convert(converter = DificultadPistaConverter.class)
    private DificultadPista dificultad;
}

