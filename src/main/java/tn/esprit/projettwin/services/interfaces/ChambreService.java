package tn.esprit.projettwin.services.interfaces;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tn.esprit.projettwin.Chambre;
import tn.esprit.projettwin.TypeChambre;
import tn.esprit.projettwin.repository.ChambreRepository;

import java.lang.reflect.Type;
import java.util.List;


public interface ChambreService{
    public List<Chambre> retrieveAllChambres();
    public Chambre retrieveChambre(Long chambreId);
    public Chambre addChambre(Chambre c);
    public void removeChambre(Long chambreId);
    public Chambre modifyChambre(Chambre chambre);

    List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC);
    public List<Chambre> getChambresParNomUniversite( String nomUniversite);
    public List<Chambre> getChambresNonReserveesParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre typeChambre);
    public void getChambresParBloc();
    public void pourcentageChambreParType();

    }
