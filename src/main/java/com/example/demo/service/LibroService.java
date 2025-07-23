package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Libro;
import com.example.demo.repository.LibroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LibroService {
    private final LibroRepository libroRepository;

    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    public Libro findById(Long id) {
        return libroRepository.findById(id).orElseThrow(() -> new RuntimeException("Libro non trovato"));
    }

    public Libro save(Libro Libro) {
        return libroRepository.save(Libro);
    }

    public void delete(Long id) {
        libroRepository.deleteById(id);
    }

}
