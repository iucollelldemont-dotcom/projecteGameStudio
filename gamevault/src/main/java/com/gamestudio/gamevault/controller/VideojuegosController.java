package com.gamestudio.gamevault.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gamestudio.gamevault.entity.Videojuegos;
import com.gamestudio.gamevault.service.EstudiosService;
import com.gamestudio.gamevault.service.VideojuegosService;

@RestController

@RequestMapping("/videojuegos")
public class VideojuegosController{
    @Autowired
    private VideojuegosService videojuegosService;
    
    @Autowired
    private EstudiosService estudiosService;
    
    @GetMapping
    public List<Videojuegos>findAll(){
        return videojuegosService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Videojuegos> findById(@PathVariable Long id) {
        return videojuegosService.findById(id);
    }

    

@PostMapping
public Videojuegos save(@RequestBody Videojuegos videojuego) {
    // Si ve un estudi amb id, anem a buscar l'estudi complet a la BD.
    if (videojuego.getEstudio() != null && videojuego.getEstudio().getId() != null) {
        estudiosService.findById(videojuego.getEstudio().getId()).ifPresent(videojuego::setEstudio);
    }
    return videojuegosService.save(videojuego);
}

    @PutMapping("/{id}")
    public Videojuegos update(@PathVariable Long id, @RequestBody Videojuegos videojuego) {
        videojuego.setId(id);
        return videojuegosService.save(videojuego);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        videojuegosService.deleteById(id);
    }


    //Consultas obligatorias.
    @GetMapping("/precio")
    public List<Videojuegos> findByPrecio(@RequestParam Double min) {
        return videojuegosService.findByPrecioGreaterThan(min);
    }

    @GetMapping("/ordenados")
    public List<Videojuegos> findAllOrdenados() {
        return videojuegosService.findAllByOrderByValoracionDesc();
    }

    @GetMapping("/estudio/{estudioId}")
    public List<Videojuegos> findByEstudio(@PathVariable Long estudioId) {
        return videojuegosService.findByEstudioId(estudioId);
    }

    //Transacción: eliminar un videojojuego junto con sus reseñas de forma controlada.
    @DeleteMapping("/{id}/completo")
    public void deleteVideojuegoConResenas(@PathVariable Long id) {
        videojuegosService.deleteVideojuegoConResenas(id);
    }
}