package com.projet.si.model;
import jakarta.persistence.*;
@Entity
@Table(name = "stage")
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStage;
    @Column(name = "annee_stage")
    private String anneestage;

    @Column(name = "compte_rendu")
    private String compteRendu;

    @Column(name = "idEtudiant")
    private Long idEtudiant;

    @Column(name = "idEntreprise")
    private Long idEntreprise;

    @Column(name = "idTuteur")
    private Long idTuteur;

    @Column(name = "p_id")
    private Long pid;

    @Column(name = "anneePromo")
    private String anneePromo;

    @Column(name = "codestage")
    private Long codeStage;
    @Column(name = "mention")
    private String mention;

    public String getMention() {
        return mention;
    }

    public void setMention(String mention) {
        this.mention = mention;
    }

    public Long getCodeStage() {
        return codeStage;
    }

    public void setCodeStage(Long codeStage) {
        this.codeStage = codeStage;
    }

    public Stage() {
    }

    public Stage(String annee_stage, String compteRendu, Long idEtudiant, Long idEntreprise, Long idTuteur, Long p_id, String anneePromo, Long codeStage) {
        this.anneestage = annee_stage;
        this.compteRendu = compteRendu;
        this.idEtudiant = idEtudiant;
        this.idEntreprise = idEntreprise;
        this.idTuteur = idTuteur;
        this.pid = p_id;
        this.anneePromo = anneePromo;
        this.codeStage = codeStage;
    }

    public Long getIdStage() {
        return idStage;
    }

    public void setIdStage(Long idStage) {
        this.idStage = idStage;
    }

    public String getAnneestage() {
        return anneestage;
    }

    public void setAnneestage(String anneestage) {
        this.anneestage = anneestage;
    }

    public String getCompteRendu() {
        return compteRendu;
    }

    public void setCompteRendu(String compteRendu) {
        this.compteRendu = compteRendu;
    }

    public Long getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(Long idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public Long getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(Long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public Long getIdTuteur() {
        return idTuteur;
    }

    public void setIdTuteur(Long idTuteur) {
        this.idTuteur = idTuteur;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getAnneePromo() {
        return anneePromo;
    }

    public void setAnneePromo(String anneePromo) {
        this.anneePromo = anneePromo;
    }

    public void setProfesseur(Professeursauth professeur) {
        this.pid = professeur.getPid();
    }
    public void setEtudiant(Etudiantsauth etudiant) {
        this.idEtudiant = etudiant.getIdEtudiant();
    }

    public void setTypeStage(TypeStage typeStage) {
        this.codeStage=typeStage.getCodeStage();

    }
    public void setEntreprise(Entreprise entreprise) {
        this.idEntreprise=entreprise.getIdEntreprise();
    }

    public void setTuteur(Tuteur tuteur) {
        this.idTuteur=tuteur.getIdTuteur();
    }
    @Transient // Marquez ces champs comme transient pour éviter qu'ils soient persistés en base de données
    private String nomEtudiant;

    @Transient
    private String nomTuteur;

    @Transient
    private String nomProfesseur;

    @Transient
    private String nomEntreprise;
    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    public void setNomTuteur(String nomTuteur) {
        this.nomTuteur = nomTuteur;
    }

    public void setNomProfesseur(String nomProfesseur) {
        this.nomProfesseur = nomProfesseur;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public String getNomEtudiant() {
        return nomEtudiant;
    }

    public String getNomTuteur() {
        return nomTuteur;
    }

    public String getNomProfesseur() {
        return nomProfesseur;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

}