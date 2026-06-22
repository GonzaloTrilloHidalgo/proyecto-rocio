package com.gonzalotrillo.rocio;

import com.gonzalotrillo.rocio.dto.RomeriaDTO;
import com.gonzalotrillo.rocio.service.RomeriaService;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RomeriaServiceTest {

    private final RomeriaService service = new RomeriaService();

    @Test
    void pascua2025EsEl20DeAbril() {
        LocalDate pascua = service.calcularPascua(2025);
        assertEquals(LocalDate.of(2025, 4, 20), pascua);
    }

    @Test
    void proximaRomeriaDevuelveDomingoDePentecostes() {
        RomeriaDTO dto = service.proximaRomeria();
        assertEquals(DayOfWeek.SUNDAY, dto.getDomingoPentecostes().getDayOfWeek());
        assertEquals(dto.getDomingoPentecostes().plusDays(1), dto.getLunesPentecostes());
    }

    @Test
    void diasRestantesSonPositivos() {
        RomeriaDTO dto = service.proximaRomeria();
        assertTrue(dto.getDiasRestantes() > 0);
    }
}
