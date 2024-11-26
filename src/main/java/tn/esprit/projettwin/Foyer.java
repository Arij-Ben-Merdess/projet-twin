package tn.esprit.projettwin;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="T_foyer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Foyer {

    @Setter(AccessLevel.NONE)
    // @ToString.Exclude
    //@EqualsAndHashCode.Exclude
    @Column(name = "fyr_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;

    @ToString.Exclude
    @Column(name = "fyr_nom")
    private String nomFoyer;

    @Column(name = "fyr_capacite")
    private Long capaciteFoyer;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "foyer")
    @JsonBackReference
    private Universite universite;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "foyer")
    private Set<Bloc> ListBloc;




}

