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
import org.springframework.web.bind.annotation.RestController;

import com.gamestudio.gamevault.entity.Estudios;
import com.gamestudio.gamevault.service.EstudiosService;

@RestController
@RequestMapping("/estudios")
public class EstudiosController {

    @Autowired
    private EstudiosService estudiosService;

    // GET /estudios → devuelve todos los estudios.
    @GetMapping
    public List<Estudios> findAll() {
        return estudiosService.findAll();
    }

    // GET /estudios/1 → devuelve el estudio con id=1.
    @GetMapping("/{id}")
    public Optional<Estudios> findById(@PathVariable Long id) {
        return estudiosService.findById(id);
    }

    // POST /estudios → crea un estudio nuevo.
    @PostMapping
    public Estudios save(@RequestBody Estudios estudio) {
        return estudiosService.save(estudio);
    }

    // PUT /estudios/1 → modifica el estudio con id=1.
    @PutMapping("/{id}")
    public Estudios update(@PathVariable Long id, @RequestBody Estudios estudio) {
        estudio.setId(id);
        return estudiosService.save(estudio);
    }

    // DELETE /estudios/1 → elimina el estudio con id=1.
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        estudiosService.deleteById(id);
    }
}