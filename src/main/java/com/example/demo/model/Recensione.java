package com.example.demo.model;



import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;

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
@NotBlank(message = "Il testo è obbligatoria")
@Size(min = 3, max = 100, message = "Il testo della recensione deve essere tra 3 e 100 caratteri")
private String testo;

@ManyToOne
@JoinColumn(name = "libro_id", nullable = false)
private Libro libro;


}