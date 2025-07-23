package com.example.demo.repository;


import com.example.demo.model.Recensione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecensioneRepository extends JpaRepository<Recensione, Long> {
List<Recensione> findByRecensioneId(Long todoId);
}