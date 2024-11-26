package tn.esprit.projettwin.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projettwin.Universite;
import tn.esprit.projettwin.services.interfaces.UniversiteService;

import java.util.List;

@Tag(name = "Gestion Université")
@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteController {

    // Injection du service UniversiteService
    @Autowired
    UniversiteService universiteService;

    // Endpoint pour récupérer toutes les universités
    @Operation(description = "Récupérer toutes les universités de la base de données")
    @GetMapping("/retrieve-all-universites")
    public List<Universite> getUniversites() {
        return universiteService.retrieveAllUniversites();
    }

    // Endpoint pour récupérer une université par son ID
    @Operation(description = "Récupérer une université spécifique par son ID")
    @GetMapping("/retrieve-universite/{universite-id}")
    public Universite getUniversite(@PathVariable("universite-id") Long universiteId) {
        return universiteService.retrieveUniversite(universiteId);
    }

    // Endpoint pour ajouter une nouvelle université
    @Operation(description = "Ajouter une nouvelle université")
    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite universite) {
        return universiteService.addUniversite(universite);
    }

    // Endpoint pour supprimer une université par son ID
    @Operation(description = "Supprimer une université par son ID")
    @DeleteMapping("/remove-universite/{universite-id}")
    public void removeUniversite(@PathVariable("universite-id") Long universiteId) {
        universiteService.removeUniversite(universiteId);
    }

    // Endpoint pour modifier une université
 //   @RequestBody est utilisé pour désérialiser un objet JSON du corps de la requête en un objet Java.
    @Operation(description = "Modifier une université existante")
    @PutMapping("/modify-universite")
    public Universite modifyUniversite(@RequestBody Universite universite) {
        return universiteService.modifyUniversite(universite);
    }

    @Operation(description = "affecter un foyer à une univeriste")
    @PostMapping("/affecter-foyer-universite/{foyer-id}")
    public Universite affecterFoyerAUniversite(@PathVariable("foyer-id") Long foyerId,@RequestParam String nomUniversite){
       return universiteService.affecterFoyerAUniversite(foyerId,nomUniversite);
    }

    @PostMapping("/desaffecterFoyer/{id-universite}")
    public Universite desaffecterFoyerAUniversite(@PathVariable("id-universite") long idUniversite){
        return universiteService.desaffecterFoyerAUniversite(idUniversite);
    }


}