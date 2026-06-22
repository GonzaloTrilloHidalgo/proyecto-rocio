package com.gonzalotrillo.rocio.controller;

import com.gonzalotrillo.rocio.dto.ParadaDTO;
import com.gonzalotrillo.rocio.service.ParadaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paradas")
@Tag(name = "Paradas", description = "Hitos y paradas del camino al Rocío")
public class ParadaController {

    private final ParadaService service;

    public ParadaController(ParadaService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Paradas ordenadas por posición en el camino")
    public List<ParadaDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Detalle de una parada")
    public ResponseEntity<ParadaDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtener(id));
    }
}
