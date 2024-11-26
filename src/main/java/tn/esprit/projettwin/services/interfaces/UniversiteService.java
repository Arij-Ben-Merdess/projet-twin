package tn.esprit.projettwin.services.interfaces;

import tn.esprit.projettwin.Universite;

import java.util.List;

public interface UniversiteService {
    // Récupérer toutes les universités
    public List<Universite> retrieveAllUniversites();

    // Récupérer une université par son ID
    public Universite retrieveUniversite(Long universiteId);

    // Ajouter une nouvelle université
    public Universite addUniversite(Universite universite);

    // Supprimer une université par son ID
    public void removeUniversite(Long universiteId);

    // Modifier une université existante
    public Universite modifyUniversite(Universite universite);

    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite);
public Universite desaffecterFoyerAUniversite(long idUniversite);
}

