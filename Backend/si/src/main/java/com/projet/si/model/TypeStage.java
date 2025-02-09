package com.projet.si.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "type_stage")
public class TypeStage {

    public TypeStage(Long codeStage, Integer nbSemaine) {
        this.codeStage = codeStage;
        this.nbSemaine = nbSemaine;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codeStage")
    private Long codeStage;

    @Column(name = "nb_semaine")
    private Integer nbSemaine;

    public TypeStage() {
    }

    public Long getCodeStage() {
        return codeStage;
    }

    public void setCodeStage(Long codeStage) {
        this.codeStage = codeStage;
    }

    public Integer getNbSemaine() {
        return nbSemaine;
    }

    public void setNbSemaine(Integer nbSemaine) {
        this.nbSemaine = nbSemaine;
    }

    public TypeStage(Integer nbSemaine) {
        this.nbSemaine = nbSemaine;
    }


}
