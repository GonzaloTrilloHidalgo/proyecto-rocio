package com.gonzalotrillo.rocio.repository;

import com.gonzalotrillo.rocio.model.Parada;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParadaRepository extends JpaRepository<Parada, Long> {

    List<Parada> findAllByOrderByOrdenEnCaminoAsc();
}
