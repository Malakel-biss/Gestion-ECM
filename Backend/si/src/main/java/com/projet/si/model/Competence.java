package com.projet.si.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "competences")
public class Competence {
    @Id
    @Column(name = "code_competence")
    private String codeCompetence;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "description")
    private String description;

    public Competence() {
    }

    public Competence(String codeCompetence, String libelle, String description) {
        this.codeCompetence = codeCompetence;
        this.libelle=libelle;
        this.description=description;
    }

    public String getCodeCompetence() {
        return codeCompetence;
    }

    public void setCodeCompetence(String codeCompetence) {
        this.codeCompetence = codeCompetence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}



