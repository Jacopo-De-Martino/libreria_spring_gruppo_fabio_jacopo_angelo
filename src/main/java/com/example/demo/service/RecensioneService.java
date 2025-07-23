package com.example.demo.service;


import com.example.demo.dto.RecensioneDTO;
import com.example.demo.mapper.RecensioneMapper;
import com.example.demo.model.Libro;
import com.example.demo.model.Recensione;
import com.example.demo.repository.LibroRepository;
import com.example.demo.repository.RecensioneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecensioneService {

private final RecensioneRepository recensioneRepository;
private final LibroRepository libroRepository;

public List<RecensioneDTO> getAll() {
return recensioneRepository.findAll().stream()
            .map(RecensioneMapper::toDTO)
            .collect(Collectors.toList());                        
}

public List<RecensioneDTO> findByLibroId(Long libroId) {
    return recensioneRepository.findByLibroId(libroId).stream()
            .map(RecensioneMapper::toDTO)
            .collect(Collectors.toList());
}


public RecensioneDTO findById(Long id) {
    Recensione recensione = recensioneRepository.findById(id).orElseThrow();
    return RecensioneMapper.toDTO(recensione);
        
}


public RecensioneDTO save(RecensioneDTO recensionedto) {
    Libro libro = libroRepository.findById(recensionedto.getLibroId()).orElseThrow(() -> new RuntimeException("Libro non trovato"));
    Recensione recensione = RecensioneMapper.toEntity(recensionedto, libro);
    Recensione saved = recensioneRepository.save(recensione);   
    return RecensioneMapper.toDTO(saved);
}

public void delete(Long id) {
    recensioneRepository.deleteById(id);
}
}