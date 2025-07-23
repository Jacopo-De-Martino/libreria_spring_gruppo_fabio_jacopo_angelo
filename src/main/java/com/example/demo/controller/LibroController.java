package com.example.demo.controller;

import com.example.demo.dto.LibroDto;
import com.example.demo.mapper.LibroMapper;
import com.example.demo.model.Recensione;
import com.example.demo.service.LibroService;
import com.example.demo.service.RecensioneService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libro")
@RequiredArgsConstructor
public class LibroController {

    private final LibroService libroService;
    private final RecensioneService recensioneService;

    @GetMapping
    public List<LibroDto> getAllLibri() {
        return libroService.findAll();
    }

    @GetMapping("/{id}")
    public LibroDto getLibroById(@PathVariable Long id) {
        return libroService.findById(id);
    }

    @PostMapping
    public LibroDto createLibro(@Valid @RequestBody LibroDto libroDto) {
        return libroService.save(libroDto);
    }

    @PutMapping("/{id}")
    public LibroDto updateLibro(@PathVariable Long id, @Valid @RequestBody LibroDto libroDto) {
        return libroService.update(id, libroDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLibro(@PathVariable Long id) {
        libroService.delete(id);
        return ResponseEntity.ok("Libro eliminato");
    }

    @GetMapping("/{id}/recensioni")
    public List<Recensione> getRecensioniByLibro(@PathVariable Long id) {
        return recensioneService.findByLibroId(id);
    }
}