package controller;

import model.Client;
import service.GestionnaireService;
import java.util.List;

public class GestionnaireController {
    private final GestionnaireService gestionnaireService;

    public GestionnaireController(GestionnaireService gestionnaireService) {
        this.gestionnaireService = gestionnaireService;
    }

    public void ajouterClient(String nom, String prenom, String email, String motPasse) {
        try {
            gestionnaireService.ajouterClient(nom, prenom, email, motPasse);
        } catch (IllegalArgumentException | IllegalStateException e) {
            throw e;
        }
    }

    public void afficherListeClients() {
        List<Client> clients = gestionnaireService.getAllClients();
        
        if (clients.isEmpty()) {
            System.out.println("Aucun client enregistré.");
            return;
        }

        System.out.println("\n=== Liste des clients ===");
        for (Client client : clients) {
            System.out.println("--------------------------------");
            System.out.println("ID: " + client.getUuid());
            System.out.println("Nom: " + client.getNom());
            System.out.println("Prénom: " + client.getPrenom());
            System.out.println("Email: " + client.getEmail());
            System.out.println("Mot de passe: " + client.getMotPasse());
        }
        System.out.println("--------------------------------");
    }
}
