package com.Kartconnecting.Backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CARRERAS")
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CARRERA")
    private Long id_carrera;

    @Column(name = "ID_JUGADOR")
    private Long id_jugador;

    @Column(name = "ID_PISTA")
    private Long id_pista;

    @Column(name = "ID_TORNEO")
    private Long id_torneo;

    @Column(name = "POSICION")
    private Integer posicion;
}
