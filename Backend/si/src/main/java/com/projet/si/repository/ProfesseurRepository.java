package com.projet.si.repository;

import com.projet.si.model.Professeur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {
    List<Professeur> findByPnomContaining(String nom);


    List<Professeur> findByPprenomContaining(String prenom);


    List<Professeur> findByPadresseContaining(String adresse);


    List<Professeur> findByPville(String ville);


    List<Professeur> findByPcodePostal(String codePostal);


    List<Professeur> findByPdatenaissance(Date dateNaissance);


    List<Professeur> findByPtelephonedomicile(String telephone);

    List<Professeur> findByPtelephoneecole(String telephone);


}

