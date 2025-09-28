package controller;

import model.Client;
import model.Compte;
import service.GestionnaireService;
import service.CompteService;
import java.util.List;
import java.math.BigDecimal;

public class GestionnaireController {
    private final GestionnaireService gestionnaireService;
    private final CompteService compteService;

    public GestionnaireController(GestionnaireService gestionnaireService, CompteService compteService) {
        this.gestionnaireService = gestionnaireService;
        this.compteService = compteService;
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

    // Méthode pour ajouter un compte à un client
    public void ajouterCompte(String idClient, String typeCompte, BigDecimal solde) {
        try {
            Compte nouveauCompte = compteService.ajouterCompte(idClient, typeCompte, solde);
            System.out.println("Compte créé avec succès !");
            System.out.println("ID du compte: " + nouveauCompte.getIdCompte());
            System.out.println("Type: " + nouveauCompte.getTypeCompte());
            System.out.println("Solde initial: " + nouveauCompte.getSolde() + " DH");
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur de validation: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erreur lors de la création du compte: " + e.getMessage());
        }
    }

    // Méthode pour afficher tous les comptes
    public void afficherTousLesComptes() {
        List<Compte> comptes = compteService.getAllComptes();
        
        if (comptes.isEmpty()) {
            System.out.println("Aucun compte enregistré.");
            return;
        }

        System.out.println("\n=== Liste de tous les comptes ===");
        for (Compte compte : comptes) {
            System.out.println("--------------------------------");
            System.out.println("ID Compte: " + compte.getIdCompte());
            System.out.println("ID Client: " + compte.getIdClient());
            System.out.println("Type: " + compte.getTypeCompte());
            System.out.println("Solde: " + compte.getSolde() + " DH");
        }
        System.out.println("--------------------------------");
    }

    // Méthode pour afficher les comptes d'un client spécifique
    public void afficherComptesClient(String idClient) {
        List<Compte> comptes = compteService.getComptesByClientId(idClient);
        
        if (comptes.isEmpty()) {
            System.out.println("Aucun compte trouvé pour ce client.");
            return;
        }

        System.out.println("\n=== Comptes du client " + idClient + " ===");
        for (Compte compte : comptes) {
            System.out.println("--------------------------------");
            System.out.println("ID Compte: " + compte.getIdCompte());
            System.out.println("Type: " + compte.getTypeCompte());
            System.out.println("Solde: " + compte.getSolde() + " DH");
        }
        System.out.println("--------------------------------");
    }
}
