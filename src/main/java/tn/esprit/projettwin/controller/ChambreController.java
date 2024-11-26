package tn.esprit.projettwin.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projettwin.Chambre;
import tn.esprit.projettwin.TypeChambre;
import tn.esprit.projettwin.services.classes.ChambreServiceImpl;
import tn.esprit.projettwin.services.interfaces.ChambreService;

import java.util.List;
@Tag(name = "Gestion Chambres", description = "Opérations liées aux cahmbres")
@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreController {
    @Autowired
    ChambreServiceImpl chambreService;

    // http://localhost:8089/tpfoyer/chambre/retrieve-all-chambres
    @Operation(description = "récupérer toutes les chambres de la base de données")
    @GetMapping("/retrieve-all-chambres")
    public List<Chambre> getChambres() {
        List<Chambre> listChambres = chambreService.retrieveAllChambres();
        return listChambres;
    }

    // http://localhost:8089/tpfoyer/chambre/retrieve-chambre/8
    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long chId) {
        Chambre chambre = chambreService.retrieveChambre(chId);
        return chambre;
    }

    // http://localhost:8089/tpfoyer/chambre/add-chambre
    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.addChambre(c);
        return chambre;
    }

    // http://localhost:8089/tpfoyer/chambre/remove-chambre/{chambre-id}
    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") Long chId) {
        chambreService.removeChambre(chId);
    }

    // http://localhost:8089/tpfoyer/chambre/modify-chambre
    @PutMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.modifyChambre(c);
        return chambre;
    }

    @PostMapping("/getchambresbloc-type/{idBloc}")
    public List<Chambre> getChambresParBlocEtType(@PathVariable long idBloc,@RequestParam TypeChambre typeC) {
    return  chambreService.getChambresParBlocEtType(idBloc,typeC);
    }
    @GetMapping  ("/get-chambres-par-universite")
    public List<Chambre> getChambresParNomUniversite(@RequestParam String nomUniversite){
        return chambreService.getChambresParNomUniversite(nomUniversite);
    }
    @GetMapping("/non-reservees/{nomUniversite}/{typeChambre}")
    public List<Chambre> getChambresNonReservees(
            @PathVariable("nomUniversite") String nomUniversite,
            @PathVariable("typeChambre") TypeChambre typeChambre) {
        return chambreService.getChambresNonReserveesParNomUniversiteEtTypeChambre(nomUniversite, typeChambre);
    }
}