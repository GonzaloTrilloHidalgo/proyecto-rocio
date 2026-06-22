package com.gonzalotrillo.rocio.service;

import com.gonzalotrillo.rocio.dto.ParadaDTO;
import com.gonzalotrillo.rocio.exception.ResourceNotFoundException;
import com.gonzalotrillo.rocio.mapper.ParadaMapper;
import com.gonzalotrillo.rocio.repository.ParadaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParadaService {

    private final ParadaRepository repo;
    private final ParadaMapper mapper;

    public ParadaService(ParadaRepository repo, ParadaMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public List<ParadaDTO> listar() {
        return repo.findAllByOrderByOrdenEnCaminoAsc().stream().map(mapper::toDTO).toList();
    }

    public ParadaDTO obtener(Long id) {
        return repo.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Parada no encontrada: " + id));
    }
}
