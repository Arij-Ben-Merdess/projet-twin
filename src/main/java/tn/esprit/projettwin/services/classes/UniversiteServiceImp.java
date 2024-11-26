package tn.esprit.projettwin.services.classes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.projettwin.Foyer;
import tn.esprit.projettwin.Universite;
import tn.esprit.projettwin.repository.FoyerRepository;
import tn.esprit.projettwin.repository.UniversiteRepository;
import tn.esprit.projettwin.services.interfaces.UniversiteService;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImp implements UniversiteService {
    // Déclaration du repository pour l'université
    private UniversiteRepository universiteRepository;
    private FoyerRepository foyerRepository;

    // Récupérer toutes les universités
    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepository.findAll();
    }

    // Récupérer une université par son ID
    @Override
    public Universite retrieveUniversite(Long universiteId) {
        return universiteRepository.findById(universiteId).orElse(null);  // Retourne null si l'université n'existe pas
    }

    // Ajouter une nouvelle université
    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    // Supprimer une université par son ID
    @Override
    public void removeUniversite(Long universiteId) {
        universiteRepository.deleteById(universiteId);
    }

    // Modifier une université existante
    @Override
    public Universite modifyUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite){
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);
        Foyer foyer = foyerRepository.findById(idFoyer).get();

        universite.setFoyer(foyer);
        foyer.setUniversite(universite);

        universiteRepository.save(universite);
        foyerRepository.save(foyer);
        return universite;

    }
    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite){

        Universite universite = universiteRepository.findById(idUniversite).get();
        Foyer foyer = universite.getFoyer();

        if(foyer!=null){
            foyer.setUniversite(null);
            foyerRepository.save(foyer);
        }

        universite.setFoyer(null);
        return universiteRepository.save(universite);

    }

}
