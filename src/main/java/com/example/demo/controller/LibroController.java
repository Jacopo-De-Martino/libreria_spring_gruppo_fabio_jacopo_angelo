package com.example.demo.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.model.*;

import lombok.RequiredArgsConstructor;
import com.example.demo.service.*;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/libro")
@RequiredArgsConstructor
public class LibroController {

    private final LibroService libroService;
    private final RecensioneService recensioneService;

    @GetMapping
    public List<Libro> getAllLibro() {
        return libroService.findAll();
    }

    @GetMapping("/{id}")
    public Libro getLibroById(@PathVariable Long id) {
        return libroService.findById(id);
    }

    @PostMapping
    public Libro createLibro(@Valid @RequestBody Libro libro) {
        return libroService.save(libro);
    }

    @PutMapping("/{id}")
    public Libro updateTodo(@PathVariable Long id, @Valid @RequestBody Libro modificato) {
        Libro esistente = libroService.findById(id);
        esistente.setTitolo(modificato.getTitolo());
        esistente.setAutore(modificato.getAutore());
        esistente.setPrezzo(modificato.getPrezzo());
        return libroService.save(esistente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable Long id) {
        libroService.delete(id);
        return ResponseEntity.ok("Libro eliminato");
    }

    // ENDPOINT SPECIFICO: tutti i commenti legati a un ToDo
    @GetMapping("/{id}/recensione")
    public List<Recensione> getRecensioniByRecensiones(@PathVariable Long id) {
        return recensioneService.findByLibroId(id);
    }
}
