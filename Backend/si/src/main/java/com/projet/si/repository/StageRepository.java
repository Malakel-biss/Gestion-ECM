package com.projet.si.repository;

import com.projet.si.model.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StageRepository extends JpaRepository<Stage, Long> {

    List<Stage> findByAnneestage(String anneeStage);

    List<Stage> findByCompteRenduContaining(String compteRendu);

    List<Stage> findByIdEtudiant(Long idEtudiant);

    List<Stage> findByIdEntreprise(Long idEntreprise);

    List<Stage> findByIdTuteur(Long idTuteur);

    List<Stage> findByPid(Long pId);

    List<Stage> findByAnneePromo(String anneePromo);

    List<Stage> findByCodeStage(Long codeStage);


}

