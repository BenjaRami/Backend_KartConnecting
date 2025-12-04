package com.Kartconnecting.Backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "MIEMBROS_EQUIPO")
public class MiembroEquipo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "miembros_seq")
    @SequenceGenerator(name = "miembros_seq", sequenceName = "seq_miembros", allocationSize = 1)
    @Column(name = "id_miembro")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_jugador", nullable = false)
    private Jugador jugador;

    @ManyToOne
    @JoinColumn(name = "id_equipo", nullable = false)
    private Equipo equipo;

    @Column(name = "fecha_ingreso")
    private LocalDate fechaIngreso;

    // ===== Getters y Setters =====

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Jugador getJugador() { return jugador; }
    public void setJugador(Jugador jugador) { this.jugador = jugador; }

    public Equipo getEquipo() { return equipo; }
    public void setEquipo(Equipo equipo) { this.equipo = equipo; }

    public LocalDate getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(LocalDate fechaIngreso) { this.fechaIngreso = fechaIngreso; }
}
