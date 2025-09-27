package view;

import java.util.Scanner;

public class ClientView {

    private final Scanner sc;

    public ClientView() {
        this.sc = new Scanner(System.in);
    }

    public void afficherMenuClient() {
    boolean continuer = true;

        while (continuer) {
            System.out.println("\n╔══════════════════════════════════════════╗");
            System.out.println("║            ESPACE CLIENT                   ║");
            System.out.println("╠════════════════════════════════════════════╣");
            System.out.println("║ 1. Voir mes informations                   ║");
            System.out.println("║ 2. faire un virement                       ║");
            System.out.println("║ 3. Consulter mes transactions              ║");
            System.out.println("║ 4. Ajouter un bénéficiaire                 ║");
            System.out.println("║ 5. Déconnexion                             ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.print("Choisissez une option: ");

            int choix = sc.nextInt();

            switch (choix) {
                case 1:
                    System.out.println("=== Mes informations ===");
                    break;
                case 2:
                    System.out.println("=== Faire un virement ===");
                    break;
                case 3:
                    System.out.println("=== Mes transactions ===");
                    break;
                case 4:
                    System.out.println("=== Ajouter un bénéficiaire ===");
                    break;
                    
                case 5:
                    System.out.println("Au revoir!");
                    continuer = false;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }
}
