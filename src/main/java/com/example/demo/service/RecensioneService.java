package com.example.demo.service;


import com.example.demo.model.Recensione;
import com.example.demo.repository.RecensioneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecensioneService {

private final RecensioneRepository recensioneRepository;

public List<Recensione> findAll() {
return recensioneRepository.findAll();
}

public List<Recensione> findByRecensioneId(Long RecensioneId) {
return recensioneRepository.findByRecensioneId(RecensioneId);
}

public Recensione findById(Long id) {
return recensioneRepository.findById(id).orElseThrow(() -> new RuntimeException("Recensione non trovata"));
}

public Recensione save(Recensione recensione) {
return recensioneRepository.save(recensione);
}

public void delete(Long id) {
recensioneRepository.deleteById(id);
}
}