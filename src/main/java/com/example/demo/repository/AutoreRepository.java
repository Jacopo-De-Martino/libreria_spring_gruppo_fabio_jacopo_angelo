package com.example.demo.repository;

import com.example.demo.model.Autore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoreRepository extends CrudRepository<Autore, Long> {
// Tutti i metodi CRUD già pronti!
}
