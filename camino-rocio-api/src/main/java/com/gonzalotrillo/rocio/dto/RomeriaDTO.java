package com.gonzalotrillo.rocio.dto;

import java.time.LocalDate;

public class RomeriaDTO {

    private int anio;
    private LocalDate domingoPentecostes;
    private LocalDate lunesPentecostes;
    private long diasRestantes;

    public RomeriaDTO() {}

    public RomeriaDTO(int anio, LocalDate domingoPentecostes, LocalDate lunesPentecostes, long diasRestantes) {
        this.anio = anio;
        this.domingoPentecostes = domingoPentecostes;
        this.lunesPentecostes = lunesPentecostes;
        this.diasRestantes = diasRestantes;
    }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public LocalDate getDomingoPentecostes() { return domingoPentecostes; }
    public void setDomingoPentecostes(LocalDate domingoPentecostes) { this.domingoPentecostes = domingoPentecostes; }

    public LocalDate getLunesPentecostes() { return lunesPentecostes; }
    public void setLunesPentecostes(LocalDate lunesPentecostes) { this.lunesPentecostes = lunesPentecostes; }

    public long getDiasRestantes() { return diasRestantes; }
    public void setDiasRestantes(long diasRestantes) { this.diasRestantes = diasRestantes; }
}
