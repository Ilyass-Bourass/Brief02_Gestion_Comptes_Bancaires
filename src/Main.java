import controller.AuthController;
import service.AuthService;
import service.GestionnaireService;
import view.MenuPrincipal;

public class Main {
    public static void main(String[] args) {
        try {
            
            GestionnaireService gestionnaireService = new GestionnaireService();
            AuthService authService = new AuthService();

            AuthController authController = new AuthController(authService, gestionnaireService);

            MenuPrincipal menuPrincipal = new MenuPrincipal(authController);

            System.out.println("Bienvenue dans le système de gestion bancaire!");
            menuPrincipal.afficherMenuPrincipal();

        } catch (Exception e) {
            System.err.println("Erreur lors du démarrage de l'application: " + e.getMessage());
            e.printStackTrace();
        }
    }
}