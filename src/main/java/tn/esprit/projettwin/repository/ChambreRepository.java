package tn.esprit.projettwin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.projettwin.Chambre;
import tn.esprit.projettwin.Reservation;
import tn.esprit.projettwin.TypeChambre;

import java.util.Date;
import java.util.List;

@Repository("ChambreRepo")
public interface ChambreRepository extends JpaRepository<Chambre,Long> {
    public List<Chambre> findByNumeroChambreIn(List<Long> numeroChambre);
    // Spring Data JPA comprend cette méthode et génère une requête SQL équivalente
    List<Chambre> findByBlocIdBlocAndTypeC(long idBloc, TypeChambre typeC);
    List<Chambre> findByBloc_Foyer_Universite_NomUniversite(String nomUniversite);
    @Query(value = "SELECT c.* " +
            "FROM T_chambre c " +
            "JOIN T_bloc b ON c.bloc_blc_id = b.blc_id " + // Jointure sur le bloc
            "JOIN T_foyer f ON b.foyer_fyr_id = f.fyr_id " + // Jointure sur le foyer via le bloc
            "JOIN T_universite u ON f.fyr_id = u.univ_id " + // Jointure sur l'université via le foyer
            "LEFT JOIN t_chambre_reservations cr ON c.ch_id = cr.chambre_ch_id " + // Jointure sur les réservations
            "WHERE u.univ_nom = :nomUniversite " +  // Filtrer par le nom de l'université
            "AND c.ch_typeC = :typeChambre " +  // Filtrer par le type de chambre
            "AND cr.chambre_ch_id IS NULL", nativeQuery = true)
    List<Chambre> findChambresNonReserveesParUniversiteEtTypeChambre(
            @Param("nomUniversite") String nomUniversite,
            @Param("typeChambre") TypeChambre typeChambre);
}
