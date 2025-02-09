package com.projet.si.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "annee")
public class Annee {

    @Id
    @Column(name = "annee")
    private String annee;

    public Annee() {
    }

    public Annee(String annee) {
        this.annee = annee;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }


}

