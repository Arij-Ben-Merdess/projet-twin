package tn.esprit.projettwin.services.classes;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tn.esprit.projettwin.Bloc;
import tn.esprit.projettwin.Chambre;
import tn.esprit.projettwin.Foyer;
import tn.esprit.projettwin.Universite;
import tn.esprit.projettwin.repository.BlocRepository;
import tn.esprit.projettwin.repository.FoyerRepository;
import tn.esprit.projettwin.repository.UniversiteRepository;
import tn.esprit.projettwin.services.interfaces.FoyerService;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements FoyerService {
    private FoyerRepository foyerRepository;
    UniversiteRepository universiteRepository;
    BlocRepository blocRepository;
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepository.findAll();
    }
    public Foyer retrieveFoyer(Long foyerId) {
        return foyerRepository.findById(foyerId).get();
    }
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }
    public void removeFoyer(Long foyerId) {
        foyerRepository.deleteById(foyerId);
    }
    public Foyer modifyFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

   /* @Override
    public Foyer ajouterFoyerEtAffecterUniversite(Foyer foyer, long idUniversite){

        // Recuperer l'universite à affecter selon l'id
        Universite universite = universiteRepository.findById(idUniversite).get();
        System.out.println("id universite" + universite.getIdUniversite()+ universite.getNomUniversite());
        // Assigner le foyer à l'université
        universite.setFoyer(foyer);
        foyer.setUniversite(universite);
        universiteRepository.save(universite);

       // Set<Bloc> blocs = foyer.getListBloc();
       //  Enregistrer les blocs associés au foyer

        for(Bloc bloc : foyer.getListBloc()) {
            if(bloc.getIdBloc()!= null){
                bloc.setFoyer(foyer);  // Assigner le foyer au bloc        }
                blocRepository.save(bloc);  // Enregistrer le bloc

            }
        }

        foyerRepository.save(foyer);

        return foyer;
    }*/
}
