package com.example.lab6.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "artistas")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artistaId", nullable = false)
    private Integer artistaId;

    @Column(name = "nombre", length = 100)
    @Size(max=100, message = "El nombre no puede tener más de 100 caracteres")
    private String nombre;
    @Column(name = "genero", length = 50)
    @Size(max=50, message = "El genero no puede tener más de 50 caracteres")
    private String genero;
    @Column(name = "telefono", length = 9)
    @Size(max=9, message = "El teléfono no puede tener más de 9 caracteres")
    private String telefono;

    public Integer getArtistaId() {
        return artistaId;
    }

    public void setArtistaId(Integer artistaId) {
        this.artistaId = artistaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}