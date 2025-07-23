package com.example.demo.controller;


import com.example.demo.dto.RecensioneDTO;
import com.example.demo.service.RecensioneService;

import jakarta.validation.Valid;
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
    public List<RecensioneDTO> getAllRecensioni() {
        return recensioneService.getAll();
    }

    @GetMapping("/{id}")
    public RecensioneDTO getrecensioneById(@PathVariable Long id) {
        return recensioneService.findById(id);
    }

    @PostMapping
    public RecensioneDTO createRecensione(@Valid @RequestBody RecensioneDTO recensione) {
        return recensioneService.save(recensione);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRecensione(@PathVariable Long id) {
        recensioneService.delete(id);
        return ResponseEntity.ok("Recensione eliminata");
    }
}