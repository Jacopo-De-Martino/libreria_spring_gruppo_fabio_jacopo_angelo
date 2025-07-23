package com.example.demo.service;

import com.example.demo.dto.AutoreDto;
import com.example.demo.mapper.AutoreMapper;
import com.example.demo.model.Autore;
import com.example.demo.repository.AutoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutoreService {

    private final AutoreRepository repo;
    private final AutoreMapper mapper;

    public AutoreService(AutoreRepository repo, AutoreMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    /**
     * Restituisce tutti gli autori come DTO.
     */
    public List<AutoreDto> getAll() {
        // findAll() qui ritorna List<Autore> grazie a JpaRepository
        return repo.findAll().stream()
                   .map(mapper::toDto)
                   .collect(Collectors.toList());
    }

    /**
     * Cerca un autore per ID e lo restituisce come DTO, se presente.
     */
    public Optional<AutoreDto> getById(Long id) {
        return repo.findById(id)
                   .map(mapper::toDto);
    }

    /**
     * Crea un nuovo autore da DTO e restituisce il DTO dell'entità salvata.
     */
    public AutoreDto create(AutoreDto dto) {
        Autore entity = mapper.toEntity(dto);
        Autore saved = repo.save(entity);
        return mapper.toDto(saved);
    }

    /**
     * Aggiorna il nome di un autore esistente e restituisce il DTO aggiornato.
     */
    public Optional<AutoreDto> update(Long id, AutoreDto dto) {
        return repo.findById(id)
                   .map(existing -> {
                       existing.setNome(dto.getNome());
                       Autore updated = repo.save(existing);
                       return mapper.toDto(updated);
                   });
    }

    /**
     * Elimina l'autore con l'ID specificato.
     * @return true se l'autore esisteva ed è stato eliminato, false altrimenti.
     */
    public boolean delete(Long id) {
        if (!repo.existsById(id)) {
            return false;
        }
        repo.deleteById(id);
        return true;
    }
}
