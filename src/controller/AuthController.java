package controller;

import model.Client;
import model.Gestionnaire;
import service.AuthService;
import service.GestionnaireService;

import java.util.List;
import java.util.Optional;

public class AuthController {
    private AuthService authService;
    private GestionnaireService gestionnaireService;

    public AuthController(AuthService authService, GestionnaireService gestionnaireService) {
        this.authService = authService;
        this.gestionnaireService = gestionnaireService;
    }
    
    public List<Gestionnaire> listerGestionnaires() {
        return authService.getAllGestionnaires();
    }
    
    public void afficherListeGestionnaires() {
        List<Gestionnaire> gestionnaires = listerGestionnaires();
        if (gestionnaires.isEmpty()) {
            System.out.println("Aucun gestionnaire n'est enregistré.");
            return;
        }
        
        System.out.println("\n=== Liste des Gestionnaires ===");
        System.out.println("--------------------------------");
        for (Gestionnaire g : gestionnaires) {
            System.out.println("ID: " + g.getUuid());
            System.out.println("Nom: " + g.getNom());
            System.out.println("Prénom: " + g.getPrenom());
            System.out.println("Email: " + g.getEmail());
            System.out.println("Département: " + g.getDepartement());
            System.out.println("--------------------------------");
        }
    }

    public Gestionnaire inscrireGestionnaire(String nom, String prenom, String email, String motPasse, String departement) {
        try {
            return authService.inscrireGestionnaire(nom, prenom, email, motPasse, departement);
        } catch (IllegalArgumentException e) {
            System.err.println("Erreur de validation: " + e.getMessage());
            throw e;
        } catch (IllegalStateException e) {
            System.err.println("Erreur d'inscription: " + e.getMessage());
            throw e;
        }
    }

    public Optional<Gestionnaire> authentifierGestionnaire(String email, String motPasse) {
        try {
            return authService.authentifierGestionnaire(email, motPasse);
        } catch (IllegalArgumentException e) {
            System.err.println("Erreur de validation: " + e.getMessage());
            throw e;
        }
    }

    public Optional<Client> authentifierClient(String email, String motPasse) {
        try {
            return authService.authentifierClient(email, motPasse);
        } catch (IllegalArgumentException e) {
            System.err.println("Erreur de validation: " + e.getMessage());
            throw e;
        }
    }
}
