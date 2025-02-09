package com.projet.si.controllers;

import com.projet.si.model.*;
import com.projet.si.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:5173", allowCredentials="true")
//@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("/api/candidat")
public class CandidatController {

    @Autowired
    private CandidatRepository candidatRepository;
    @Autowired
    private ProfesseursansAuthRepository professeursansAuthRepository;
    @PostMapping("/candidat")
    public ResponseEntity<Candidat> createCandidat(@RequestBody Candidat candidat) {
        return ResponseEntity.ok(candidatRepository.save(candidat));
    }
}
