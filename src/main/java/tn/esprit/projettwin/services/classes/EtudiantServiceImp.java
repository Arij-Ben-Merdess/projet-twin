package tn.esprit.projettwin.services.classes;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import tn.esprit.projettwin.Etudiant;
import tn.esprit.projettwin.repository.EtudiantRepository;
import tn.esprit.projettwin.services.interfaces.EtudiantService;

import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantServiceImp implements EtudiantService {
    private EtudiantRepository etudiantRepository;

    public List<Etudiant> retrieveAllEtudiants(){
        return etudiantRepository.findAll();
    }

    public Etudiant retrieveEtudiant(Long etudiantId){
        return etudiantRepository.findById(etudiantId).get();
    }
    public Etudiant addEtudiant(Etudiant e){
        return etudiantRepository.save(e);
    }
    public void removeEtudiant(Long etudiantId){
        etudiantRepository.deleteById(etudiantId);
    }
    public Etudiant modifyEtudiant(Etudiant e){
        return etudiantRepository.save(e);

    }
}
