package com.gamestudio.gamevault.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Estudios {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String pais;
    private Integer anoFundacion;

    protected Estudios(){}

    public Estudios(String nombre, String pais, Integer anoFundacion){
        this.nombre=nombre;
        this.pais=pais;
        this.anoFundacion=anoFundacion;
    }
    
    public Long getId(){
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public Integer getAnoFundacion() {
        return anoFundacion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setAnoFundacion(Integer anoFundacion) {
        this.anoFundacion = anoFundacion;
    }
}
