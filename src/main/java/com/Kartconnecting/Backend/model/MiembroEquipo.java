package com.Kartconnecting.Backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "MIEMBROS_EQUIPO")
public class MiembroEquipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MIEMBRO")
    private Long id_miembro;

    @Column(name = "ID_JUGADOR")
    private Long id_jugador;

    @Column(name = "ID_EQUIPO")
    private Long id_equipo;

    @Column(name = "ROL")
    private String rol;
}

