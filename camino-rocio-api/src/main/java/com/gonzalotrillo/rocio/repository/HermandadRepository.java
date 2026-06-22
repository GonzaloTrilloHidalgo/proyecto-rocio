package com.gonzalotrillo.rocio.repository;

import com.gonzalotrillo.rocio.model.CategoriaHermandad;
import com.gonzalotrillo.rocio.model.Hermandad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HermandadRepository extends JpaRepository<Hermandad, Long> {

    List<Hermandad> findByProvinciaIgnoreCase(String provincia);

    List<Hermandad> findByCategoria(CategoriaHermandad categoria);

    @Query("SELECT h FROM Hermandad h WHERE LOWER(h.nombre) LIKE LOWER(CONCAT('%', :q, '%')) " +
           "OR LOWER(h.localidad) LIKE LOWER(CONCAT('%', :q, '%'))")
    List<Hermandad> buscar(@Param("q") String q);

    @Query("SELECT DISTINCT h.provincia FROM Hermandad h WHERE h.provincia IS NOT NULL ORDER BY h.provincia")
    List<String> findProvinciasDistintas();
}
