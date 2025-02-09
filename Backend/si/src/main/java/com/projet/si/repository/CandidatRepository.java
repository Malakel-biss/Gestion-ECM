package com.projet.si.repository;

import com.projet.si.model.TypeStage;
import io.micrometer.observation.ObservationFilter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projet.si.model.Candidat;

import java.util.Date;
import java.util.List;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Long> {
    List<Candidat> findByNomContaining(String nom);

    List<Candidat> findByPrenomContaining(String prenom);


    List<Candidat> findByAdresseContaining(String adresse);

    List<Candidat> findByCodePostal(String codePostal);


    List<Candidat> findByVille(String ville);

    List<Candidat> findBySex(String sex);


    List<Candidat> findByDateNaissance(Date dateNaissance);

    List<Candidat> findByEmail(String email);

    List<Candidat> findByTelephone(String telephone);

}
