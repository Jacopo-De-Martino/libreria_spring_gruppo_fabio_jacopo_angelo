package com.example.demo.model;



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

@ManyToOne
@JoinColumn(name = "libro_id", nullable = false)
private Libro libro;


}