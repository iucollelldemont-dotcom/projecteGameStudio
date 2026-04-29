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
public class Resenas {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String autor;
    private String comentario;
    private Integer puntuacion;
    private LocalDate fecha;    

    protected Resenas(){}

    public Resenas(String autor, String comentario, Integer puntuacion, LocalDate fecha) {
        this.autor = autor;
        this.comentario = comentario;
        this.puntuacion = puntuacion;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public String getAutor() {
        return autor;
    }

    public String getComentario() {
        return comentario;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    //Referencia al videojuego al que pertenece la/s reseña/s - 1:N.
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "videojuego_id")
    private Videojuegos videojuego;

    public Videojuegos getVideojuego() {
        return videojuego;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setVideojuego(Videojuegos videojuego) {
        this.videojuego = videojuego;
    }
}
