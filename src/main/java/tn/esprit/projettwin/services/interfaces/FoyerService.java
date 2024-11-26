package tn.esprit.projettwin.services.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tn.esprit.projettwin.Chambre;
import tn.esprit.projettwin.Foyer;
import tn.esprit.projettwin.repository.EtudiantRepository;
import tn.esprit.projettwin.repository.FoyerRepository;

import java.util.List;


public interface FoyerService {
    public List<Foyer> retrieveAllFoyers();
    public Foyer retrieveFoyer(Long foyerId);
    public Foyer addFoyer(Foyer f);
    public void removeFoyer(Long foyerId);
    public Foyer modifyFoyer(Foyer foyer);

   // public Foyer ajouterFoyerEtAffecterUniversite(Foyer foyer, long idUniversite);
}
