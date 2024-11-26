package tn.esprit.projettwin.services.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tn.esprit.projettwin.Chambre;
import tn.esprit.projettwin.Reservation;
import tn.esprit.projettwin.repository.FoyerRepository;
import tn.esprit.projettwin.repository.ReservationRepository;

import java.util.Date;
import java.util.List;

public interface ReservationService {
    public List<Reservation> retrieveAllReservations();
    public Reservation retrieveReservation(Long rId);
    public Reservation addReservation(Reservation r);
    public void removeReservation(Long rId);
    public Reservation modifyReservation(Reservation r);
    public Reservation ajouterReservation(long idBloc, long cinEtudiant);
    public Reservation annulerReservation (long cinEtudiant) ;
public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversitaire,String nomUniversite);

    }
