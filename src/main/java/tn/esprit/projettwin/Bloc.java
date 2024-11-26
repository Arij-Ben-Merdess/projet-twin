package tn.esprit.projettwin;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Table(name="T_bloc")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Bloc {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Column(name = "blc_id")
    private Long idBloc;

    @ToString.Exclude
    @Column(name = "blc_nom")
    private String nomBloc;

    @Column(name = "blc_capacite")
    private Long capaciteBloc;

    @ManyToOne
    private Foyer foyer;

    @OneToMany(cascade =  CascadeType.ALL, mappedBy = "bloc")
    private Set<Chambre> chambres;

 





}
