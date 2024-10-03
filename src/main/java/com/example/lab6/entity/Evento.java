package com.example.lab6.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "eventos")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventoId", nullable = false)
    private Integer eventoId;

    @Column(name = "nombre", length = 100)
    @Size(max=100, message = "El nombre no puede tener más de 9 caracteres")
    private String nombre;
    @Column(name = "fecha")
    private String fecha;
    @Column(name = "asistentesEsperados")
    @Positive
    private Integer asistentesEsperados;

    public Integer getEventoId() {
        return eventoId;
    }

    public void setEventoId(Integer eventoId) {
        this.eventoId = eventoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getAsistentesEsperados() {
        return asistentesEsperados;
    }

    public void setAsistentesEsperados(Integer asistentesEsperados) {
        this.asistentesEsperados = asistentesEsperados;
    }
}