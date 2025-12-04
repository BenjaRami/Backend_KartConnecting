package com.Kartconnecting.Backend.model;

import com.Kartconnecting.Backend.converter.EstadoBusquedaConverter;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "BUSQUEDA_JUGADORES")
public class BusquedaJugador {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "busquedas_seq")
    @SequenceGenerator(name = "busquedas_seq", sequenceName = "seq_busquedas", allocationSize = 1)
    @Column(name = "id_busqueda")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_equipo", nullable = false)
    private Equipo equipo;

    @Column(name = "descripcion")
    private String descripcion;

    @Convert(converter = EstadoBusquedaConverter.class)
    @Column(name = "estado")
    private EstadoBusqueda estado;

    @Column(name = "fecha")
    private LocalDate fecha;

    // ===== Getters & Setters =====

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Equipo getEquipo() { return equipo; }
    public void setEquipo(Equipo equipo) { this.equipo = equipo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public EstadoBusqueda getEstado() { return estado; }
    public void setEstado(EstadoBusqueda estado) { this.estado = estado; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
}
