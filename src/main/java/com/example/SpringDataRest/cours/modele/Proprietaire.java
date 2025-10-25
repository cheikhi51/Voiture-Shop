package com.example.SpringDataRest.cours.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Proprietaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String prenom;
    private String nom;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proprietaire")
    private List<Voiture> voitures;

    public Proprietaire() {
    }

    public Proprietaire(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public List<Voiture> getVoitures() { return voitures; }
    public void setVoitures(List<Voiture> voitures) { this.voitures = voitures; }
}