package com.example.demo.controller;

import com.example.demo.dto.AutoreDto;
import com.example.demo.service.AutoreService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autori")
public class AutoreController {

    private final AutoreService service;

    public AutoreController(AutoreService service) {
        this.service = service;
    }

    @GetMapping
    public List<AutoreDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutoreDto> getById(@PathVariable Long id) {
        return service.getById(id)
                      .map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AutoreDto create(@Valid @RequestBody AutoreDto dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutoreDto> update(
            @PathVariable Long id,
            @Valid @RequestBody AutoreDto dto) {

        return service.update(id, dto)
                      .map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = service.delete(id);
        return deleted
            ? ResponseEntity.noContent().build()
            : ResponseEntity.notFound().build();
    }
}
