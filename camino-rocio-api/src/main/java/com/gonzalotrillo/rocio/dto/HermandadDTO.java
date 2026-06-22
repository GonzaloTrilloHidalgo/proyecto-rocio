package com.gonzalotrillo.rocio.dto;

import com.gonzalotrillo.rocio.model.CategoriaHermandad;

public class HermandadDTO {

    private Long id;
    private String nombre;
    private Integer numeroOrden;
    private String provincia;
    private String localidad;
    private String madrina;
    private Integer anioFundacion;
    private CategoriaHermandad categoria;
    private Double latitud;
    private Double longitud;
    private String web;

    public HermandadDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Integer getNumeroOrden() { return numeroOrden; }
    public void setNumeroOrden(Integer numeroOrden) { this.numeroOrden = numeroOrden; }

    public String getProvincia() { return provincia; }
    public void setProvincia(String provincia) { this.provincia = provincia; }

    public String getLocalidad() { return localidad; }
    public void setLocalidad(String localidad) { this.localidad = localidad; }

    public String getMadrina() { return madrina; }
    public void setMadrina(String madrina) { this.madrina = madrina; }

    public Integer getAnioFundacion() { return anioFundacion; }
    public void setAnioFundacion(Integer anioFundacion) { this.anioFundacion = anioFundacion; }

    public CategoriaHermandad getCategoria() { return categoria; }
    public void setCategoria(CategoriaHermandad categoria) { this.categoria = categoria; }

    public Double getLatitud() { return latitud; }
    public void setLatitud(Double latitud) { this.latitud = latitud; }

    public Double getLongitud() { return longitud; }
    public void setLongitud(Double longitud) { this.longitud = longitud; }

    public String getWeb() { return web; }
    public void setWeb(String web) { this.web = web; }
}
