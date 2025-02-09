package com.projet.si.repository;

import com.projet.si.model.TypeStage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeStageRepository extends JpaRepository<TypeStage,Long> {

    Optional<TypeStage> findByCodeStage(Long codestage);
}
