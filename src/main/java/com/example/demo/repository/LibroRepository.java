package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

}
