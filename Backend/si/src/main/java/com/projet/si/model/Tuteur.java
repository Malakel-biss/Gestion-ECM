package com.projet.si.model;
import jakarta.persistence.*;
@Entity
@Table(name = "tuteur")
public class Tuteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tuteur")
    private Long idTuteur;

    @Column(name = "qualite")
    private String qualite;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "telephone")
    private String telephone;
    @Column(name = "idEntreprise")
    private Long idEntreprise;

    public Tuteur() {
    }

    public Tuteur(String qualite, String nom, String prenom, String telephone, Long idEntreprise) {
        this.qualite = qualite;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.idEntreprise = idEntreprise;
    }

    public Long getIdTuteur() {
        return idTuteur;
    }

    public void setIdTuteur(Long idTuteur) {
        this.idTuteur = idTuteur;
    }

    public String getQualite() {
        return qualite;
    }

    public void setQualite(String qualite) {
        this.qualite = qualite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Long getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(Long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }
}

