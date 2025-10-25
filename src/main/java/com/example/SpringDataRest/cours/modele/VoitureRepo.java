package com.example.SpringDataRest.cours.modele;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface VoitureRepo extends CrudRepository<Voiture, Long> {
    List<Voiture> findByMarque(@Param("marque") String marque);
    List<Voiture> findByCouleur(@Param("couleur") String couleur);

    // exemple query
    @Query("select v from Voiture v where v.marque = ?1")
    List<Voiture> findByMarqueQuery(String marque);
}