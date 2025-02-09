package com.projet.si.model;

import jakarta.persistence.*;
@Entity
@Table(name = "acquerir")


public class Acquerir{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long acid;

    @Column(name = "code_competence")
    private String codeCompetence;


    @Column(name = "code_stage")
    private String codeStage;

    @Column(name = "niveau_exige")
    private String niveauExige;


    public Acquerir() {
    }

    public Acquerir(String codeCompetence, String codeStage, String niveauExige) {
        this.codeStage=codeStage;
        this.codeCompetence = codeCompetence;
        this.niveauExige=niveauExige;
    }

    public String getNiveauExige() {
        return niveauExige;
    }

    public void setNiveauExige(String niveauExige) {
        this.niveauExige = niveauExige;
    }

    public String getCodeStage() {
        return codeStage;
    }

    public void setCodeStage(String codeStage) {
        this.codeStage = codeStage;
    }

    public String getCodeCompetence() {
        return codeCompetence;
    }

    public void setCodeCompetence(String codeCompetence) {
        this.codeCompetence = codeCompetence;
    }

    public Long getAcid() {
        return acid;
    }

    public void setAcid(Long ac_id) {
        this.acid = ac_id;
    }
}
