package com.projet.si.model;

import jakarta.persistence.*;

@Entity
@Table(name = "entreprise")
public class Entreprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEntreprise")
    private Long idEntreprise;
    @Column(name = "nomEntreprise")

    private String nomEntreprise;



    @Column(name = "raison_sociale")
    private String raisonSociale;

    @Column(name = "forme_juridique")
    private String formeJuridique;

    @Column(name = "adresse_entreprise")
    private String adresseentreprise;

    @Column(name = "code_postal_entreprise")
    private String codePostalentreprise;

    @Column(name = "ville_entreprise")
    private String villeentreprise;

    @Column(name = "telephone_entreprise")
    private String telephoneentreprise;

    @Column(name = "contact_entreprise")
    private String contactentreprise;
    @Column(name = "fax")
    private String fax;

    public Entreprise() {
    }

    public Entreprise(Long idEntreprise, String adresse_entreprise, String raisonSociale, String formeJuridique, String codePostal_entreprise, String ville_entreprise, String telephone_entreprise, String contact_entreprise, String fax) {

        this.idEntreprise=idEntreprise;
        this.adresseentreprise=adresse_entreprise;
        this.raisonSociale=raisonSociale;
        this.formeJuridique=formeJuridique;
        this.codePostalentreprise=codePostal_entreprise;
        this.contactentreprise=contact_entreprise;
        this.fax=fax;
        this.villeentreprise=ville_entreprise;
    }

    public String getVille_entreprise() {
        return villeentreprise;
    }

    public void setVille_entreprise(String ville_entreprise) {
        this.villeentreprise = ville_entreprise;
    }

    public String getTelephone_entreprise() {
        return telephoneentreprise;
    }

    public void setTelephone_entreprise(String telephone_entreprise) {
        this.telephoneentreprise = telephone_entreprise;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public Long getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(Long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public String getFormeJuridique() {
        return formeJuridique;
    }

    public void setFormeJuridique(String formeJuridique) {
        this.formeJuridique = formeJuridique;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getContactentreprise() {
        return contactentreprise;
    }

    public void setContactentreprise(String contact_entreprise) {
        this.contactentreprise = contact_entreprise;
    }

    public String getCodePostalentreprise() {
        return codePostalentreprise;
    }

    public void setCodePostalentreprise(String codePostal_entreprise) {
        this.codePostalentreprise = codePostal_entreprise;
    }

    public String getAdresseentreprise() {
        return adresseentreprise;
    }

    public void setAdresseentreprise(String adresse_entreprise) {
        this.adresseentreprise = adresse_entreprise;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }
}

