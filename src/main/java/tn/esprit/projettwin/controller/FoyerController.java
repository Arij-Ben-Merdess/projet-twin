package tn.esprit.projettwin.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projettwin.Chambre;
import tn.esprit.projettwin.Foyer;
import tn.esprit.projettwin.services.classes.FoyerServiceImpl;
import tn.esprit.projettwin.services.interfaces.FoyerService;

import java.util.List;

@Tag(name = "Gestion Foyer")
@RestController
@AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerController {
    @Autowired
    FoyerServiceImpl foyerService;

    @GetMapping("/retrieve-all-foyers")
    public List<Foyer> getFoyers() {
        List<Foyer> listFoyers = foyerService.retrieveAllFoyers();
        return listFoyers;
    }
    @GetMapping("/retrieve-foyer/{foyer-id}")
    public Foyer retrieveFoyer(@PathVariable("foyer-id") Long fId) {
        Foyer foyer = foyerService.retrieveFoyer(fId);
        return foyer;
    }
    @PostMapping("/add-foyer")
    public Foyer addFoyer(@RequestBody Foyer f) {
        Foyer foyer = foyerService.addFoyer(f);
        return foyer;
    }
    @DeleteMapping("/remove-foyer/{foyer-id}")
    public void removeFoyer(@PathVariable("foyer-id") Long fId) {
        foyerService.removeFoyer(fId);
    }
    @PutMapping("/modify-foyer")
    public Foyer modifyFoyer(@RequestBody Foyer f) {
        Foyer foyer = foyerService.modifyFoyer(f);
        return foyer;
    }

    /*@PostMapping("ajouter-foyer-universite/{id-universite}")
    public Foyer ajouterFoyerEtaffecterUniversite(@RequestBody Foyer foyer,@PathVariable("id-universite") long idUniversite){
        return foyerService.ajouterFoyerEtAffecterUniversite(foyer,idUniversite);
    }*/
}
