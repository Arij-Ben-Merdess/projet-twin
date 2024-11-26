package tn.esprit.projettwin.services.classes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.projettwin.*;
import tn.esprit.projettwin.repository.BlocRepository;
import tn.esprit.projettwin.repository.ChambreRepository;
import tn.esprit.projettwin.repository.FoyerRepository;
import tn.esprit.projettwin.repository.UniversiteRepository;
import tn.esprit.projettwin.services.interfaces.ChambreService;

import java.util.List;
import java.util.Set;

@Service
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
}
