package com.gonzalotrillo.rocio.controller;

import com.gonzalotrillo.rocio.dto.HermandadDTO;
import com.gonzalotrillo.rocio.service.HermandadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Hermandades", description = "Directorio de hermandades filiales del Rocío")
public class HermandadController {

    private final HermandadService service;

    public HermandadController(HermandadService service) {
        this.service = service;
    }

    @GetMapping("/hermandades")
    @Operation(summary = "Listado de hermandades con filtros opcionales")
    public List<HermandadDTO> listar(
            @RequestParam(required = false) String provincia,
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) String q) {
        return service.listar(provincia, categoria, q);
    }

    @GetMapping("/hermandades/{id}")
    @Operation(summary = "Ficha de una hermandad por ID")
    public ResponseEntity<HermandadDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtener(id));
    }

    @GetMapping("/provincias")
    @Operation(summary = "Listado de provincias para filtros")
    public List<String> provincias() {
        return service.provincias();
    }
}
