package com.example.SpringDataRest;

import com.example.SpringDataRest.cours.modele.Proprietaire;
import com.example.SpringDataRest.cours.modele.ProprietaireRepo;
import com.example.SpringDataRest.cours.modele.Voiture;
import com.example.SpringDataRest.cours.modele.VoitureRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(VoitureRepo voitureRepo, ProprietaireRepo proprietaireRepo) {
		return args -> {
			// Création de quelques propriétaires
			Proprietaire prop1 = new Proprietaire("Mohamed", "Cheikhi");
			Proprietaire prop2 = new Proprietaire("Yassine", "Cherif");
			proprietaireRepo.save(prop1);
			proprietaireRepo.save(prop2);

			// Ajout de voitures liées à ces propriétaires
			voitureRepo.save(new Voiture("Toyota", "Corolla", "Grise", "A-1-9090", 2018, 95000, prop1));
			voitureRepo.save(new Voiture("Ford", "Fiesta", "Rouge", "A-2-8090", 2015, 90000, prop2));
			voitureRepo.save(new Voiture("Honda", "CRV", "Bleu", "A-3-7090", 2016, 140000, prop1));
		};
	}
}
