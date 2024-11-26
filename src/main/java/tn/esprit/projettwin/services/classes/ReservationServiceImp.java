package tn.esprit.projettwin.services.classes;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tn.esprit.projettwin.*;
import tn.esprit.projettwin.repository.BlocRepository;
import tn.esprit.projettwin.repository.ChambreRepository;
import tn.esprit.projettwin.repository.EtudiantRepository;
import tn.esprit.projettwin.repository.ReservationRepository;
import tn.esprit.projettwin.services.interfaces.ReservationService;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
@AllArgsConstructor
public class ReservationServiceImp implements ReservationService {

    private ReservationRepository reservationRepository;
    private EtudiantRepository etudiantRepository;
    private BlocRepository blocRepository;
    private ChambreRepository chambreRepository;




    @Override
    public List<Reservation> retrieveAllReservations() {
        return reservationRepository.findAll();
    }
    @Override
    public Reservation retrieveReservation(Long rId) {
        return reservationRepository.findById(rId).get();
    }
    @Override
    public Reservation addReservation(Reservation r) {
        return reservationRepository.save(r);
    }
    @Override
    public void removeReservation(Long rId) {
        reservationRepository.deleteById(rId);
    }
    @Override
    public Reservation modifyReservation(Reservation r) {
        return reservationRepository.save(r);
    }
    @Override
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {
        Bloc bloc = blocRepository.findById(idBloc).get();
        Set<Chambre> chambres = bloc.getChambres();
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);

        // Vérifier la capacité de chaque chambre et ajouter à la première chambre disponible
        Chambre chambreDisponible = null;
        for (Chambre chambre : chambres) {
            int capaciteMaximale = getCapaciteMaximale(chambre.getTypeC());

            if (capaciteMaximale >= chambre.getReservations().size()) {
                   chambreDisponible = chambre;
                break;
            }
        }

        Reservation reservation = new Reservation();
        String numReservation = chambreDisponible.getNumeroChambre() + "-" + bloc.getNomBloc() + "-"
                + reservation.getAnneeUniversitaire();

        // Définir le statut de validité
        reservation.setEstValide(true);

        // Ajouter l'étudiant à la réservation
        reservation.setEtudiants(new HashSet<>(Collections.singleton(etudiant)));

        // Ajouter la réservation à la chambre disponible
        chambreDisponible.getReservations().add(reservation);

        // Sauvegarder la réservation et la chambre
        reservationRepository.save(reservation);
        chambreRepository.save(chambreDisponible);

        return reservation;    }

    // Logique pour déterminer la capacité selon le type de chambre
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
    @Override
    public Reservation annulerReservation (long cinEtudiant) {
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);

        Set<Reservation> reservations = etudiant.getReservations();

        Reservation reservationAnnulee = null;
        for (Reservation reservation : reservations) {
            reservation.setEstValide(false);
            Set<Etudiant> etudiants = reservation.getEtudiants();
            etudiants.remove(etudiant);
            reservation.setEtudiants(etudiants);

            // Sauvegarder la réservation mise à jour
            reservationAnnulee = reservation;

            // Sauvegarder l'étudiant mis à jour (si nécessaire)
            etudiantRepository.save(etudiant);

        }
        return reservationRepository.save(reservationAnnulee);
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversitaire,String nomUniversite){
      return  reservationRepository.findReservationByAnneeUniversitaireAndNomUniversite(anneeUniversitaire,nomUniversite);
    }
}
