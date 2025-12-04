package com.Kartconnecting.Backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CARRERAS")
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carreras_seq")
    @SequenceGenerator(name = "carreras_seq", sequenceName = "seq_carreras", allocationSize = 1)
    @Column(name = "id_carrera")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_torneo", nullable = false)
    private Torneo torneo;

    @ManyToOne
    @JoinColumn(name = "id_pista", nullable = false)
    private Pista pista;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "hora")
    private String hora;

    // ===== Getters y Setters =====

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Torneo getTorneo() { return torneo; }

    public void setTorneo(Torneo torneo) { this.torneo = torneo; }

    public Pista getPista() { return pista; }

    public void setPista(Pista pista) { this.pista = pista; }

    public LocalDate getFecha() { return fecha; }

    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getHora() { return hora; }

    public void setHora(String hora) { this.hora = hora; }
}

