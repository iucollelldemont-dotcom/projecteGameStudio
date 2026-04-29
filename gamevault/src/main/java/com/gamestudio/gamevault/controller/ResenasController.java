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

import com.gamestudio.gamevault.entity.Resenas;
import com.gamestudio.gamevault.service.ResenasService;
import com.gamestudio.gamevault.service.VideojuegosService;

@RestController
@RequestMapping("/resenas")
public class ResenasController{

    @Autowired
    private ResenasService resenasService;

    @Autowired
    private VideojuegosService videojuegosService;

    @GetMapping
    public List<Resenas> findAll(){
        return resenasService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Resenas> findById(@PathVariable Long id) {
        return resenasService.findById(id);
    }

    @PostMapping
    public Resenas save(@RequestBody Resenas resena) {
        // Si ve un videojoc amb id, anem a buscar el videojoc complet a la BD.
        if (resena.getVideojuego() != null && resena.getVideojuego().getId() != null) {
            videojuegosService.findById(resena.getVideojuego().getId()).ifPresent(resena::setVideojuego);
        }
        return resenasService.save(resena);
    }

    @PutMapping("/{id}")
    public Resenas update(@PathVariable Long id, @RequestBody Resenas resena) {
        resena.setId(id);
        return resenasService.save(resena);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        resenasService.deleteById(id);
    }


    //Consultas obligatorias.
    @GetMapping("/puntuacion")
    public List<Resenas> findByPuntuacion(@RequestParam Integer min) {
        return resenasService.findByPuntuacionGreaterThanEqual(min);
    }

    @GetMapping("/videojuego/{videojuegoId}")
    public List<Resenas> findByVideojuego(@PathVariable Long videojuegoId) {
        return resenasService.findByVideojuegoId(videojuegoId);
    }
}