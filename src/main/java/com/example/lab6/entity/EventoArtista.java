package com.example.lab6.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "eventos_artistas")
public class EventoArtista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // ID único para la tabla de unión (opcional)

    @ManyToOne
    @JoinColumn(name = "artistaId", nullable = false)
    private Artista artista; // Relación con la entidad Artista

    @ManyToOne
    @JoinColumn(name = "eventoId", nullable = false)
    private Evento evento; // Relación con la entidad Evento

    // Constructor vacío (requerido por JPA)
    public EventoArtista() {}

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
