package com.Kartconnecting.Backend.model;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TORNEOS")
public class Torneo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TORNEO")
    private Long id_torneo;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "FECHA_INICIO")
    private Date fecha_inicio;

    @Column(name = "FECHA_FIN")
    private Date fecha_fin;

    @Column(name = "PREMIO")
    private String premio;
}


