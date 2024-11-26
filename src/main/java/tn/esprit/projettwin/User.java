package tn.esprit.projettwin;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;

@Entity // une table dans la bdd
@Table(name="T_etudiant") // plusieur présentation de la table 
public class User {

    @Getter
    @Id
    @GeneratedValue
    private Long id;
    @Getter
    @Column(name = "etd_nom")
    private String nom;
    @Getter
    @Column(name = "etd_prenom")
    private String prenom;

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

}
