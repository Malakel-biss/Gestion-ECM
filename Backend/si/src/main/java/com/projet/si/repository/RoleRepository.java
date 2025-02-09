package com.projet.si.repository;

import com.projet.si.model.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Stage, Long> {
}
