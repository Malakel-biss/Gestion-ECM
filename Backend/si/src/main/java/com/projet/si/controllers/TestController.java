package com.projet.si.controllers;

import com.projet.si.model.Candidat;
import com.projet.si.model.Etudiant;
import com.projet.si.model.Professeur;
import com.projet.si.model.Stage;
import com.projet.si.repository.CandidatRepository;
import com.projet.si.repository.EtudiantRepository;
import com.projet.si.repository.ProfesseurRepository;
import com.projet.si.repository.StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/app")
public class TestController {
    private ProfesseurRepository professeurRepository;
    @GetMapping("/test/id")
    public ResponseEntity<Professeur> getProfesseurByID(@PathVariable(value = "id") Long id) {
        return professeurRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}