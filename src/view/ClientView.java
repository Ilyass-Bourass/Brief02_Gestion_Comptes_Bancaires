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
            System.out.println("║ 2. Consulter mes comptes bancaires         ║");
            System.out.println("║ 3. Historique de mes transactions          ║");
            System.out.println("║ 4. Filtrer mes transactions                ║");
            System.out.println("║ 5. le solde total                          ║");
            System.out.println("║ 6. les montants total déposés              ║");
            System.out.println("║ 7. les montants total retirés              ║");
            System.out.println("║ 8. Déconnexion                             ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.print("Choisissez une option: ");

            int choix = sc.nextInt();

            switch (choix) {
                case 1:
                    System.out.println("=== Mes informations ===");
                    break;
                case 2:
                    System.out.println("=== Consulter mes comptes bancaires ===");
                    break;
                case 3:
                    System.out.println("=== Historique de mes transactions ===");
                    break;
                case 4:
                    System.out.println("=== Filtrer mes transactions ===");
                    System.out.println("1 : Par type");
                    System.out.println("2 : Par date");
                    System.out.println("3 : Par montant");
                    System.out.println("choisisez votre choix");
                    int choixFiltre = sc.nextInt();
                    if(choixFiltre == 1){
                        System.out.println("=== Filtrer par type ===");
                    } else if (choixFiltre == 2){
                        System.out.println("=== Filtrer par date ===");
                    } else if (choixFiltre == 3){
                        System.out.println("=== Filtrer par montant ===");
                    } else {
                        System.out.println("Choix invalide. Veuillez réessayer.");
                    }
                    break;
                    
                case 5:
                    System.out.println("=== le solde total ===");
                    break;
                case 06:
                    System.out.println("=== les montants total déposés ===");
                    break;
                case 07:
                    System.out.println("=== les montants total retirés ===");
                    break;
                case 8:
                    System.out.println("Déconnexion réussie. À bientôt!");
                    continuer=false;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    break;
            }
        }
    }
}
