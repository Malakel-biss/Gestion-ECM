package com.projet.si.payload.request;

import com.projet.si.model.ERole;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.*;

import java.util.Date;

public class SignupRequest {
    @NotBlank
    @Size(max = 50)
    @Email
    private String nom;
    private Date dateNaissance;
    private String adresse;
    private String prenom;
    private String anneepromo;
    private String codePostal;
    private String ville;
    private String sex;
    private String telephone;
    private String telephoneecole;

    private String qualite;

    private String suite;

    private String mention;
    private String email;
    private ERole role;
    private Date dateembauche;
    private Date datedepart;

    public String getAnneepromo() {
        return anneepromo;
    }

    public void setAnneepromo(String anneepromo) {
        this.anneepromo = anneepromo;
    }

    public String getQualite() {
        return qualite;
    }

    public void setQualite(String qualite) {
        this.qualite = qualite;
    }

    public String getSuite() {
        return suite;
    }

    public String getTelephoneecole() {
        return telephoneecole;
    }

    public void setTelephoneecole(String telephoneecole) {
        this.telephoneecole = telephoneecole;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getMention() {
        return mention;
    }

    public void setMention(String mention) {
        this.mention = mention;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }



    public String getE_Mention() {
        return mention;
    }

    public void setE_Mention(String mention) {
        this.mention = mention;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public Date getDateembauche() {
        return dateembauche;
    }

    public void setDateembauche(Date dateembauche) {
        this.dateembauche = dateembauche;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getDatedepart() {
        return datedepart;
    }

    public void setDatedepart(Date datedepart) {
        this.datedepart = datedepart;
    }


    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }
}
