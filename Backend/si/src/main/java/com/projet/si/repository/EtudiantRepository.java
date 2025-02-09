package com.projet.si.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projet.si.model.Etudiant;

import java.util.Date;
import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    List<Etudiant> findByNometudiantContaining(String nom);
    List<Etudiant> findByPrenometudiantContaining(String prenom);
    List<Etudiant> findByAdresseetudiantContaining(String adresse);
    List<Etudiant> findByVilleetudiant(String ville);
    List<Etudiant> findByCodePostaletudiant(String codePostal);
    List<Etudiant> findByEmailetudiant(String email);
    List<Etudiant> findByDateNaissanceetudiant(Date dateNaissance);

    List<Etudiant> findBySexetudiant(String sexe);

}

