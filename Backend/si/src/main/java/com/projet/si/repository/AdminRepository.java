package com.projet.si.repository;

import com.projet.si.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByEmail(String email);
    Optional<Admin> findByNom(String nom);

    Optional<Admin> findByIdUser(Long idUser);
}