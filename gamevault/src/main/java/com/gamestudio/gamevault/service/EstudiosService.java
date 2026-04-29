package com.gamestudio.gamevault.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamestudio.gamevault.entity.Estudios;
import com.gamestudio.gamevault.repository.EstudiosRepository;

@Service
public class EstudiosService {
    // No cal fer "new EstudiosRepository()", Spring ho fa sol.
    @Autowired
    private EstudiosRepository estudiosRepository;

    // Retorna tots els estudis de la base de dades.
    public List<Estudios> findAll() {
        return estudiosRepository.findAll();
    }

    // Busca un estudi per la seva id.
    // Retorna un Optional buit perquè pot ser que no existeixi cap estudi amb aquella id (per no retornar null).
    public Optional<Estudios> findById(Long id) {
        return estudiosRepository.findById(id);
    }

    // Si l'estudi té id → el modifica.
    // Si l'estudi no té id → el crea nou.
    public Estudios save(Estudios estudio) {
        return estudiosRepository.save(estudio);
    }

    // Elimina un estudi per la seva id.
    public void deleteById(Long id) {
        estudiosRepository.deleteById(id);
    }
}