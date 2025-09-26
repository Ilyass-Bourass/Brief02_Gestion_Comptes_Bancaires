package view;

import controller.GestionnaireController;
import model.Gestionnaire;

import java.util.Scanner;

public class GestionnaireView {
    private final GestionnaireController gestionnaireController;
    private final Scanner sc;
    private final Gestionnaire gestionnaireConnecte;

    public GestionnaireView(GestionnaireController gestionnaireController, Gestionnaire gestionnaire) {
        this.gestionnaireController = gestionnaireController;
        this.gestionnaireConnecte = gestionnaire;
        this.sc = new Scanner(System.in);
    }

    public void afficherMenuGestionnaire() {
        boolean continuer = true;

        while (continuer) {
            System.out.println("\n╔══════════════════════════════════════════╗");
            System.out.println("║         ESPACE GESTIONNAIRE                ║");
            System.out.println("╠════════════════════════════════════════════╣");
            System.out.println("║ 1. Ajouter un nouveau client               ║");
            System.out.println("║ 2. Liste des clients                       ║");
            System.out.println("║ 3. Déconnexion                             ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.println("Gestionnaire connecté: " + gestionnaireConnecte.getNom() + " " + gestionnaireConnecte.getPrenom());
            System.out.print("Choisissez une option: ");

            int choix = sc.nextInt();

            switch (choix) {
                case 1:
                    ajouterClient();
                    break;
                case 2:
                    afficherListeClients();
                    break;
                case 3:
                    System.out.println("Au revoir " + gestionnaireConnecte.getNom() + "!");
                    continuer = false;
                    break;
                default:
                    System.out.println("Option invalide!");
            }
        }
    }

    private void ajouterClient() {
        System.out.println("\n=== Ajout d'un nouveau client ===");
        sc.nextLine(); 

        System.out.print("Nom: ");
        String nom = sc.nextLine();

        System.out.print("Prénom: ");
        String prenom = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Mot de passe: ");
        String motPasse = sc.nextLine();

        try {
            gestionnaireController.ajouterClient(nom, prenom, email, motPasse);
            System.out.println("Client ajouté avec succès!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur de validation: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }

    private void afficherListeClients() {
        System.out.println("\n=== Liste des clients ===");
        gestionnaireController.afficherListeClients();
    }
}