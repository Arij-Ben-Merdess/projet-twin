package tn.esprit.projettwin.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projettwin.Bloc;
import tn.esprit.projettwin.Chambre;
import tn.esprit.projettwin.services.classes.BlocServiceImp;
import tn.esprit.projettwin.services.interfaces.BlocService;

import java.util.List;

@Tag(name = "Gestion Blocs", description = "Opérations liées aux blocs")
@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocController {
    private BlocService blocService;

// http://localhost:8089/tpfoyer/bloc/retrieve-all-blocs
    @Operation(description = "récupérer tous les blos de la base de données")
    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> getBlocs(){
        List<Bloc> listBlocs = blocService.retrieveAllBlocs();
        return listBlocs;
    }

    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBloc(@PathVariable("bloc-id") Long bId){
        Bloc bloc = blocService.retrieveBloc(bId);
        return bloc;
    }

    /*@PostMapping(value = "/add-bloc", consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public Bloc addBloc(@RequestBody Bloc b){
        return blocService.addBloc(b);
    }*/

    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc b) {
        Bloc bloc = blocService.addBloc(b);
        return bloc;
    }

    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") Long bId){
        blocService.removeBloc(bId);
    }

    @PutMapping("/modify-bloc") public Bloc modifyBloc(@RequestBody Bloc b){
        Bloc bloc = blocService.modifyBloc(b);
        return bloc;
    }


    @GetMapping("/universite")
    public List<Bloc> getBlocByUniversiteName(@RequestParam String nomUniversite){
      return blocService.getBlocByUniversiteName(nomUniversite);

    }

    @PostMapping("/affecter-chambres-bloc/{id-bloc}")
    public Bloc affecterChambresABloc(@RequestBody List<Long> numChambre,@PathVariable("id-bloc") long idBloc){
        return blocService.affecterChambresABloc(numChambre,idBloc);
    }


}
