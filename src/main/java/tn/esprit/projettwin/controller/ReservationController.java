package tn.esprit.projettwin.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projettwin.Reservation;
import tn.esprit.projettwin.services.classes.ReservationServiceImp;
import tn.esprit.projettwin.services.interfaces.ReservationService;

import java.util.Date;
import java.util.List;

@Tag(name = "Gestion Réservation")
@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    // http://localhost:8089/tpfoyer/reservation/retrieve-all-reservations
    @Operation(description = "Récupérer toutes les réservations de la base de données")
    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> getReservations() {
        return reservationService.retrieveAllReservations();
    }

    // http://localhost:8089/tpfoyer/reservation/retrieve-reservation/8
    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") Long rId) {
        return reservationService.retrieveReservation(rId);
    }

    // http://localhost:8089/tpfoyer/reservation/add-reservation
    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation r) {
        return reservationService.addReservation(r);
    }

    // http://localhost:8089/tpfoyer/reservation/remove-reservation/{reservation-id}
    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") Long rId) {
        reservationService.removeReservation(rId);
    }

    // http://localhost:8089/tpfoyer/reservation/modify-reservation
    @PutMapping("/modify-reservation")
    public Reservation modifyReservation(@RequestBody Reservation r) {
        return reservationService.modifyReservation(r);
    }

    @PostMapping("/ajouter-reservation/{id-bloc}")
    public Reservation ajouterReservation(@PathVariable("id-bloc") long idBloc, @RequestParam long cinEtudiant) {
        return reservationService.ajouterReservation(idBloc,cinEtudiant);
    }

    @GetMapping("/reservation-par-annee-nomuniversite")
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(@RequestParam("anneeUniversitaire") @DateTimeFormat(pattern = "yyyy-MM-dd") Date anneeUniversitaire,
                                                                                @RequestParam("nomUniversite") String nomUniversite){
        return reservationService.getReservationParAnneeUniversitaireEtNomUniversite(anneeUniversitaire,nomUniversite);
    }

    @PostMapping ("/annuler-reservation")
    public Reservation annulerReservation(@RequestParam long cin){
        return reservationService.annulerReservation(cin);
    }
}

