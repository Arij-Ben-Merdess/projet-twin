package tn.esprit.projettwin.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projettwin.Chambre;
import tn.esprit.projettwin.Etudiant;
import tn.esprit.projettwin.services.classes.EtudiantServiceImp;
import tn.esprit.projettwin.services.interfaces.EtudiantService;

import java.util.List;

@Tag(name = "Gestion Etudiants")
@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantController {
    EtudiantServiceImp etudiantService;

    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> getEtudiants() {
        List<Etudiant> listEtudiants = etudiantService.retrieveAllEtudiants();
        return listEtudiants;
    }
    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Long eId) {
        Etudiant etudiant = etudiantService.retrieveEtudiant(eId);
        return etudiant;
    }
    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant = etudiantService.addEtudiant(e);
        return etudiant;
    }
    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeChambre(@PathVariable("etudiant-id") Long eId) {
        etudiantService.removeEtudiant(eId);
    }
    // http://localhost:8089/tpfoyer/etudiant/modify-etudiant
    @PutMapping("/modify-etudiant")
    public Etudiant modifyEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant = etudiantService.modifyEtudiant(e);
        return etudiant;
    }
}
