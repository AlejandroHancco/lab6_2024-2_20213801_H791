package com.example.lab6.repository;

import com.example.lab6.entity.Artista;
import com.example.lab6.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Integer> {
    @Query("SELECT ea.artista FROM EventoArtista ea WHERE ea.evento.eventoId = :eventoId")
    List<Artista> findArtistasByEventoId(@Param("eventoId") Integer eventoId);
}