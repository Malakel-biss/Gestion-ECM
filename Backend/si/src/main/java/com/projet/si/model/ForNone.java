package com.projet.si.model;
import jakarta.persistence.*;


public class ForNone {
    private Long idStage;

    private String anneestage;


    private String compteRendu;


    private Long idEtudiant;


    private Long idEntreprise;


    private Long idTuteur;


    private Long pid;


    private String anneePromo;


    private Long codeStage;

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

    public ForNone() {
    }

    public ForNone(Stage stage) {
        this.anneestage = stage.getAnneestage();
        this.compteRendu = stage.getCompteRendu();
        this.idEtudiant = stage.getIdEtudiant();
        this.idEntreprise = stage.getIdEntreprise();
        this.idTuteur = stage.getIdTuteur();
        this.pid = stage.getPid();
        this.anneePromo = stage.getAnneePromo();
        this.codeStage = stage.getCodeStage();
        this.nomEntreprise = "Techs";
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