package com.projet.si.repository;

import com.projet.si.model.ERole;
import com.projet.si.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    List<User> findAllByRole(ERole role);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Optional<User> findUserById(Long id);




    // Custom query to find students without notes

}
