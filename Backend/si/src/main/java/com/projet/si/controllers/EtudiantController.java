package com.projet.si.controllers;

import com.projet.si.model.*;
import com.projet.si.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:5173", allowCredentials="true")

//@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("/api/etudiant")
public class EtudiantController {
    @Autowired
    private EtudiantsansAuthRepository etudiantsansAuthRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private StageRepository stageRepository;
    @Autowired
    private EntrepriseRepository entrepriseRepository;
    @Autowired
    private TuteurRepository tuteurRepository;
    @PostMapping("/assigner-etudiant-au-stage/{etudiantId}/{stageId}")
    public ResponseEntity<?> assignerEtudiantAuStage(@PathVariable Long etudiantId, @PathVariable Long stageId) {
        Optional<Etudiantsauth> etudiantOptional = etudiantsansAuthRepository.findById(etudiantId);
        Optional<Stage> stageOptional = stageRepository.findById(stageId);

        if (etudiantOptional.isPresent() && stageOptional.isPresent()) {
            Etudiantsauth etudiantsauth = etudiantOptional.get();
            Stage stage = stageOptional.get();

            stage.setEtudiant(etudiantsauth);

            stageRepository.save(stage);

            return ResponseEntity.ok("L'étudiant a été assigné au stage avec succès.");
        } else {
            return ResponseEntity.badRequest().body("L'étudiant ou le stage n'a pas été trouvé.");
        }
    }
    @PostMapping("/assigner-tuteur-au-stage/{tuteurId}/{stageId}")
    public ResponseEntity<?> assignerTuteurAuStage(@PathVariable Long tuteurId, @PathVariable Long stageId) {
        Optional<Tuteur> tuteurOptional = tuteurRepository.findById(tuteurId);
        Optional<Stage> stageOptional = stageRepository.findById(stageId);

        if (tuteurOptional.isPresent() && stageOptional.isPresent()) {
            Tuteur tuteur = tuteurOptional.get();
            Stage stage = stageOptional.get();

            stage.setTuteur(tuteur);

            stageRepository.save(stage);

            return ResponseEntity.ok("Le tuteur a été assigné au stage avec succès.");
        } else {
            return ResponseEntity.badRequest().body("Le tuteur ou le stage n'a pas été trouvé.");
        }
    }


    @PostMapping("/stages")
    public ResponseEntity<Stage> createStage(@RequestBody Stage stage) {
        return ResponseEntity.ok(stageRepository.save(stage));
    }
    @DeleteMapping("/stages/{id}")
    public ResponseEntity<Void> deleteStage(@PathVariable(value = "id") Long id) {
        return stageRepository.findById(id)
                .map(stage -> {
                    stageRepository.delete(stage);
                    return ResponseEntity.ok().<Void>build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/stages/{id}")
    public ResponseEntity<Stage> updateStage(@PathVariable Long id, @RequestBody Stage stageDetails) {
        return stageRepository.findById(id).map(existingStage -> {
            existingStage.setAnneestage(stageDetails.getAnneestage());
            existingStage.setCompteRendu(stageDetails.getCompteRendu());
            existingStage.setIdEtudiant(stageDetails.getIdEtudiant());
            existingStage.setIdEntreprise(stageDetails.getIdEntreprise());
            existingStage.setIdTuteur(stageDetails.getIdTuteur());
            existingStage.setPid(stageDetails.getPid());
            existingStage.setAnneePromo(stageDetails.getAnneePromo());
            existingStage.setCodeStage(stageDetails.getCodeStage());


            return ResponseEntity.ok(stageRepository.save(existingStage));
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/stage/{id}")
    public ResponseEntity<Stage> getStageByID(@PathVariable(value = "id") Long id) {
        return stageRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
//    @PutMapping("/etudiants/{id}")
//    public ResponseEntity<Etudiantsauth> updateEtudiant(@PathVariable Long id, @RequestBody Etudiantsauth etudiantDetails) {
//        return etudiantsansAuthRepository.findById(id).map(existingEtudiant -> {
//            existingEtudiant.setNometudiant(etudiantDetails.getNometudiant());
//            existingEtudiant.setPrenometudiant(etudiantDetails.getPrenometudiant());
//            existingEtudiant.setAdresseetudiant(etudiantDetails.getAdresseetudiant());
//            existingEtudiant.setCodePostaletudiant(etudiantDetails.getCodePostaletudiant());
//            existingEtudiant.setVilleetudiant(etudiantDetails.getVilleetudiant());
//            existingEtudiant.setSexetudiant(etudiantDetails.getSexetudiant());
//            existingEtudiant.setDateNaissanceetudiant(etudiantDetails.getDateNaissanceetudiant());
//            existingEtudiant.setEmailetudiant(etudiantDetails.getEmailetudiant());
//            existingEtudiant.setTelephoneetudiant(etudiantDetails.getTelephoneetudiant());
//            existingEtudiant.setEqualite(etudiantDetails.getEqualite());
//            existingEtudiant.setEsuite(etudiantDetails.getEsuite());
//            existingEtudiant.setMention(etudiantDetails.getMention());
//
//            return ResponseEntity.ok(etudiantsansAuthRepository.save(existingEtudiant));
//        }).orElse(ResponseEntity.notFound().build());
//    }
//
//    @GetMapping("/etu/{id}")
//    public ResponseEntity<Etudiantsauth> getEtudiantById(@PathVariable(value = "id") Long id) {
//        return etudiantsansAuthRepository.findById(id)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }

    @PostMapping("/entreprises")
    public ResponseEntity<Entreprise> createEntreprise(@RequestBody Entreprise entreprise) {
        return ResponseEntity.ok(entrepriseRepository.save(entreprise));
    }

    @GetMapping("/entreprises")
    public ResponseEntity<List<Entreprise>> getAllEntreprises() {
        List<Entreprise> entreprises = entrepriseRepository.findAll();
        return ResponseEntity.ok(entreprises);
    }
    @PostMapping("/assigner-entreprise-au-stage/{entrepriseId}/{stageId}")
    public ResponseEntity<?> assignerEntrepriseAuStage(@PathVariable Long entrepriseId, @PathVariable Long stageId) {
        Optional<Entreprise> entrepriseOptional = entrepriseRepository.findById(entrepriseId);
        Optional<Stage> stageOptional = stageRepository.findById(stageId);

        if (entrepriseOptional.isPresent() && stageOptional.isPresent()) {
            Entreprise entreprise = entrepriseOptional.get();
            Stage stage = stageOptional.get();

            stage.setEntreprise(entreprise);

            stageRepository.save(stage);

            return ResponseEntity.ok("L'entreprise a été assignée au stage avec succès.");
        } else {
            return ResponseEntity.badRequest().body("L'entreprise ou le stage n'a pas été trouvé.");
        }
    }

    @GetMapping("/entreprises/{id}")
    public ResponseEntity<Entreprise> getEntrepriseById(@PathVariable(value = "id") Long id) {
        return entrepriseRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/entreprises/{id}")
    public ResponseEntity<Entreprise> updateEntreprise(@PathVariable Long id, @RequestBody Entreprise entrepriseDetails) {
        return entrepriseRepository.findById(id).map(existingEntreprise -> {
            existingEntreprise.setRaisonSociale(entrepriseDetails.getRaisonSociale());
            existingEntreprise.setFormeJuridique(entrepriseDetails.getFormeJuridique());
            existingEntreprise.setAdresseentreprise(entrepriseDetails.getAdresseentreprise());
            existingEntreprise.setCodePostalentreprise(entrepriseDetails.getCodePostalentreprise());
            existingEntreprise.setVille_entreprise(entrepriseDetails.getVille_entreprise());
            existingEntreprise.setTelephone_entreprise(entrepriseDetails.getTelephone_entreprise());
            existingEntreprise.setContactentreprise(entrepriseDetails.getContactentreprise());
            existingEntreprise.setFax(entrepriseDetails.getFax());

            return ResponseEntity.ok(entrepriseRepository.save(existingEntreprise));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/entreprises/{id}")
    public ResponseEntity<Void> deleteEntreprise(@PathVariable(value = "id") Long id) {
        return entrepriseRepository.findById(id)
                .map(entreprise -> {
                    entrepriseRepository.delete(entreprise);
                    return ResponseEntity.ok().<Void>build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/tuut")
    public ResponseEntity<Tuteur> createTuteur(@RequestBody Tuteur tuteur) {
        return ResponseEntity.ok(tuteurRepository.save(tuteur));
    }

    @GetMapping("/tuteurs")
    public ResponseEntity<List<Tuteur>> getAllTuteurs() {
        List<Tuteur> tuteurs = tuteurRepository.findAll();
        return ResponseEntity.ok(tuteurs);
    }

    @GetMapping("/tuteu/{id}")
    public ResponseEntity<Tuteur> getTuteurById(@PathVariable(value = "id") Long id) {
        return tuteurRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/tut/{id}")
    public ResponseEntity<Tuteur> updateTuteur(@PathVariable Long id, @RequestBody Tuteur tuteurDetails) {
        return tuteurRepository.findById(id).map(existingTuteur -> {
            existingTuteur.setNom(tuteurDetails.getNom());
            existingTuteur.setPrenom(tuteurDetails.getPrenom());
            existingTuteur.setQualite(tuteurDetails.getQualite());
            existingTuteur.setIdEntreprise(tuteurDetails.getIdEntreprise());
            existingTuteur.setTelephone(tuteurDetails.getTelephone());
            return ResponseEntity.ok(tuteurRepository.save(existingTuteur));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/tuteurs/{id}")
    public ResponseEntity<Void> deleteTuteur(@PathVariable(value = "id") Long id) {
        return tuteurRepository.findById(id)
                .map(tuteur -> {
                    tuteurRepository.delete(tuteur);
                    return ResponseEntity.ok().<Void>build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}