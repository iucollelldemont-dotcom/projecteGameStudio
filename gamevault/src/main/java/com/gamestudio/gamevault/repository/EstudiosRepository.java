package com.gamestudio.gamevault.repository;

// Hereda de JpaRepository, que ya tiene métodos para operaciones básicas (findAll, findById, save, delete, etc.).
import org.springframework.data.jpa.repository.JpaRepository;

import com.gamestudio.gamevault.entity.Estudios;

//Interfaz que Spring Data JPA implementará automáticamente. No es necesario implementarla manualmente.
public interface EstudiosRepository extends JpaRepository<Estudios, Long>{
}