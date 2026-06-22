package com.gonzalotrillo.rocio.mapper;

import com.gonzalotrillo.rocio.dto.HermandadDTO;
import com.gonzalotrillo.rocio.model.Hermandad;
import org.springframework.stereotype.Component;

@Component
public class HermandadMapper {

    public HermandadDTO toDTO(Hermandad h) {
        HermandadDTO dto = new HermandadDTO();
        dto.setId(h.getId());
        dto.setNombre(h.getNombre());
        dto.setNumeroOrden(h.getNumeroOrden());
        dto.setProvincia(h.getProvincia());
        dto.setLocalidad(h.getLocalidad());
        dto.setMadrina(h.getMadrina());
        dto.setAnioFundacion(h.getAnioFundacion());
        dto.setCategoria(h.getCategoria());
        dto.setLatitud(h.getLatitud());
        dto.setLongitud(h.getLongitud());
        dto.setWeb(h.getWeb());
        return dto;
    }

    public Hermandad toEntity(HermandadDTO dto) {
        Hermandad h = new Hermandad();
        h.setNombre(dto.getNombre());
        h.setNumeroOrden(dto.getNumeroOrden());
        h.setProvincia(dto.getProvincia());
        h.setLocalidad(dto.getLocalidad());
        h.setMadrina(dto.getMadrina());
        h.setAnioFundacion(dto.getAnioFundacion());
        h.setCategoria(dto.getCategoria());
        h.setLatitud(dto.getLatitud());
        h.setLongitud(dto.getLongitud());
        h.setWeb(dto.getWeb());
        return h;
    }
}
