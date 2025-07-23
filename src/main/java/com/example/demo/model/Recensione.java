package com.example.demo.model;


import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "recensioni")
public class Recensione {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(nullable = false)
private String testo;

@OneToMany
@JsonIgnore
@JoinColumn(name = "autore_id", nullable = false)
private ArrayList<Autore> autore;

@ManyToOne
@JoinColumn(name = "libro_id", nullable = false)
private Libro libro;


}