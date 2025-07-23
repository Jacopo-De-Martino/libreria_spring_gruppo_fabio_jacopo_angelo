package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.LibroDto;
import com.example.demo.model.Autore;
import com.example.demo.model.Libro;

@Component
public class LibroMapper {

    public LibroDto toDto(Libro libro) {
        if (libro == null) {
            return null;
        }
        return LibroDto.builder()
                .id(libro.getId())
                .titolo(libro.getTitolo())
                .prezzo(libro.getPrezzo())
                .autoreId(libro.getAutore() != null ? libro.getAutore().getId() : null)
                .build();
    }

    public Libro toEntity(LibroDto libroDto) {
        if (libroDto == null) {
            return null;
        }

        Autore autore = null;
        if (libroDto.getAutoreId() != null) {
            autore = new Autore();
            autore.setId(libroDto.getAutoreId());
        }

        return Libro.builder()
                .id(libroDto.getId())
                .titolo(libroDto.getTitolo())
                .prezzo(libroDto.getPrezzo())
                .autore(autore)
                .build();
    }
}