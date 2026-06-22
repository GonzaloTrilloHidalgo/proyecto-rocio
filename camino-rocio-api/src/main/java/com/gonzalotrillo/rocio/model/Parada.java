package com.gonzalotrillo.rocio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "parada")
public class Parada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(length = 2000)
    private String descripcion;

    @Column(nullable = false)
    private Double latitud;

    @Column(nullable = false)
    private Double longitud;

    private Integer ordenEnCamino;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoParada tipo;

    public Parada() {}

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
