package com.gamestudio.gamevault.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamestudio.gamevault.entity.Resenas;
import com.gamestudio.gamevault.entity.Videojuegos;
import com.gamestudio.gamevault.repository.ResenasRepository;
import com.gamestudio.gamevault.repository.VideojuegosRepository;


@Service
public class VideojuegosService {
    @Autowired
    private VideojuegosRepository videojuegosRepository;

    @Autowired
    private ResenasRepository resenasRepository;

    public List<Videojuegos> findAll() {
        return videojuegosRepository.findAll();
    }
    
    public Optional<Videojuegos> findById(Long id) {
        return videojuegosRepository.findById(id);
    }

    public Videojuegos save(Videojuegos videojuego) {
        return videojuegosRepository.save(videojuego);
    }

    public void deleteById(Long id) {
        videojuegosRepository.deleteById(id);
    }

    //Consultas obligatorias.
    public List<Videojuegos> findByPrecioGreaterThan(Double precio) {
        return videojuegosRepository.findByPrecioGreaterThan(precio);
    }

    public List<Videojuegos> findAllByOrderByValoracionDesc() {
        return videojuegosRepository.findAllByOrderByValoracionDesc();
    }

    public List<Videojuegos> findByEstudioId(Long estudioId) {
        return videojuegosRepository.findByEstudioId(estudioId);
    }

    // Transacción: eliminar un videojojuego junto con sus reseñas de forma controlada.
    @Transactional
        public void deleteVideojuegoConResenas(Long id) {
        //Buscar todas las reseñas del videojuego.
        List<Resenas> resenas = resenasRepository.findByVideojuegoId(id);
        
        //Eliminar cada reseña.
        for (Resenas resena : resenas) {
            resenasRepository.deleteById(resena.getId());
        }
        
        //Eliminar el videojuego.
        videojuegosRepository.deleteById(id);
    }
}