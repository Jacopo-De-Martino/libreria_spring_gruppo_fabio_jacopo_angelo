package com.example.demo.repository;

import com.example.demo.model.Autore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoreRepository extends JpaRepository<Autore, Long> {
    // Ora erediti:
    // List<Autore> findAll();
    // Optional<Autore> findById(Long id);
    // Autore save(Autore entity);
    // boolean existsById(Long id);
    // void deleteById(Long id);
}
