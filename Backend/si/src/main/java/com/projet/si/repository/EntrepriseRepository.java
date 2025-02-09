package com.projet.si.repository;

import com.projet.si.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
    Optional<Entreprise> findByIdEntreprise(Long idEntreprise);
    List<Entreprise> findByRaisonSociale(String raisonSociale);
    List<Entreprise> findByFormeJuridique(String formeJuridique);
    List<Entreprise> findByAdresseentreprise(String adresseentreprise);
    List<Entreprise> findByCodePostalentreprise(String codePostalentreprise);
    List<Entreprise> findByVilleentreprise(String villeentreprise);
    List<Entreprise> findByTelephoneentreprise(String telephoneentreprise);
    List<Entreprise> findByContactentreprise(String contactentreprise);
    List<Entreprise> findByFax(String fax);
}

