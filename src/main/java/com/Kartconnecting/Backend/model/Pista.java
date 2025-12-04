package com.Kartconnecting.Backend.model;

import com.Kartconnecting.Backend.converter.DificultadPistaConverter;
import jakarta.persistence.*;

@Entity
@Table(name = "PISTAS")
public class Pista {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pistas_seq")
    @SequenceGenerator(name = "pistas_seq", sequenceName = "seq_pistas", allocationSize = 1)
    @Column(name = "id_pista")
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "escenario")
    private String escenario;

    @Convert(converter = DificultadPistaConverter.class)
    @Column(name = "dificultad")
    private DificultadPista dificultad;

    // ======= Getters y Setters ========

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

    public String getEscenario() {
        return escenario;
    }

    public void setEscenario(String escenario) {
        this.escenario = escenario;
    }

    public DificultadPista getDificultad() {
        return dificultad;
    }

    public void setDificultad(DificultadPista dificultad) {
        this.dificultad = dificultad;
    }
}
