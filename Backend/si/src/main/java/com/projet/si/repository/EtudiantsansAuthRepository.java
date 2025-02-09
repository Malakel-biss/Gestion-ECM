package com.projet.si.repository;

import com.projet.si.model.EtudiantXXXXXX;
import com.projet.si.model.Etudiantsauth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;
@Repository
public interface EtudiantsansAuthRepository extends JpaRepository<Etudiantsauth, Long> {

    List<Etudiantsauth> findByNometudiantContaining(String nom);
    List<Etudiantsauth> findByPrenometudiantContaining(String prenom);
    List<Etudiantsauth> findByAdresseetudiantContaining(String adresse);
    List<Etudiantsauth> findByVilleetudiant(String ville);
    List<Etudiantsauth> findByCodePostaletudiant(String codePostal);
    List<Etudiantsauth> findByEmailetudiant(String email);
    List<Etudiantsauth> findByDateNaissanceetudiant(Date dateNaissance);
    List<Etudiantsauth> findBySexetudiant(String sexe);

}

