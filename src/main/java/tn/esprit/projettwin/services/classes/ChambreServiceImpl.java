package tn.esprit.projettwin.services.classes;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.projettwin.*;
import tn.esprit.projettwin.repository.BlocRepository;
import tn.esprit.projettwin.repository.ChambreRepository;
import tn.esprit.projettwin.repository.FoyerRepository;
import tn.esprit.projettwin.repository.UniversiteRepository;
import tn.esprit.projettwin.services.interfaces.ChambreService;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class ChambreServiceImpl implements ChambreService {


    ChambreRepository chambreRepository;
    UniversiteRepository universiteRepository;
    FoyerRepository foyerRepository;
    BlocRepository blocRepository;
    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }
    public Chambre retrieveChambre(Long chambreId) {
        return chambreRepository.findById(chambreId).get();
    }
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }
    public void removeChambre(Long chambreId) {
        chambreRepository.deleteById(chambreId);
    }
    public Chambre modifyChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
       return chambreRepository.findByBlocIdBlocAndTypeC(idBloc,typeC);
    }
    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite){

        return chambreRepository.findByBloc_Foyer_Universite_NomUniversite(nomUniversite);

    }
    public List<Chambre> getChambresNonReserveesParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre typeChambre) {
        return chambreRepository.findChambresNonReserveesParUniversiteEtTypeChambre(nomUniversite, typeChambre);
    }
    @Scheduled(cron = "0 * * * * *") // S'exécute toutes les minutes
    @Override
    public void getChambresParBloc(){
        List<Bloc> blocs = blocRepository.findAll();
        for(Bloc b : blocs) {
            log.info("Bloc {} ayant une capacite {}", b.getNomBloc(), b.getCapaciteBloc());
            if (b.getChambres().isEmpty()) {
                log.info("Pas de chambres disponibles dans ce bloc");
            } else {
                for (Chambre chambre : b.getChambres()) {
                    log.info("Chamber Num : {} type : {} ", chambre.getNumeroChambre(), chambre.getTypeC());
                }    //@Scheduled(fixedRate = 300000): Cette annotation indique que la méthode pourcentageChambreParType() doit être exécutée toutes les 5 minutes après la fin de l'exécution de la dernière instance de la méthode. Cela signifie que le timer démarre à la fin de la dernière exécution, pas au début.

            }
        }
    }

    @Scheduled(fixedRate = 300000)
    public void pourcentageChambreParType() {
      List<Chambre> chambres = chambreRepository.findAll();

      Map<TypeChambre,Long> countType = chambres.stream()
        .collect(Collectors.groupingBy(Chambre::getTypeC,Collectors.counting()));
     long  totalChambres = chambres.size();
        // Affichage du nombre total de chambres une seule fois
        log.info("Nombre total des chambres: " + totalChambres);
        //type : représente chaque clé de la Map, c'est-à-dire le type de chambre. Par exemple, si le type est "Standard", type sera "Standard".
        //count : représente chaque valeur de la Map, c'est-à-dire le nombre de chambres de ce type. Par exemple, si le type "Standard" apparaît 10 fois dans la liste chambres, count sera 10.
        countType.forEach((type, count) -> {
            double pourcentage = ((double) count / totalChambres) * 100;
            log.info("Type de chambre: " + type + ", Nombre: " + count + ", Pourcentage: " + pourcentage + "%");
        });
    }
    private int getCapaciteMaximale(TypeChambre typeChambre) {
        switch (typeChambre) {
            case SIMPLE:
                return 1;  // Chambre simple avec capacité 1
            case DOUBLE:
                return 2;  // Chambre double avec capacité 2
            case TRIPLE:
                return 3;  // Chambre triple avec capacité 3
            default:
                throw new IllegalStateException("Type de chambre inconnu");
        }
    }



}
