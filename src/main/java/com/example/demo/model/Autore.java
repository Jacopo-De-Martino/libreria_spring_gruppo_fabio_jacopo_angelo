package com.example.demo.model;  


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;  

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;  

@Entity  // Marca la classe come entità JPA, mappata su una tabella del database
@Data  // Lombok: genera getter, setter, equals(), hashCode() e toString()
@NoArgsConstructor  // Lombok: genera un costruttore senza argomenti
@AllArgsConstructor  // Lombok: genera un costruttore con un argomento per ciascun campo
@Builder  // Lombok: abilita il pattern “builder” per creare oggetti in modo fluente
@Table(name = "autori")  // Specifica il nome della tabella nel database: “utenti”
public class Autore {

    @Id  // Indica che il campo seguente è la chiave primaria dell’entità

    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Definisce la strategia di generazione dell’ID (auto-increment nel DB)
    // Campo che rappresenta l’identificativo univoco dell’utente
    private Long id;  


    @Column(nullable = false)
    @NotBlank(message = "Il nome è obbligatorio")
    @Size(min = 3, max = 100, message = "Il nome deve essere tra 3 e 100 caratteri")  
    // Mappa il campo su una colonna NOT NULL nel database
    private String nome;  
    // Campo che memorizza il nome dell’utente, obbligatorio

    // Nome del campo in Todo che “possiede” la relazione
    @OneToMany(
        // Propaga tutte le operazioni JPA (persist, merge, remove…)
        mappedBy = "autore",                
        // Elimina dal DB i Todo rimossi dalla lista (“orfani”)
        cascade = CascadeType.ALL,         
        orphanRemoval = true               
    )
    @JsonIgnore
    private List<Libro> libri;  

}
