package com.gamestudio.gamevault.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamestudio.gamevault.entity.Resenas;
import com.gamestudio.gamevault.repository.ResenasRepository;

@Service
public class ResenasService {
    @Autowired
    private ResenasRepository resenasRepository;

    public List<Resenas> findAll() {
        return resenasRepository.findAll();
    }

    public Optional<Resenas> findById(Long id) {
        return resenasRepository.findById(id);
    }

    public Resenas save(Resenas resena) {
        return resenasRepository.save(resena);
    }

    public void deleteById(Long id) {
        resenasRepository.deleteById(id);
    }

    // Consultes obligatòries
    public List<Resenas> findByPuntuacionGreaterThanEqual(Integer puntuacion) {
        return resenasRepository.findByPuntuacionGreaterThanEqual(puntuacion);
    }

    public List<Resenas> findByVideojuegoId(Long videojuegoId) {
        return resenasRepository.findByVideojuegoId(videojuegoId);
    }
}