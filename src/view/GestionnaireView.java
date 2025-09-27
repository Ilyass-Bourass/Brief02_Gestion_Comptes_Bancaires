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
            System.out.println("║ 1. Gestions des clients                    ║");
            System.out.println("║ 2. Gestions des comptes                    ║");
            System.out.println("║ 3. Gestions des transactions               ║");
            System.out.println("║ 4. Consulter les transactions d'un client  ║");
            System.out.println("║ 5. Consulter les transactions suspectes     ║");
            System.out.println("║ 6. Déconnexion                             ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.println("Gestionnaire connecté: " + gestionnaireConnecte.getNom() + " " + gestionnaireConnecte.getPrenom());
            System.out.print("Choisissez une option: ");

            int choix = sc.nextInt();

            switch (choix) {
                case 1:
                    System.out.println("\n--- Gestion des clients ---");
                    System.out.println("1 :ajouter un client");
                    System.out.println("2: Modifier un client");
                    System.out.println("3: Supprimer un client");
                    System.out.println("4: Afficher la liste des clients");
                    System.out.print("Choisissez une option: ");
                    int sousChoix = sc.nextInt();
                    switch (sousChoix) {
                        case 1:
                            ajouterClient();
                            break;
                        case 2:
                            // modifierClient();
                            System.out.println("Fonctionnalité non encore implémentée.");
                            break;
                        case 3:
                            // supprimerClient();
                            System.out.println("Fonctionnalité non encore implémentée.");
                            break;
                        case 4:
                            afficherListeClients();
                            break;
                        default:
                            System.out.println("Option invalide!");
                    }
                    break;
                case 2:
                    System.out.println("Gestion des comptes");
                    System.out.println("1:Ajouter un compte");
                    System.out.println("2:Modifier un compte");
                    System.out.println("3:Supprimer un compte");
                    System.out.println("4:Afficher la liste des comptes");
                    System.out.print("Choisissez une option: ");
                    int choixCompte = sc.nextInt();
                    switch (choixCompte) {
                        case 1:
                            // ajouterCompte();
                            System.out.println("Fonctionnalité non encore implémentée.");
                            break;
                        case 2:
                            // modifierCompte();
                            System.out.println("Fonctionnalité non encore implémentée.");
                            break;
                        case 3:
                            // supprimerCompte();
                            System.out.println("Fonctionnalité non encore implémentée.");
                            break;
                        case 4:
                            // afficherListeComptes();
                            System.out.println("Fonctionnalité non encore implémentée.");
                            break;
                        default:
                            System.out.println("Option invalide!");
                    }
                    break;
                case 3:
                    System.out.println("Gestion des transactions");
                    System.out.println("Choissir le type de transaction:");
                    System.out.println("1: Dépôt");
                    System.out.println("2: Retrait");
                    System.out.println("3: Virement");
                    System.out.print("Choisissez une option: ");
                    int choixTransaction = sc.nextInt();
                    switch (choixTransaction) {
                        case 1:
                            // gererDepot();
                            System.out.println("Fonctionnalité non encore implémentée.");
                            break;
                        case 2:
                            // gererRetrait();
                            System.out.println("Fonctionnalité non encore implémentée.");
                            break;
                        case 3:
                            // gererVirement();
                            System.out.println("Fonctionnalité non encore implémentée.");
                            break;
                        default:
                            System.out.println("Option invalide!");
                    } 
                    break;
                case 4:
                    System.out.println("Consulter les transactions d'un client");
                    System.out.println("Saisir l'ID du client:");
                    int idClient = sc.nextInt();
                   // gestionnaireController.consulterTransactionsClient(idClient);
                    System.out.println("Fonctionnalité non encore implémentée.");
                    break;
                case 5 :
                System.out.println("Consulter les transactions suspectes");
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