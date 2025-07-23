package com.example.demo.mapper;

import com.example.demo.dto.AutoreDto;
import com.example.demo.model.Autore;
import org.springframework.stereotype.Component;

@Component
public class AutoreMapper {

   
    public static AutoreDto toDto(Autore autore) {
        if (autore == null) {
            return null;
        }
        return AutoreDto.builder()
                .id(autore.getId())
                .nome(autore.getNome())
                .build();
    }

    
    public static Autore toEntity(AutoreDto dto) {
        if (dto == null) {
            return null;
        }
        return Autore.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .build();
    }
}
