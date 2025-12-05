package com.Kartconnecting.Backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "EQUIPOS")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EQUIPO")
    private Long id_equipo;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "REGION")
    private String region;
}

