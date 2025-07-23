package com.example.demo.service;

import com.example.demo.repository.AutoreRepository;
import com.example.demo.model.Autore;

import org.springframework.stereotype.Service;

import java.util.*;

// Marca la classe come bean di servizio gestito da Spring
@Service                                     

// Definizione della classe di servizio per la logica business di Libreria
public class AutoreService {                   

    // Repository JPA per operazioni CRUD sugli oggetti autore
    private final AutoreRepository repo;        

    // Costruttore che riceve il repository tramite dependency injection
    public AutoreService(AutoreRepository repo) {  
        
        // Inizializza il campo repo con l'istanza iniettata
        this.repo = repo;                         
    }

    // Metodo per recuperare tutti i autpro dal database
    public List<Autore> getAll() {                
        
        // Crea una lista vuota di autori
        List<Autore> lista = new ArrayList<>();   
        
        // Aggiunge ogni autore trovato alla lista
        repo.findAll().forEach(lista::add);      
        
        // Restituisce la lista popolata di autori
        return lista;                            
    }

    // Metodo per recuperare un autore per chiave primaria
    public Optional<Autore> getById(Long id) {     
        
        // Restituisce Optional.empty() o Optional<autore> se presente
        return repo.findById(id);                
    }

    
    // Metodo per salvare un nuovo autore nel database
    public Autore create(Autore nuovo) {            
        
        // Esegue l'INSERT e restituisce l'entità persistita
        return repo.save(nuovo);                 
    }

    
    // Metodo per aggiornare un autore esistente
    public Optional<Autore> update(Long id, Autore modificato) {  
        
        // Cerca il autore in base all'id
        return repo.findById(id)                
        
        // Se il autore esiste, esegue la lambda per modificarlo
                   .map(a -> {                  
                       
                    // Aggiorna il campo titolo
                       a.setNome(modificato.getNome());  
                       
                      
                       // Salva le modifiche e restituisce l'entità aggiornata
                       return repo.save(a);         
                       
                   });                            
    }

    // Metodo per eliminare un autore dal database
    public boolean delete(Long id) {              
        
        // Verifica se un autore con l'id specificato esiste
        if (repo.existsById(id)) {                
            
            // Esegue la cancellazione del autore
            repo.deleteById(id);                 
            
            // Restituisce true se l'eliminazione è avvenuta
            return true;                         
        }
        
        // Restituisce false se il autore non esisteva
        return false;                            
    }
}                                               

