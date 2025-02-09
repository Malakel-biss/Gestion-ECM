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
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private TuteurRepository tuteurRepository;
    @Autowired
    private EntrepriseRepository entrepriseRepository;
    @Autowired
    private PromoRepository promoRepository;
    @Autowired
    private DateRepository dateRepository;
    @Autowired
    private TypeStageRepository typeStageRepository;

    @Autowired
    private ProfesseurRepository professeurRepository;
    @Autowired
    private EtudiantsansAuthRepository etudiantsansAuthRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private StageRepository stageRepository;

    @Autowired
    private CandidatRepository candidatRepository;
    @Autowired
    private ProfesseursansAuthRepository professeursansAuthRepository;
    @PostMapping("/professeurs")
    public ResponseEntity<Professeursauth> createProfesseur(@RequestBody Professeursauth professeursauth) {
        return ResponseEntity.ok(professeursansAuthRepository.save(professeursauth));
    }

    @PostMapping("/etudiants")
    public ResponseEntity<Etudiantsauth> createEtudiant(@RequestBody Etudiantsauth etudiantsauth) {
        return ResponseEntity.ok(etudiantsansAuthRepository.save(etudiantsauth));
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
    @DeleteMapping("/candidats/{id}")
    public ResponseEntity<Void> deleteCandidat(@PathVariable(value = "id") Long id) {
        return candidatRepository.findById(id)
                .map(candidat -> {
                    candidatRepository.delete(candidat);
                    return ResponseEntity.ok().<Void>build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/etudiants/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable(value = "id") Long id) {
        return etudiantsansAuthRepository.findById(id)
                .map(etudiant -> {
                    etudiantsansAuthRepository.delete(etudiant);
                    return ResponseEntity.ok().<Void>build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/etus")
    public ResponseEntity<Void> deleteEtudiant(@RequestBody EtudiantDeleteDTO etudiantDeleteDTO) {
        Long id = etudiantDeleteDTO.getId(); // Obtient l'ID à partir de l'objet DTO
        return etudiantsansAuthRepository.findById(id)
                .map(etudiant -> {
                    etudiantsansAuthRepository.delete(etudiant);
                    return ResponseEntity.ok().<Void>build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
    public class EtudiantDeleteDTO {
        private Long id;

        // Default constructor (needed for deserialization)
        public EtudiantDeleteDTO() {}

        // Constructor with id
        public EtudiantDeleteDTO(Long id) {
            this.id = id;
        }

        // Getter and setter for id
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }

    @PutMapping("/etudi")
    public ResponseEntity<Etudiantsauth> updateEtudiant(@RequestBody Etudiantsauth etudiantDetails) {
        Long id = etudiantDetails.getIdEtudiant(); // Assurez-vous que le getter pour l'ID est implémenté dans la classe Etudiantsauth

        return etudiantsansAuthRepository.findById(id).map(existingEtudiant -> {
            existingEtudiant.setNometudiant(etudiantDetails.getNometudiant());
            existingEtudiant.setPrenometudiant(etudiantDetails.getPrenometudiant());
            existingEtudiant.setAdresseetudiant(etudiantDetails.getAdresseetudiant());
            existingEtudiant.setCodePostaletudiant(etudiantDetails.getCodePostaletudiant());
            existingEtudiant.setVilleetudiant(etudiantDetails.getVilleetudiant());
            existingEtudiant.setSexetudiant(etudiantDetails.getSexetudiant());
            existingEtudiant.setDateNaissanceetudiant(etudiantDetails.getDateNaissanceetudiant());
            existingEtudiant.setEmailetudiant(etudiantDetails.getEmailetudiant());
            existingEtudiant.setTelephoneetudiant(etudiantDetails.getTelephoneetudiant());
            existingEtudiant.setEqualite(etudiantDetails.getEqualite());
            existingEtudiant.setEsuite(etudiantDetails.getEsuite());
            existingEtudiant.setMention(etudiantDetails.getMention());
            // ... Ajoutez ici tous les autres champs que vous devez mettre à jour ...

            return ResponseEntity.ok(etudiantsansAuthRepository.save(existingEtudiant));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/profi")
    public ResponseEntity<Void> deleteProfesseur(@RequestBody Professeursauth idDTO) {
        Long id = idDTO.getPid(); // Obtient l'ID à partir de l'objet DTO
        return professeursansAuthRepository.findById(id)
                .map(professeur -> {
                    professeursansAuthRepository.delete(professeur);
                    return ResponseEntity.ok().<Void>build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/professeurs/{id}")
    public ResponseEntity<Void> deleteProfesseur(@PathVariable(value = "id") Long id) {
        return professeursansAuthRepository.findById(id)
                .map(professeur -> {
                    professeursansAuthRepository.delete(professeur);
                    return ResponseEntity.ok().<Void>build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
    // Exemple pour la mise à jour de tous les champs d'un étudiant
    @PutMapping("/etudiants/{id}")
    public ResponseEntity<Etudiantsauth> updateEtudiant(@PathVariable Long id, @RequestBody Etudiantsauth etudiantDetails) {
        return etudiantsansAuthRepository.findById(id).map(existingEtudiant -> {
            existingEtudiant.setNometudiant(etudiantDetails.getNometudiant());
            existingEtudiant.setPrenometudiant(etudiantDetails.getPrenometudiant());
            existingEtudiant.setAdresseetudiant(etudiantDetails.getAdresseetudiant());
            existingEtudiant.setCodePostaletudiant(etudiantDetails.getCodePostaletudiant());
            existingEtudiant.setVilleetudiant(etudiantDetails.getVilleetudiant());
            existingEtudiant.setSexetudiant(etudiantDetails.getSexetudiant());
            existingEtudiant.setDateNaissanceetudiant(etudiantDetails.getDateNaissanceetudiant());
            existingEtudiant.setEmailetudiant(etudiantDetails.getEmailetudiant());
            existingEtudiant.setTelephoneetudiant(etudiantDetails.getTelephoneetudiant());
            existingEtudiant.setEqualite(etudiantDetails.getEqualite());
            existingEtudiant.setEsuite(etudiantDetails.getEsuite());
            existingEtudiant.setMention(etudiantDetails.getMention());

            return ResponseEntity.ok(etudiantsansAuthRepository.save(existingEtudiant));
        }).orElse(ResponseEntity.notFound().build());
    }




    @PutMapping("/candidats/{id}")
    public ResponseEntity<Candidat> updateCandidat(@PathVariable Long id, @RequestBody Candidat candidatDetails) {
        return candidatRepository.findById(id).map(existingCandidat -> {
            existingCandidat.setNom(candidatDetails.getNom());
            existingCandidat.setPrenom(candidatDetails.getPrenom());
            existingCandidat.setAdresse(candidatDetails.getAdresse());
            existingCandidat.setCodePostal(candidatDetails.getCodePostal());
            existingCandidat.setVille(candidatDetails.getVille());
            existingCandidat.setSex(candidatDetails.getSex());
            existingCandidat.setDateNaissance(candidatDetails.getDateNaissance());
            existingCandidat.setEmail(candidatDetails.getEmail());
            existingCandidat.setTelephone(candidatDetails.getTelephone());


            return ResponseEntity.ok(candidatRepository.save(existingCandidat));
        }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/professeurs/{id}")
    public ResponseEntity<Professeursauth> updateProfesseur(@PathVariable Long id, @RequestBody Professeursauth professeurDetails) {
        return professeursansAuthRepository.findById(id).map(existingProfesseur -> {
            existingProfesseur.setPnom(professeurDetails.getPnom());
            existingProfesseur.setPprenom(professeurDetails.getPprenom());
            existingProfesseur.setPadresse(professeurDetails.getPadresse());
            existingProfesseur.setPcodePostal(professeurDetails.getPcodePostal());
            existingProfesseur.setPville(professeurDetails.getPville());
            existingProfesseur.setPsuite(professeurDetails.getPsuite());
            existingProfesseur.setPqualite(professeurDetails.getPqualite());
            existingProfesseur.setPdatenaissance(professeurDetails.getPdatenaissance());
            existingProfesseur.setDateembauche(professeurDetails.getDateembauche());
            existingProfesseur.setDatedepart(professeurDetails.getDatedepart());
            existingProfesseur.setPtelephonedomicile(professeurDetails.getPtelephonedomicile());
            existingProfesseur.setPtelephoneecole(professeurDetails.getPtelephoneecole());


            return ResponseEntity.ok(professeursansAuthRepository.save(existingProfesseur));
        }).orElse(ResponseEntity.notFound().build());
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
            // Répétez pour d'autres champs à mettre à jour

            return ResponseEntity.ok(stageRepository.save(existingStage));
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/etu/{id}")
    public ResponseEntity<Etudiantsauth> getEtudiantById(@PathVariable(value = "id") Long id) {
        return etudiantsansAuthRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/prof/{id}")
    public ResponseEntity<Professeursauth> getProfesseurByID(@PathVariable(value = "id") Long id) {
        return professeursansAuthRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/professor")
    public ResponseEntity<List<Professeursauth>> getAllProfesseurs() {
        List<Professeursauth> professeurs = professeursansAuthRepository.findAll();
        if (professeurs.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(professeurs);
        }
    }
    @GetMapping("/can/{id}")
    public ResponseEntity<Candidat> getCandidatById(@PathVariable(value = "id") Long id) {
        return candidatRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/new")
    public ResponseEntity<List<Candidat>> getAllCandidats() {
        List<Candidat> candidats = candidatRepository.findAll();
        if (candidats.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(candidats);
        }
    }

    @GetMapping("/stage/{id}")
    public ResponseEntity<Stage> getStageByID(@PathVariable(value = "id") Long id) {
        return stageRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

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

            Professeursauth professeur = professeursansAuthRepository.findById(stage.getPid()).orElse(null);
            if (professeur != null) {
                forNone.setNomProfesseur(professeur.getPnom()); // Supposons que vous ayez une méthode getNom() dans la classe Professeursauth
            }

            Etudiantsauth etudiant = etudiantsansAuthRepository.findById(stage.getIdEtudiant()).orElse(null);
            if (etudiant != null) {
                forNone.setNomEtudiant(etudiant.getNometudiant()); // Supposons que vous ayez une méthode getNom() dans la classe Etudiantsauth
            }

            forNones.add(forNone);
        }


        return ResponseEntity.ok(forNones);

    }
    @PostMapping("/assigner-professeur-au-stage/{professeurId}/{stageId}")
    public ResponseEntity<?> assignerProfesseurAuStage(@PathVariable Long professeurId, @PathVariable Long stageId) {
        Optional<Professeursauth> professeurOptional = professeursansAuthRepository.findById(professeurId);
        Optional<Stage> stageOptional = stageRepository.findById(stageId);

        if (professeurOptional.isPresent() && stageOptional.isPresent()) {
            Professeursauth professeur = professeurOptional.get();
            Stage stage = stageOptional.get();

            stage.setProfesseur(professeur);

            stageRepository.save(stage);

            return ResponseEntity.ok("Le professeur a été assigné au stage avec succès.");
        } else {
            return ResponseEntity.badRequest().body("Le professeur ou le stage n'a pas été trouvé.");
        }
    }
    @PostMapping("/assigner-typestage-au-stage/{typeStageId}/{stageId}")
    public ResponseEntity<?> assignerTypeStageAuStage(@PathVariable Long typeStageId, @PathVariable Long stageId) {
        try {
            // Recherche du TypeStage par son ID
            Optional<TypeStage> typeStageOptional = typeStageRepository.findById(typeStageId);

            // Recherche du Stage par son ID
            Optional<Stage> stageOptional = stageRepository.findById(stageId);

            // Vérification de l'existence des objets TypeStage et Stage
            if (typeStageOptional.isPresent() && stageOptional.isPresent()) {
                TypeStage typeStage = typeStageOptional.get();
                Stage stage = stageOptional.get();

                // Assigner le TypeStage au Stage
                stage.setTypeStage(typeStage);
                stageRepository.save(stage);

                return ResponseEntity.ok("Le type de stage a été assigné au stage avec succès.");
            } else {
                return ResponseEntity.badRequest().body("Le type de stage ou le stage n'a pas été trouvé.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur s'est produite : " + e.getMessage());
        }
    }
    @GetMapping("/typesStage")
    public ResponseEntity<List<TypeStage>> getAllTypesStage() {
        List<TypeStage> typesStage = typeStageRepository.findAll();
        return ResponseEntity.ok(typesStage);
    }
    @GetMapping("/typegetall/{codeStage}")
    public ResponseEntity<TypeStage> getTypeStageById(@PathVariable Long codeStage) {
        Optional<TypeStage> typeStageOptional = typeStageRepository.findById(codeStage);
        return typeStageOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/typesStage")
    public ResponseEntity<TypeStage> createTypeStage(@RequestBody TypeStage typeStage) {
        TypeStage savedTypeStage = typeStageRepository.save(typeStage);
        return ResponseEntity.ok(savedTypeStage);
    }
    @PutMapping("/typesStage/{codeStage}")
    public ResponseEntity<TypeStage> updateTypeStage(@PathVariable Long codeStage, @RequestBody TypeStage typeStage) {
        Optional<TypeStage> existingTypeStageOptional = typeStageRepository.findById(codeStage);

        if (existingTypeStageOptional.isPresent()) {
            TypeStage existingTypeStage = existingTypeStageOptional.get();
            // Mettre à jour les propriétés du type de stage avec celles reçues dans la requête
            existingTypeStage.setNbSemaine(typeStage.getNbSemaine());
            TypeStage updatedTypeStage = typeStageRepository.save(existingTypeStage);
            return ResponseEntity.ok(updatedTypeStage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/ttyp/{codeStage}")
    public ResponseEntity<Void> deleteTypeStage(@PathVariable Long codeStage) {
        Optional<TypeStage> typeStageOptional = typeStageRepository.findById(codeStage);

        if (typeStageOptional.isPresent()) {
            typeStageRepository.delete(typeStageOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/dates/{id}")
    public ResponseEntity<Date> getDateById(@PathVariable Long id) {
        Optional<Date> dateOptional = dateRepository.findById(id);
        return dateOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/dates")
    public ResponseEntity<Date> createDate(@RequestBody Date date) {
        Date savedDate = dateRepository.save(date);
        return ResponseEntity.ok(savedDate);
    }
    @PutMapping("/dates/{id}")
    public ResponseEntity<Date> updateDate(@PathVariable Long id, @RequestBody Date date) {
        Optional<Date> existingDateOptional = dateRepository.findById(id);

        if (existingDateOptional.isPresent()) {
            Date existingDate = existingDateOptional.get();
            // Mettre à jour les propriétés de la date avec celles reçues dans la requête
            existingDate.setAnnee(date.getAnnee());
            existingDate.setDateDebut(date.getDateDebut());
            existingDate.setDateFin(date.getDateFin());
            Date updatedDate = dateRepository.save(existingDate);
            return ResponseEntity.ok(updatedDate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/dates/{id}")
    public ResponseEntity<Void> deleteDate(@PathVariable Long id) {
        Optional<Date> dateOptional = dateRepository.findById(id);

        if (dateOptional.isPresent()) {
            dateRepository.delete(dateOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/assigner-typestage-a-date/{typeStageId}/{dateId}")
    public ResponseEntity<?> assignerTypeStageADate(@PathVariable Long typeStageId, @PathVariable Long dateId) {
        try {
            // Recherche du TypeStage par son ID
            Optional<TypeStage> typeStageOptional = typeStageRepository.findById(typeStageId);

            // Recherche de la Date par son ID
            Optional<Date> dateOptional = dateRepository.findById(dateId);

            // Vérification de l'existence des objets TypeStage et Date
            if (typeStageOptional.isPresent() && dateOptional.isPresent()) {
                TypeStage typeStage = typeStageOptional.get();
                Date date = dateOptional.get();

                // Assigner le TypeStage à la Date
                date.setTypeStage(typeStage);
                dateRepository.save(date);

                return ResponseEntity.ok("Le type de stage a été assigné à la date avec succès.");
            } else {
                return ResponseEntity.badRequest().body("Le type de stage ou la date n'a pas été trouvé(e).");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur s'est produite : " + e.getMessage());
        }
    }
    // POST endpoint to create a new Promo
    @PostMapping("/promos")
    public ResponseEntity<Promo> createPromo(@RequestBody Promo promo) {
        Promo savedPromo = promoRepository.save(promo);
        return ResponseEntity.ok(savedPromo);
    }

    // PUT endpoint to update an existing Promo
    @PutMapping("/promos/{anneePromo}")
    public ResponseEntity<Promo> updatePromo(@PathVariable String anneePromo, @RequestBody Promo promoDetails) {
        Optional<Promo> existingPromoOptional = promoRepository.findById(anneePromo);

        if (existingPromoOptional.isPresent()) {
            Promo existingPromo = existingPromoOptional.get();
            // Update properties of Promo
            existingPromo.setNoinscrits(promoDetails.getNoinscrits());
            existingPromo.setNorecu(promoDetails.getNorecu());
            existingPromo.setPid(promoDetails.getPid());
            // Add more updates if needed
            Promo updatedPromo = promoRepository.save(existingPromo);
            return ResponseEntity.ok(updatedPromo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/promos/{anneePromo}")
    public ResponseEntity<Void> deletePromo(@PathVariable String anneePromo) {
        Optional<Promo> promoOptional = promoRepository.findById(anneePromo);

        if (promoOptional.isPresent()) {
            promoRepository.delete(promoOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/promos/{anneePromo}")
    public ResponseEntity<Promo> getPromoById(@PathVariable String anneePromo) {
        Optional<Promo> promoOptional = promoRepository.findById(anneePromo);

        return promoOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/getAllPromo")
    public ResponseEntity<List<Promo>> getAllPromo() {
        List<Promo> allPromos = promoRepository.findAll();

        if (!allPromos.isEmpty()) {
            return ResponseEntity.ok(allPromos);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    @GetMapping("/etud")
    public ResponseEntity<List<Etudiantsauth>> getAlletudiant() {
        List<Etudiantsauth> etudiantsauths = etudiantsansAuthRepository.findAll();
        return ResponseEntity.ok(etudiantsauths);
    }
    @PostMapping("/assigner-professeur-a-promo/{promoAnnee}/{professeurId}")
    public ResponseEntity<?> assignerProfesseurAPromo(@PathVariable String promoAnnee, @PathVariable Long professeurId) {
        Optional<Promo> promoOptional = promoRepository.findById(promoAnnee);
        Optional<Professeursauth> professeurOptional = professeursansAuthRepository.findById(professeurId);

        if (promoOptional.isPresent() && professeurOptional.isPresent()) {
            Promo promo = promoOptional.get();
            Professeursauth professeursauth = professeurOptional.get();

            promo.setProfesseur(professeursauth);

            promoRepository.save(promo);

            return ResponseEntity.ok("Le professeur a été assigné à la promotion avec succès.");
        } else {
            return ResponseEntity.badRequest().body("La promotion ou le professeur n'a pas été trouvé(e).");
        }
    }

}