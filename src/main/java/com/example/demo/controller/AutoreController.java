package com.example.demo.controller;

import com.example.demo.model.Autore;
import com.example.demo.service.AutoreService;

import jakarta.validation.Valid;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


// Indica che questa classe è un controller REST
@RestController              

// Prefisso comune a tutti gli endpoint: /api/autori
@RequestMapping("/api/autori")         

// Definizione della classe controller
public class AutoreController {                 

    // Dipendenza verso il service che contiene la logica di business
    private final AutoreService service;        

    // Iniezione del service via costruttore
    public AutoreController(AutoreService service) {  
        this.service = service;                   
    }

    // GET /api/autori
    @GetMapping                                   
    
    // Metodo per recuperare tutti gli autori
    public List<Autore> getAll() {                 
        
        // Delega al service la lettura di tutti i record
        return service.getAll();                  
    }

    // GET /api/autori/{id}
    @GetMapping("/{id}")                         
    
    // @PathVariable estrae il valore di {id} dall’URL  
    public ResponseEntity<Autore> getById(@PathVariable Long id) {  
        return service.getById(id)                
        
        // Se il autoreo esiste, restituisce HTTP 200 con il corpo
                      .map(ResponseEntity::ok)    
                     
                      // Altrimenti, restituisce HTTP 404 Not Found
                      .orElse(ResponseEntity.notFound().build());  
    }

    @PostMapping                                  
    
    // @RequestBody deserializza il JSON della richiesta in un oggetto Autore
    public ResponseEntity<Autore> create(@Valid @RequestBody Autore nuovo) {  
        
        // Chiama il service per salvare il nuovo autore
        Autore creato = service.create(nuovo);     
        return ResponseEntity
        
        // HTTP 201 Created
                   .status(HttpStatus.CREATED)   
                   
                   // Restituisce l’entità creata nel corpo della risposta
                   .body(creato);                
    }

    @PutMapping("/{id}")                          
    public ResponseEntity<Autore> update(
            @PathVariable Long id, 
            
            // Riceve l’id da URL e i dati modificati in JSON
            @Valid @RequestBody Autore modificato) {      
        return service.update(id, modificato)     
        
        // Se l’update ha successo, 200 OK con il autoreo aggiornato
                      .map(ResponseEntity::ok)    
                     
                      // Se non esiste un autoreo con quell’id, 404 Not Found
                      .orElse(ResponseEntity.notFound().build());  
    }

    @DeleteMapping("/{id}")                       
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        
        // Chiama il service per eliminare il autoreo
        boolean rimosso = service.delete(id);      
        return rimosso 
        
        // Se eliminato, 204 No Content
               ? ResponseEntity.noContent().build()   
               
               // Se non trovato, 404 Not Found
               : ResponseEntity.notFound().build();   
    }
    
} 


    