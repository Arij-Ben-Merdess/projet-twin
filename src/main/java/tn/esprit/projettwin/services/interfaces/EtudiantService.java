package tn.esprit.projettwin.services.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tn.esprit.projettwin.Chambre;
import tn.esprit.projettwin.Etudiant;
import tn.esprit.projettwin.repository.ChambreRepository;
import tn.esprit.projettwin.repository.EtudiantRepository;

import java.util.List;


public interface EtudiantService {
    public List<Etudiant> retrieveAllEtudiants();
    public Etudiant retrieveEtudiant(Long etudiantId);
    public Etudiant addEtudiant(Etudiant e);
    public void removeEtudiant(Long etudiantId);
    public Etudiant modifyEtudiant(Etudiant etudiant);

}
