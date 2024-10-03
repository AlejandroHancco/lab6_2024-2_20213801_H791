package com.example.lab6.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "eventos")
public class EventoArtista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventoId", nullable = false)
    private Integer eventoId;

    @Column(name = "nombre", length = 100)
    private String nombre;
    @Column(name = "fecha")
    private String fecha;
    @Column(name = "asistentesEsperados")
    private Integer asistentesEsperados;

}