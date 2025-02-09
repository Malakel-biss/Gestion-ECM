package com.projet.si.repository;

import com.projet.si.model.Promo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PromoRepository extends JpaRepository<Promo, String> {

    List<Promo> findByPid(Long professeurId);
}
