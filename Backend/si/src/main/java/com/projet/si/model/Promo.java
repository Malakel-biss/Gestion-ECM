package com.projet.si.model;

import jakarta.persistence.*;

@Entity
@Table(name = "promo")
public class Promo {
    @Id
    @Column(name = "anneePromo")
    private String anneePromo;
    @Column(name = "no_inscrits")
    private Long noinscrits;
    @Column(name = "no_recu")
    private Long norecu;

    @Column (name = "p_id")
    private Long pid;

    public Promo() {
    }

    public Promo(String anneePromo, Long no_inscrits, Long no_recu, Long p_id) {
        this.anneePromo = anneePromo;
        this.noinscrits = no_inscrits;
        this.norecu = no_recu;
        this.pid = p_id;
    }

    public String getAnneePromo() {
        return anneePromo;
    }

    public void setAnneePromo(String anneePromo) {
        this.anneePromo = anneePromo;
    }

    public Long getNoinscrits() {
        return noinscrits;
    }

    public void setNoinscrits(Long noinscrits) {
        this.noinscrits = noinscrits;
    }

    public Long getNorecu() {
        return norecu;
    }

    public void setNorecu(Long norecu) {
        this.norecu = norecu;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
    public void setProfesseur(Professeursauth professeur) {
        this.pid = professeur.getPid();
    }
}
