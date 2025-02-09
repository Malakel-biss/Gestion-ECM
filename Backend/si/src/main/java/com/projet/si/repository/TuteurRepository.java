package com.projet.si.repository;



import com.projet.si.model.Tuteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface TuteurRepository extends JpaRepository<Tuteur, Long>  {

}
