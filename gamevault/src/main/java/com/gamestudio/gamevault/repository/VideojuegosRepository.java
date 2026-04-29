package com.gamestudio.gamevault.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamestudio.gamevault.entity.Videojuegos;

public interface VideojuegosRepository extends JpaRepository<Videojuegos, Long>{

    // Videojuegos con precio superior a una cantidad indicada.
    List<Videojuegos> findByPrecioGreaterThan(Double precio);

    // Videojuegos ordenados por valoración media.
    List<Videojuegos> findAllByOrderByValoracionDesc();

    // Videojuegos de un estudio concreto.
    List<Videojuegos> findByEstudioId(Long estudioId);
}