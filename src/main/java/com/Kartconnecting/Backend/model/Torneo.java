package com.Kartconnecting.Backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TORNEOS")
public class Torneo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "torneos_seq")
    @SequenceGenerator(name = "torneos_seq", sequenceName = "seq_torneos", allocationSize = 1)
    @Column(name = "id_torneo")
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "premio")
    private String premio;

    // ===== Getters y Setters =====

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getPremio() {
        return premio;
    }

    public void setPremio(String premio) {
        this.premio = premio;
    }
}

