package tn.esprit.projettwin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.projettwin.Etudiant;
import tn.esprit.projettwin.Reservation;

import java.util.Date;
import java.util.List;

@Repository("ReservationRepo")
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    @Query("SELECT r FROM Chambre c JOIN c.reservations r WHERE c.numeroChambre > 10")
    List<Reservation> findReservationsByChambreNumGreaterThan();
    @Query(value = "SELECT r.* FROM T_reservation r " +
            "JOIN T_chambre_reservations cr ON r.res_id = cr.reservations_res_id " +
            "JOIN T_Chambre c ON cr.chambre_ch_id = c.ch_id " +
            "JOIN T_Bloc b ON c.bloc_blc_id = b.blc_id " +
            "JOIN T_Foyer f ON b.foyer_fyr_id = f.fyr_id " +
            "JOIN T_Universite u ON f.fyr_id = u.univ_id " +
            "WHERE r.res_annee = :anneeUniversitaire AND u.univ_nom = :nomUniversite",
            nativeQuery = true)
    List<Reservation> findReservationByAnneeUniversitaireAndNomUniversite(@Param("anneeUniversitaire") Date anneeUniversitaire,
                                                                          @Param("nomUniversite") String nomUniversite);

}
