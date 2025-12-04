package com.Kartconnecting.Backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "EQUIPOS")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipos_seq")
    @SequenceGenerator(name = "equipos_seq", sequenceName = "seq_equipos", allocationSize = 1)
    @Column(name = "id_equipo")
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "region", nullable = false)
    private String region;

    @Column(name = "fundacion")
    private LocalDate fundacion;

    // ======== Getters y Setters ========

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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public LocalDate getFundacion() {
        return fundacion;
    }

    public void setFundacion(LocalDate fundacion) {
        this.fundacion = fundacion;
    }
}

