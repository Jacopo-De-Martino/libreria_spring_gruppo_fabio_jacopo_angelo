package com.example.demo.controller;


import com.example.demo.model.Recensione;
import com.example.demo.service.RecensioneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recensioni")
@RequiredArgsConstructor
public class RecensioneController {

    private final RecensioneService recensioneService;

    @GetMapping
    public List<Recensione> getAllRecensioni() {
        return recensioneService.findAll();
    }

    @GetMapping("/{id}")
    public Recensione getrecensioneById(@PathVariable Long id) {
        return recensioneService.findById(id);
    }

    @PostMapping
    public Recensione createRecensione(@RequestBody Recensione recensione) {
        return recensioneService.save(recensione);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRecensione(@PathVariable Long id) {
        recensioneService.delete(id);
        return ResponseEntity.ok("Recensione eliminata");
    }
}