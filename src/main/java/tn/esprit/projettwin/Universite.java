package tn.esprit.projettwin;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="T_universite")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Universite {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Column(name = "univ_id")
    private Long idUniversite;

    @ToString.Exclude
    @Column(name = "univ_nom")
    private String nomUniversite;

    @Column(name = "univ_adresse")
    private String adresse;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Foyer foyer;




}
