package tn.esprit.projettwin;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="T_etudiants")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Etudiant {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Column(name="et_id")
     Long idEtudiant;

    @ToString.Exclude
    @Column(name="Et_nom")
    protected String nomEt;

    @Column(name="Et_prenom")
     String prenomEt;

    @Column(name="Et_cin")
     long cin;

    @Column(name="Et_ecole")
     String ecole;

    @Column(name="Et_date")
     Date dateNaissance;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "etudiants")
    private Set<Reservation> reservations;





}
