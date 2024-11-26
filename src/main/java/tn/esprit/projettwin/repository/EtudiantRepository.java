package tn.esprit.projettwin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projettwin.Etudiant;
import tn.esprit.projettwin.Universite;

@Repository("EtudiantRepo")
public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    Etudiant findByCin(long cin);

}
