package tn.esprit.projettwin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projettwin.Foyer;
import tn.esprit.projettwin.Universite;

@Repository("FoyerRepo")
public interface FoyerRepository extends JpaRepository<Foyer,Long> {
    Foyer findByUniversite(Universite universite);
}
