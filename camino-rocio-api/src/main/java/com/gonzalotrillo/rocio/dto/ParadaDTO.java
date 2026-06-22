package com.gonzalotrillo.rocio.dto;

import com.gonzalotrillo.rocio.model.TipoParada;

public class ParadaDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private Double latitud;
    private Double longitud;
    private Integer ordenEnCamino;
    private TipoParada tipo;

    public ParadaDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Double getLatitud() { return latitud; }
    public void setLatitud(Double latitud) { this.latitud = latitud; }

    public Double getLongitud() { return longitud; }
    public void setLongitud(Double longitud) { this.longitud = longitud; }

    public Integer getOrdenEnCamino() { return ordenEnCamino; }
    public void setOrdenEnCamino(Integer ordenEnCamino) { this.ordenEnCamino = ordenEnCamino; }

    public TipoParada getTipo() { return tipo; }
    public void setTipo(TipoParada tipo) { this.tipo = tipo; }
}
