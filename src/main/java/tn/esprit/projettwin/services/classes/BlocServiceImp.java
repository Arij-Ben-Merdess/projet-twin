package tn.esprit.projettwin.services.classes;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tn.esprit.projettwin.Bloc;
import tn.esprit.projettwin.Chambre;
import tn.esprit.projettwin.repository.BlocRepository;
import tn.esprit.projettwin.repository.ChambreRepository;
import tn.esprit.projettwin.services.interfaces.BlocService;

import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
public class BlocServiceImp implements BlocService {
   private BlocRepository blocRepository;
   private ChambreRepository chambreRepository;

    public List<Bloc> retrieveAllBlocs() {
        return blocRepository.findAll();
    }


    public Bloc retrieveBloc(Long BlocId){
        return blocRepository.findById(BlocId).get();
    }

    @Override
    public Bloc addBloc(Bloc b){
        return blocRepository.save(b);
    }

    public void removeBloc(Long BlocId){
        blocRepository.deleteById(BlocId);
    }

   /* public String delete(Long id) {
        if(blocRepo.existsById(id)){
            blocRepo.deleteById(id);
            return "Supprimé";
        }
        else return "n'existe pas";
    }*/
        public Bloc modifyBloc(Bloc bloc){
            return blocRepository.save(bloc);
        }

        @Override
    public List<Bloc> getBlocByUniversiteName(String nomUniversite) {
        return blocRepository.findBlocByUniversiteName(nomUniversite);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre,Long idBloc){
            Bloc bloc = blocRepository.findById(idBloc).get();
            List<Chambre> chambres = chambreRepository.findByNumeroChambreIn(numChambre);

            for(Chambre chambre : chambres){
                chambre.setBloc(bloc);
            }
        // Sauvegarder les chambres
        chambreRepository.saveAll(chambres);
        return bloc;
    }
}
