package com.example.SpringDataRest;

import com.example.SpringDataRest.cours.modele.Voiture;
import com.example.SpringDataRest.cours.modele.VoitureRepo;
import com.example.SpringDataRest.cours.modele.Proprietaire;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class VoitureRepoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private VoitureRepo voitureRepo;

    private Proprietaire proprietaire;

    @BeforeEach
    public void setUp() {
        // Création d'un propriétaire pour les tests
        proprietaire = new Proprietaire("John", "Doe");
        entityManager.persistAndFlush(proprietaire);
    }

    @Test
    public void ajouterVoiture() {
        // Given - Une voiture avec un propriétaire
        Voiture voiture = new Voiture("MiolaCar", "Uber", "Blanche", "M-2020", 2021, 180000, proprietaire);

        // When - On persiste la voiture
        entityManager.persistAndFlush(voiture);

        // Then - La voiture a un ID généré
        assertThat(voiture.getId()).isNotNull();
        // Et le propriétaire est bien associé
        assertThat(voiture.getProprietaire()).isEqualTo(proprietaire);
    }

    @Test
    public void supprimerVoiture() {
        // Given - Deux voitures avec propriétaire
        Voiture voiture1 = new Voiture("MiolaCar", "Uber", "Blanche", "M-2020", 2021, 180000, proprietaire);
        Voiture voiture2 = new Voiture("MiniCooper", "Uber", "Rouge", "C-2020", 2021, 180000, proprietaire);

        entityManager.persistAndFlush(voiture1);
        entityManager.persistAndFlush(voiture2);

        // When - On supprime toutes les voitures
        voitureRepo.deleteAll();

        // Then - La base est vide
        assertThat(voitureRepo.findAll()).isEmpty();
    }

    @Test
    public void trouverVoitureAvecProprietaire() {
        // Given - Une voiture sauvegardée avec propriétaire
        Voiture voiture = new Voiture("Tesla", "Model S", "Noire", "TS-2023", 2023, 250000, proprietaire);
        Voiture savedVoiture = entityManager.persistAndFlush(voiture);

        // When - On recharge la voiture depuis la base
        Voiture foundVoiture = entityManager.find(Voiture.class, savedVoiture.getId());

        // Then - Le propriétaire est bien associé
        assertThat(foundVoiture).isNotNull();
        assertThat(foundVoiture.getProprietaire()).isNotNull();
        assertThat(foundVoiture.getProprietaire().getNom()).isEqualTo("Doe");
    }

    @Test
    public void modifierProprietaireVoiture() {
        // Given - Une voiture existante
        Voiture voiture = new Voiture("BMW", "Serie 3", "Bleue", "BM-2022", 2022, 300000, proprietaire);
        Voiture savedVoiture = entityManager.persistAndFlush(voiture);

        // When - On change le propriétaire
        Proprietaire nouveauProprietaire = new Proprietaire("Jane", "Smith");
        entityManager.persistAndFlush(nouveauProprietaire);

        savedVoiture.setProprietaire(nouveauProprietaire);
        entityManager.persistAndFlush(savedVoiture);

        // Then - Le propriétaire est mis à jour
        Voiture updatedVoiture = entityManager.find(Voiture.class, savedVoiture.getId());
        assertThat(updatedVoiture.getProprietaire().getPrenom()).isEqualTo("Jane");
    }
}