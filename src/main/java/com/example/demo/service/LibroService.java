package com.example.demo.service;

import com.example.demo.model.Libro;
import com.example.demo.dto.LibroDto;
import com.example.demo.mapper.LibroMapper;
import com.example.demo.model.Autore; // Assicurati di importare Autore
import com.example.demo.repository.LibroRepository;
import com.example.demo.repository.AutoreRepository; // Dovrai creare e iniettare questo
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LibroService {
    private final LibroRepository libroRepository;
    private final LibroMapper libroMapper; // Inietta il mapper
    private final AutoreRepository autoreRepository; // Per trovare l'autore

    public List<LibroDto> findAll() {
        return libroRepository.findAll().stream()
                .map(libroMapper::toDto)
                .collect(Collectors.toList());
    }

    public LibroDto findById(Long id) {
        var libro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro non trovato con id: " + id));
        return libroMapper.toDto(libro);
    }

    public LibroDto save(LibroDto libroDto) {
        var libro = libroMapper.toEntity(libroDto);

        if (libro.getAutore() != null && libro.getAutore().getId() != null) {
            var autore = autoreRepository.findById(libro.getAutore().getId())
                    .orElseThrow(() -> new RuntimeException("Autore non trovato con id: " + libro.getAutore().getId()));
            libro.setAutore(autore);
        }

        var savedLibro = libroRepository.save(libro);
        return libroMapper.toDto(savedLibro);
    }

    public LibroDto update(Long id, LibroDto libroDto) {
        var esistente = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro non trovato con id: " + id));

        // Aggiorna solo i campi necessari dall'entità esistente con i dati del DTO
        esistente.setTitolo(libroDto.getTitolo());
        esistente.setPrezzo(libroDto.getPrezzo());

        if (libroDto.getAutoreId() != null) {
            var autore = autoreRepository.findById(libroDto.getAutoreId())
                    .orElseThrow(() -> new RuntimeException("Autore non trovato con id: " + libroDto.getAutoreId()));
            esistente.setAutore(autore);
        }

        var updatedLibro = libroRepository.save(esistente);
        return libroMapper.toDto(updatedLibro);
    }

    public void delete(Long id) {
        libroRepository.deleteById(id);
    }
}