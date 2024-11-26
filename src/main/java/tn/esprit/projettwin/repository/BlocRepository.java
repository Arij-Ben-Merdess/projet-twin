package tn.esprit.projettwin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.projettwin.Bloc;

import java.util.List;

@Repository("BlocRepo")
public interface BlocRepository extends JpaRepository<Bloc,Long> {
    @Query("SELECT b FROM Bloc b WHERE b.foyer.universite.nomUniversite = :nomUniversite")
    List<Bloc> findBlocByUniversiteName(@Param("nomUniversite") String nomUniversite);
}
