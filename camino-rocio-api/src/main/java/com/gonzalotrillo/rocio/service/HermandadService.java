package com.gonzalotrillo.rocio.service;

import com.gonzalotrillo.rocio.dto.HermandadDTO;
import com.gonzalotrillo.rocio.exception.ResourceNotFoundException;
import com.gonzalotrillo.rocio.mapper.HermandadMapper;
import com.gonzalotrillo.rocio.model.CategoriaHermandad;
import com.gonzalotrillo.rocio.repository.HermandadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HermandadService {

    private final HermandadRepository repo;
    private final HermandadMapper mapper;

    public HermandadService(HermandadRepository repo, HermandadMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public List<HermandadDTO> listar(String provincia, String categoria, String q) {
        if (q != null && !q.isBlank()) {
            return repo.buscar(q.trim()).stream().map(mapper::toDTO).toList();
        }
        if (provincia != null && !provincia.isBlank()) {
            return repo.findByProvinciaIgnoreCase(provincia.trim()).stream().map(mapper::toDTO).toList();
        }
        if (categoria != null && !categoria.isBlank()) {
            CategoriaHermandad cat = CategoriaHermandad.valueOf(categoria.toUpperCase());
            return repo.findByCategoria(cat).stream().map(mapper::toDTO).toList();
        }
        return repo.findAll().stream().map(mapper::toDTO).toList();
    }

    public HermandadDTO obtener(Long id) {
        return repo.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Hermandad no encontrada: " + id));
    }

    public List<String> provincias() {
        return repo.findProvinciasDistintas();
    }
}
