package com.gonzalotrillo.rocio.mapper;

import com.gonzalotrillo.rocio.dto.ParadaDTO;
import com.gonzalotrillo.rocio.model.Parada;
import org.springframework.stereotype.Component;

@Component
public class ParadaMapper {

    public ParadaDTO toDTO(Parada p) {
        ParadaDTO dto = new ParadaDTO();
        dto.setId(p.getId());
        dto.setNombre(p.getNombre());
        dto.setDescripcion(p.getDescripcion());
        dto.setLatitud(p.getLatitud());
        dto.setLongitud(p.getLongitud());
        dto.setOrdenEnCamino(p.getOrdenEnCamino());
        dto.setTipo(p.getTipo());
        return dto;
    }

    public Parada toEntity(ParadaDTO dto) {
        Parada p = new Parada();
        p.setNombre(dto.getNombre());
        p.setDescripcion(dto.getDescripcion());
        p.setLatitud(dto.getLatitud());
        p.setLongitud(dto.getLongitud());
        p.setOrdenEnCamino(dto.getOrdenEnCamino());
        p.setTipo(dto.getTipo());
        return p;
    }
}
