package tn.esprit.projettwin.services.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.core.Block;
import org.springframework.stereotype.Service;
import tn.esprit.projettwin.Bloc;
import tn.esprit.projettwin.Chambre;
import tn.esprit.projettwin.repository.BlocRepository;

import java.util.List;

public interface BlocService {
    public List<Bloc> retrieveAllBlocs();
    public Bloc retrieveBloc(Long BlocId);
    public Bloc addBloc(Bloc b);
    public void removeBloc(Long BlocId);
    public Bloc modifyBloc(Bloc bloc);
    List<Bloc> getBlocByUniversiteName(String nomUniversite);

    public Bloc affecterChambresABloc(List<Long> numChabmbre, Long idBloc);


}
