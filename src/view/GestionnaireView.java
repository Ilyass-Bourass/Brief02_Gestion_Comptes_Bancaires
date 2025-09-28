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
            System.out.println("║ 5. Consulter les transactions suspectes    ║");
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
                            ajouterCompte();
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
                            afficherListeComptes();
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
                    sc.nextLine(); // Consommer le retour à la ligne
                    String idClientTransaction = sc.nextLine();
                    afficherListeComptes();
                    System.out.println("Fonctionnalité non encore implémentée.");
                    break;
                case 5:
                    System.out.println("Consulter les transactions suspectes");
                    break;
                case 6:
                    System.out.println("Déconnexion en cours...");
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

    private void ajouterCompte() {
        System.out.println("\n=== Ajout d'un nouveau compte ===");
        sc.nextLine();

        System.out.println("Liste des clients disponibles:");
        gestionnaireController.afficherListeClients();

        System.out.print("\nID du client (copiez l'ID depuis la liste ci-dessus): ");
        String idClient = sc.nextLine();

        System.out.println("Types de compte disponibles:");
        System.out.println("1. COURANT");
        System.out.println("2. EPARGNE");
        System.out.print("Choisissez le type de compte (1 ou 2): ");
        int choixType = sc.nextInt();
        
        String typeCompte;
        if (choixType == 1) {
            typeCompte = "COURANT";
        } else if (choixType == 2) {
            typeCompte = "EPARGNE";
        } else {
            System.out.println("Type de compte invalide!");
            return;
        }

        System.out.print("Solde initial (ex: 1000.50): ");
        double soldeDouble = sc.nextDouble();
        
        try {
            java.math.BigDecimal solde = java.math.BigDecimal.valueOf(soldeDouble);
            gestionnaireController.ajouterCompte(idClient, typeCompte, solde);
        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }

    private void afficherListeComptes() {
        System.out.println("\n=== Gestion des comptes ===");
        System.out.println("1. Afficher tous les comptes");
        System.out.println("2. Afficher les comptes d'un client spécifique");
        System.out.print("Choisissez une option: ");
        
        int choix = sc.nextInt();
        
        switch (choix) {
            case 1:
                gestionnaireController.afficherTousLesComptes();
                break;
            case 2:
                sc.nextLine(); 
                System.out.print("ID du client: ");
                String idClient = sc.nextLine();
                gestionnaireController.afficherComptesClient(idClient);
                break;
            default:
                System.out.println("Option invalide!");
        }
    }
}