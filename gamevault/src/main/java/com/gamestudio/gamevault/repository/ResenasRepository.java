package com.gamestudio.gamevault.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamestudio.gamevault.entity.Resenas;

public interface ResenasRepository extends JpaRepository<Resenas, Long>{

    // Reseñas con puntuación mínima indicada.
    List<Resenas> findByPuntuacionGreaterThanEqual(Integer puntuacion);

    // Reseñas de un videojuego concreto.
    List<Resenas> findByVideojuegoId(Long videojuegoId);
}