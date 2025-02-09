package com.projet.si.model;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_admin")
    private Long idadmin;
    @Column(name = "id_user", nullable = false)
    private Long idUser;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;
    @Column(name = "email", nullable = false)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrenom() {
        return prenom;
    }

    public Long getIdUser() {
        return idUser;
    }

    public Long getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(Long idadmin) {
        this.idadmin = idadmin;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setUser(User user) {
        this.idUser = user.getId();
    }

}
