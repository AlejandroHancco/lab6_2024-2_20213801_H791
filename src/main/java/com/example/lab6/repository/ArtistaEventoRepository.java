package com.example.lab6.repository;

import com.example.lab6.entity.Artista;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistaEventoRepository extends JpaRepository<Artista, Integer> {
    @Modifying // Indica que es una operación de modificación (INSERT, UPDATE, DELETE)
    @Transactional // Se requiere para métodos de modificación
    @Query("DELETE FROM EventoArtista ea WHERE ea.artista.artistaId = :artistaId AND ea.evento.eventoId = :eventoId")
    void deleteByArtistaIdAndEventoId(@Param("artistaId") Integer artistaId, @Param("eventoId") Integer eventoId);
}