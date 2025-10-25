package com.example.SpringDataRest.cours.controller;

import com.example.SpringDataRest.cours.modele.Voiture;
import com.example.SpringDataRest.cours.modele.VoitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/voitures")
@CrossOrigin(origins = "http://localhost:5173")
public class VoitureController {

    @Autowired
    private VoitureRepo voitureRepo;

    @GetMapping
    public Iterable<Voiture> getVoitures() {
        return voitureRepo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Voiture> getVoiture(@PathVariable Long id) {
        return voitureRepo.findById(id);
    }

    @PostMapping
    public Voiture addVoiture(@RequestBody Voiture v) {
        return voitureRepo.save(v);
    }

    @DeleteMapping("/{id}")
    public void deleteVoiture(@PathVariable Long id) {
        voitureRepo.deleteById(id);
    }
}
