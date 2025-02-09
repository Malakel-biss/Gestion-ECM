package com.projet.si.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "date")
public class Date {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iddate;


    @Column(name = "codestage")
    private Long codestage;

   @Column(name = "annee")
    private String annee;

    @Column(name = "date_debut")
    private java.time.LocalDate dateDebut;

    @Column(name = "date_fin")
    private java.time.LocalDate dateFin;

    public Date() {
    }

    public Date(Long code_stage, String annee, java.time.LocalDate dateDebut, java.time.LocalDate dateFin) {
        this.codestage = code_stage;
        this.annee=annee;
        this.dateFin=dateFin;
        this.dateDebut=dateDebut;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getAnnee() {
        return annee;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Long getIddate() {
        return iddate;
    }

    public void setIddate(Long iddate) {
        this.iddate = iddate;
    }

    public Long getCodestage() {
        return codestage;
    }

    public void setCodestage(Long codestage) {
        this.codestage = codestage;
    }
    public void setTypeStage(TypeStage typeStage) {
        this.codestage=typeStage.getCodeStage();

    }
}
