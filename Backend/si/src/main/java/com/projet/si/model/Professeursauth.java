package com.projet.si.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Professeursauth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;
    private String pnom;
    private String pprenom;
    private String padresse;
    private String pcodePostal;
    private String pville;
    private String psuite;
    private String pqualite;

    private Date pdatenaissance;
    private Date dateembauche;
    private Date datedepart;

    private String ptelephonedomicile;
    private String ptelephoneecole;


    public Professeursauth() {
    }

    public Professeursauth(String p_nom, String p_prenom, String p_adresse, String p_codePostal, String p_ville, String p_suite, String p_qualite, Date p_datenaissance, Date date_embauche, Date date_depart, String p_telephone_domicile, String p_telephone_ecole) {
        this.pnom = p_nom;
        this.pprenom = p_prenom;
        this.padresse = p_adresse;
        this.pcodePostal = p_codePostal;
        this.pville = p_ville;
        this.psuite = p_suite;
        this.pqualite = p_qualite;
        this.pdatenaissance = p_datenaissance;
        this.dateembauche = date_embauche;
        this.datedepart = date_depart;
        this.ptelephonedomicile = p_telephone_domicile;
        this.ptelephoneecole = p_telephone_ecole;
    }

    public Professeursauth(Long p_id, String p_nom, String p_prenom, String p_adresse, String p_codePostal, String p_ville, String p_suite, String p_qualite, Date p_datenaissance, Date date_embauche, Date date_depart, String p_telephone_domicile, String p_telephone_ecole) {
        this.pid = p_id;
        this.pnom = p_nom;
        this.pprenom = p_prenom;
        this.padresse = p_adresse;
        this.pcodePostal = p_codePostal;
        this.pville = p_ville;
        this.psuite = p_suite;
        this.pqualite = p_qualite;
        this.pdatenaissance = p_datenaissance;
        this.dateembauche = date_embauche;
        this.datedepart = date_depart;
        this.ptelephonedomicile = p_telephone_domicile;
        this.ptelephoneecole = p_telephone_ecole;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPnom() {
        return pnom;
    }

    public void setPnom(String pnom) {
        this.pnom = pnom;
    }

    public String getPprenom() {
        return pprenom;
    }

    public void setPprenom(String pprenom) {
        this.pprenom = pprenom;
    }

    public String getPadresse() {
        return padresse;
    }

    public void setPadresse(String padresse) {
        this.padresse = padresse;
    }

    public String getPcodePostal() {
        return pcodePostal;
    }

    public void setPcodePostal(String pcodePostal) {
        this.pcodePostal = pcodePostal;
    }

    public String getPville() {
        return pville;
    }

    public void setPville(String pville) {
        this.pville = pville;
    }

    public String getPsuite() {
        return psuite;
    }

    public void setPsuite(String psuite) {
        this.psuite = psuite;
    }

    public String getPqualite() {
        return pqualite;
    }

    public void setPqualite(String pqualite) {
        this.pqualite = pqualite;
    }

    public Date getPdatenaissance() {
        return pdatenaissance;
    }

    public void setPdatenaissance(Date pdatenaissance) {
        this.pdatenaissance = pdatenaissance;
    }

    public Date getDateembauche() {
        return dateembauche;
    }

    public void setDateembauche(Date dateembauche) {
        this.dateembauche = dateembauche;
    }

    public Date getDatedepart() {
        return datedepart;
    }

    public void setDatedepart(Date datedepart) {
        this.datedepart = datedepart;
    }

    public String getPtelephonedomicile() {
        return ptelephonedomicile;
    }

    public void setPtelephonedomicile(String ptelephonedomicile) {
        this.ptelephonedomicile = ptelephonedomicile;
    }

    public String getPtelephoneecole() {
        return ptelephoneecole;
    }

    public void setPtelephoneecole(String ptelephoneecole) {
        this.ptelephoneecole = ptelephoneecole;
    }

}
