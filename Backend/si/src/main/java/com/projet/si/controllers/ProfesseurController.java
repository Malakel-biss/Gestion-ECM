package com.projet.si.controllers;

import com.projet.si.model.*;
import com.projet.si.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
@CrossOrigin(origins = "http://localhost:5173", allowCredentials="true")
//@PreAuthorize("hasRole('PROFESSEUR')")
@RestController
@RequestMapping("/api/prof")
public class ProfesseurController {
    @Autowired
    private ProfesseursansAuthRepository professeursAuthRepository;

    @Autowired
    private StageRepository stageRepository;

    @Autowired
    private PromoRepository promoRepository;

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @Autowired
    private TuteurRepository tuteurRepository;
    @Autowired
    private EtudiantsansAuthRepository etudiantRepository;
    @GetMapping("/intern")
    public ResponseEntity<List<ForNone>> getAllStage() {
        List<Stage> stages = stageRepository.findAll();
        List<ForNone> forNones = new ArrayList<>();

        // Récupérer les noms des entreprises, tuteurs, professeurs et étudiants
        for (Stage stage : stages) {
            ForNone forNone = new ForNone(stage);
            Entreprise entreprise = entrepriseRepository.findById(stage.getIdEntreprise()).orElse(null);
            if (entreprise != null) {
                forNone.setNomEntreprise(entreprise.getNomEntreprise()); // Supposons que vous ayez une méthode getNom() dans la classe Entreprise
            }

            Tuteur tuteur = tuteurRepository.findById(stage.getIdTuteur()).orElse(null);
            if (tuteur != null) {
                forNone.setNomTuteur(tuteur.getNom()); // Supposons que vous ayez une méthode getNom() dans la classe Tuteur
            }

            Professeursauth professeur = professeursAuthRepository.findById(stage.getPid()).orElse(null);
            if (professeur != null) {
                forNone.setNomProfesseur(professeur.getPnom()); // Supposons que vous ayez une méthode getNom() dans la classe Professeursauth
            }

            Etudiantsauth etudiant = etudiantRepository.findById(stage.getIdEtudiant()).orElse(null);
            if (etudiant != null) {
                forNone.setNomEtudiant(etudiant.getNometudiant()); // Supposons que vous ayez une méthode getNom() dans la classe Etudiantsauth
            }

            forNones.add(forNone);
        }


        return ResponseEntity.ok(forNones);

    }
    @PutMapping("/professeurs/{id}")
    public ResponseEntity<Professeursauth> updateProfesseurAuth(@PathVariable Long id, @RequestBody Professeur professeurDetails) {
        return professeursAuthRepository.findById(id).map(existingProfesseurAuth -> {
            if (professeurDetails.getPnom() != null) {
                existingProfesseurAuth.setPnom(professeurDetails.getPnom());
            }
            if (professeurDetails.getPprenom() != null) {
                existingProfesseurAuth.setPprenom(professeurDetails.getPprenom());
            }
            if (professeurDetails.getPadresse() != null) {
                existingProfesseurAuth.setPadresse(professeurDetails.getPadresse());
            }
            if (professeurDetails.getPcodePostal() != null) {
                existingProfesseurAuth.setPcodePostal(professeurDetails.getPcodePostal());
            }
            if (professeurDetails.getPville() != null) {
                existingProfesseurAuth.setPville(professeurDetails.getPville());
            }
            if (professeurDetails.getPsuite() != null) {
                existingProfesseurAuth.setPsuite(professeurDetails.getPsuite());
            }
            if (professeurDetails.getPqualite() != null) {
                existingProfesseurAuth.setPqualite(professeurDetails.getPqualite());
            }
            if (professeurDetails.getPdatenaissance() != null) {
                existingProfesseurAuth.setPdatenaissance(professeurDetails.getPdatenaissance());
            }
            if (professeurDetails.getDateembauche() != null) {
                existingProfesseurAuth.setDateembauche(professeurDetails.getDateembauche());
            }
            if (professeurDetails.getDatedepart() != null) {
                existingProfesseurAuth.setDatedepart(professeurDetails.getDatedepart());
            }
            if (professeurDetails.getPtelephonedomicile() != null) {
                existingProfesseurAuth.setPtelephonedomicile(professeurDetails.getPtelephonedomicile());
            }
            if (professeurDetails.getPtelephoneecole() != null) {
                existingProfesseurAuth.setPtelephoneecole(professeurDetails.getPtelephoneecole());
            }


            return ResponseEntity.ok(professeursAuthRepository.save(existingProfesseurAuth));
        }).orElse(ResponseEntity.notFound().build());
    }


    //    @GetMapping("/professeurs/{id}/stages")
//    public ResponseEntity<?> getStagesByProfesseur(@PathVariable Long id) {
//        // Check if the professor exists
//        Optional<Professeur> professeurOptional = professeurRepository.findById(id);
//        if (!professeurOptional.isPresent()) {
//            return ResponseEntity.notFound().build();
//        }
//
//        // Get the internships (stages) for this professor
//        List<Stage> stages = stageRepository.findByPid(id);
//
//        // Assuming Stage has a method to get the associated student,
//        // and you want to return a list of stages with student details,
//        // you can map each stage to a DTO or a Map for a better response structure.
//        List<Map<String, Object>> stageDetails = stages.stream().map(stage -> {
//            Map<String, Object> stageInfo = new HashMap<>();
//            stageInfo.put("stage", stage);
//            stageInfo.put("student", stage.getIdEtudiant()); // Replace 'getEtudiant' with the actual method name
//            return stageInfo;
//        }).collect(Collectors.toList());
//
//        return ResponseEntity.ok(stageDetails);
//    }
    @GetMapping("/professeurs/{id}/stages")
    public ResponseEntity<?> getStagesByProfesseur(@PathVariable Long id) {
        Optional<Professeursauth> professeurOptional = professeursAuthRepository.findById(id);
        if (!professeurOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        List<Stage> stages = stageRepository.findByPid(id);
        List<Map<String, Object>> stageDetails = stages.stream().map(stage -> {
            Map<String, Object> stageInfo = new HashMap<>();
            stageInfo.put("stage", stage);

            // Fetching student's name
            etudiantRepository.findById(stage.getIdEtudiant()).ifPresent(etudiant ->
                    stageInfo.put("studentName", etudiant.getNometudiant() + " " + etudiant.getPrenometudiant()));

            // Fetching entreprise's name
            entrepriseRepository.findById(stage.getIdEntreprise()).ifPresent(entreprise ->
                    stageInfo.put("entrepriseName", entreprise. getNomEntreprise()));

            // Fetching tuteur's name
            tuteurRepository.findById(stage.getIdTuteur()).ifPresent(tuteur ->
                    stageInfo.put("tuteurName", tuteur.getNom() + " " + tuteur.getPrenom()));

            return stageInfo;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(stageDetails);
    }


    @PutMapping("/professeurs/{professeurId}/stages/{stageId}/mention")
    public ResponseEntity<?> updateStageMention(@PathVariable Long professeurId,
                                                @PathVariable Long stageId,
                                                @RequestBody String mention) {
        // Optional: Check if the professor exists
        if (!professeursAuthRepository.existsById(professeurId)) {
            return ResponseEntity.notFound().build();
        }

        // Find the stage and update its mention
        return stageRepository.findById(stageId).map(stage -> {
            // Optional: Check if the stage belongs to the professor
            // if (!stage.getProfesseur().getId().equals(professeurId)) {
            //     return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            // }

            stage.setMention(mention);
            stageRepository.save(stage);
            return ResponseEntity.ok(stage);
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/professeurs/{professeurId}/promos")
    public ResponseEntity<List<Promo>> findByPid(@PathVariable Long professeurId) {
        if (!professeursAuthRepository.existsById(professeurId)) {
            return ResponseEntity.notFound().build();
        }

        List<Promo> promos = promoRepository.findByPid(professeurId); // Assuming this method is implemented in your repository
        return ResponseEntity.ok(promos);
    }

    @Autowired
    private CompetenceRepository competenceRepository;



    // Add a new competence
    @PostMapping("/competences")
    public ResponseEntity<Competence> addCompetence(@RequestBody Competence competence) {
        return ResponseEntity.ok(competenceRepository.save(competence));
    }

    // Get all competences
    @GetMapping("/competences")
    public ResponseEntity<List<Competence>> getAllCompetences() {
        return ResponseEntity.ok(competenceRepository.findAll());
    }

    // Update a competence
    @PutMapping("/competences/{codeCompetence}")
    public ResponseEntity<Competence> updateCompetence(@PathVariable String codeCompetence, @RequestBody Competence competenceDetails) {
        return competenceRepository.findByCodeCompetence(codeCompetence).map(competence -> {
            competence.setLibelle(competenceDetails.getLibelle());
            competence.setDescription(competenceDetails.getDescription());
            return ResponseEntity.ok(competenceRepository.save(competence));
        }).orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/competences/{codeCompetence}")
    public ResponseEntity<?> deleteCompetence(@PathVariable String codeCompetence) {
        return competenceRepository.findByCodeCompetence(codeCompetence).map(competence -> {
            competenceRepository.delete(competence);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }











}
