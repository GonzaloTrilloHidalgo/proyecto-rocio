package com.gonzalotrillo.rocio.service;

import com.gonzalotrillo.rocio.dto.RomeriaDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class RomeriaService {

    /**
     * Algoritmo de Meeus/Jones/Butcher para calcular la Pascua gregoriana.
     */
    public LocalDate calcularPascua(int anio) {
        int a = anio % 19;
        int b = anio / 100;
        int c = anio % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (b - f + 1) / 3;
        int h = (19 * a + b - d - g + 15) % 30;
        int i = c / 4;
        int k = c % 4;
        int l = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * h + 22 * l) / 451;
        int mes = (h + l - 7 * m + 114) / 31;
        int dia = ((h + l - 7 * m + 114) % 31) + 1;
        return LocalDate.of(anio, mes, dia);
    }

    public RomeriaDTO proximaRomeria() {
        LocalDate hoy = LocalDate.now();
        int anio = hoy.getYear();

        LocalDate pentecostes = calcularPascua(anio).plusDays(49);
        if (!pentecostes.isAfter(hoy)) {
            anio++;
            pentecostes = calcularPascua(anio).plusDays(49);
        }

        LocalDate lunesPentecostes = pentecostes.plusDays(1);
        long diasRestantes = ChronoUnit.DAYS.between(hoy, pentecostes);

        return new RomeriaDTO(anio, pentecostes, lunesPentecostes, diasRestantes);
    }
}
