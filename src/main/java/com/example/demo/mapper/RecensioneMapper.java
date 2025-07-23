package com.example.demo.mapper;


import com.example.demo.dto.RecensioneDTO;
import com.example.demo.model.Recensione;
import com.example.demo.model.Libro;

public class RecensioneMapper {

    public static RecensioneDTO toDTO(Recensione recensione) {
        return RecensioneDTO.builder()
                .id(recensione.getId())
                .testo(recensione.getTesto())
                .libroId(recensione.getLibro().getId())
                .build();
    }

    public static Recensione toEntity(RecensioneDTO dto, Libro libro) {
        return Recensione.builder()
                .id(dto.getId())
                .testo(dto.getTesto())
                .libro(libro)
                .build();
    }
}