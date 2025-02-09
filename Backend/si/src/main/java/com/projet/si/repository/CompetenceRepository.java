package com.projet.si.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projet.si.model.Competence;

import java.util.Optional;

public interface CompetenceRepository extends JpaRepository<Competence, Long> {
    Optional<Competence> findByCodeCompetence(String codeCompetence);

}
