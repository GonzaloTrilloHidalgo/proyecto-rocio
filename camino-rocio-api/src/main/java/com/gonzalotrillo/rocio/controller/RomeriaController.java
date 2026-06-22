package com.gonzalotrillo.rocio.controller;

import com.gonzalotrillo.rocio.dto.RomeriaDTO;
import com.gonzalotrillo.rocio.service.RomeriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/romeria")
@Tag(name = "Romería", description = "Fechas y cuenta atrás de la próxima romería")
public class RomeriaController {

    private final RomeriaService service;

    public RomeriaController(RomeriaService service) {
        this.service = service;
    }

    @GetMapping("/proxima")
    @Operation(summary = "Fechas de la próxima romería y días restantes")
    public RomeriaDTO proxima() {
        return service.proximaRomeria();
    }
}
