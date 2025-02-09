package com.projet.si.repository;

import com.projet.si.model.Candidat;
import io.micrometer.observation.ObservationFilter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projet.si.model.Date;


import java.util.List;

@Repository

public interface DateRepository extends JpaRepository<Date, Long> {
}
