package tn.esprit.projettwin;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name="T_chambre")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Chambre {


    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Column(name = "ch_id")
    private Long idChambre;

    @Column(name = "ch_num")
    private Long numeroChambre;

    @Column(name = "ch_typeC")
    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;

    @ManyToOne
    private Bloc bloc;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations;


}
