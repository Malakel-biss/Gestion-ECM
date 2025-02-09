package com.projet.si.repository;

import com.projet.si.model.Professeursauth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProfesseursansAuthRepository  extends JpaRepository<Professeursauth, Long> {
    List<Professeursauth> findByPnomContaining(String nom);


    List<Professeursauth> findByPprenomContaining(String prenom);


    List<Professeursauth> findByPadresseContaining(String adresse);


    List<Professeursauth> findByPville(String ville);


    List<Professeursauth> findByPcodePostal(String codePostal);


    List<Professeursauth> findByPdatenaissance(Date dateNaissance);


    List<Professeursauth> findByPtelephonedomicile(String telephone);

    List<Professeursauth> findByPtelephoneecole(String telephone);

}
