package com.projet.si.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
public class EtudiantXXXXXX {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idEtudiant;

    @NotNull
    private String nometudiant;

    private String annee_promo;
    public String getAnnee_promo() {
        return annee_promo;
    }
    public void setAnnee_promo(String annee_promo) {
        this.annee_promo = annee_promo;
    }

    @NotNull
    private String prenometudiant;


    private String adresseetudiant;


    private String codePostaletudiant;


    private String villeetudiant;


    private String sexetudiant;



    private Date dateNaissanceetudiant;


    private String emailetudiant;


    private String telephoneetudiant;

    private String equalite;

    private String esuite;

    private String mention;

    public EtudiantXXXXXX() {
    }

    public EtudiantXXXXXX(String annee_promo, String nom_etudiant, String prenom_etudiant, String adresse_etudiant, String codePostal_etudiant, String ville_etudiant, String sex_etudiant, Date dateNaissance_etudiant, String email_etudiant, String telephone_etudiant, String e_qualite, String e_suite, String mention) {
        this.nometudiant=nom_etudiant;
        this.prenometudiant=prenom_etudiant;
        this.adresseetudiant=adresse_etudiant;
        this.codePostaletudiant=codePostal_etudiant;
        this.villeetudiant=ville_etudiant;
        this.sexetudiant=sex_etudiant;
        this.emailetudiant=email_etudiant;
        this.dateNaissanceetudiant=dateNaissance_etudiant;
        this.telephoneetudiant=telephone_etudiant;
        this.equalite=e_qualite;
        this.esuite=e_suite;
        this.mention=mention;
        this.annee_promo=annee_promo;
    }

    public Long getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(Long idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getNometudiant() {
        return nometudiant;
    }

    public void setNometudiant(String nometudiant) {
        this.nometudiant = nometudiant;
    }

    public String getPrenometudiant() {
        return prenometudiant;
    }

    public void setPrenometudiant(String prenometudiant) {
        this.prenometudiant = prenometudiant;
    }

    public String getAdresseetudiant() {
        return adresseetudiant;
    }

    public void setAdresseetudiant(String adresseetudiant) {
        this.adresseetudiant = adresseetudiant;
    }

    public String getCodePostaletudiant() {
        return codePostaletudiant;
    }

    public void setCodePostaletudiant(String codePostaletudiant) {
        this.codePostaletudiant = codePostaletudiant;
    }

    public String getVilleetudiant() {
        return villeetudiant;
    }

    public void setVilleetudiant(String villeetudiant) {
        this.villeetudiant = villeetudiant;
    }

    public String getSexetudiant() {
        return sexetudiant;
    }

    public void setSexetudiant(String sexetudiant) {
        this.sexetudiant = sexetudiant;
    }

    public Date getDateNaissanceetudiant() {
        return dateNaissanceetudiant;
    }

    public void setDateNaissanceetudiant(Date dateNaissanceetudiant) {
        this.dateNaissanceetudiant = dateNaissanceetudiant;
    }

    public String getEmailetudiant() {
        return emailetudiant;
    }

    public void setEmailetudiant(String emailetudiant) {
        this.emailetudiant = emailetudiant;
    }

    public String getTelephoneetudiant() {
        return telephoneetudiant;
    }

    public void setTelephoneetudiant(String telephoneetudiant) {
        this.telephoneetudiant = telephoneetudiant;
    }

    public String getEqualite() {
        return equalite;
    }

    public void setEqualite(String equalite) {
        this.equalite = equalite;
    }

    public String getEsuite() {
        return esuite;
    }

    public void setEsuite(String esuite) {
        this.esuite = esuite;
    }

    public String getMention() {
        return mention;
    }

    public void setMention(String mention) {
        this.mention = mention;
    }
}