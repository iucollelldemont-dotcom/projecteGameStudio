package com.gamestudio.gamevault.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Videojuegos {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String genero;
    private Double precio;
    private LocalDate fecha;
    private Double valoracion;
    

    protected Videojuegos(){}

    public Videojuegos(String titulo, String genero, Double precio, LocalDate fecha, Double valoracion) {
        this.titulo = titulo;
        this.genero = genero;
        this.precio = precio;
        this.fecha = fecha;
        this.valoracion = valoracion;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public Double getPrecio() {
        return precio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Double getValoracion() {
        return valoracion;
    }

    //Referencia al estudio que ha desarrollado el videojuego - 1:N.
    @ManyToOne(fetch = FetchType.EAGER) //Carga también los datos de estudio.
    @JoinColumn(name = "estudio_id")
    private Estudios estudio;

    public Estudios getEstudio() {
        return estudio;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setValoracion(Double valoracion) {
        this.valoracion = valoracion;
    }

    public void setEstudio(Estudios estudio) {
        this.estudio = estudio;
    }

    

}
