package com.Kartconnecting.Backend.model;

import com.Kartconnecting.Backend.converter.BooleanSiNoConverter;
import com.Kartconnecting.Backend.converter.NivelCompetitivoConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "JUGADORES")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jugadores_seq")
    @SequenceGenerator(name = "jugadores_seq", sequenceName = "seq_jugadores", allocationSize = 1)
    @Column(name = "id_jugador")
    private Integer id;

    @NotBlank
    @Column(name = "nombre_gamer")
    private String nombreGamer;

    @Email
    @Column(name = "correo")
    private String correo;

    @NotBlank
    @Column(name = "pais")
    private String pais;

    @Convert(converter = NivelCompetitivoConverter.class)
    @Column(name = "nivel_competitivo")
    private NivelCompetitivo nivelCompetitivo;

    @Column(name = "bio")
    private String bio;

    @Convert(converter = BooleanSiNoConverter.class)
    @Column(name = "disponible_para_equipos")
    private Boolean disponible;

    @Column(name = "password")
    private String password;


    // ========================
    //  Getters y Setters
    // ========================

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreGamer() {
        return nombreGamer;
    }

    public void setNombreGamer(String nombreGamer) {
        this.nombreGamer = nombreGamer;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public NivelCompetitivo getNivelCompetitivo() {
        return nivelCompetitivo;
    }

    public void setNivelCompetitivo(NivelCompetitivo nivelCompetitivo) {
        this.nivelCompetitivo = nivelCompetitivo;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

