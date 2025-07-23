package com.example.demo.repository;


import com.example.demo.model.Recensione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecensioneRepository extends JpaRepository<Recensione, Long> {
List<Recensione> findByLibroId(Long libroId);
}