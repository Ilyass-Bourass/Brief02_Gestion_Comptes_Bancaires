import controller.AuthController;
import service.AuthService;
import service.GestionnaireService;
import service.CompteService;
import view.MenuPrincipal;

public class Main {
    public static void main(String[] args) {
        try {
            
            AuthService authService = new AuthService();
            GestionnaireService gestionnaireService = new GestionnaireService(authService);
            CompteService compteService = new CompteService();

            AuthController authController = new AuthController(authService, gestionnaireService, compteService);

            MenuPrincipal menuPrincipal = new MenuPrincipal(authController, authService, compteService);

            System.out.println("Bienvenue dans le système de gestion bancaire!");
            menuPrincipal.afficherMenuPrincipal();

        } catch (Exception e) {
            System.err.println("Erreur lors du démarrage de l'application: " + e.getMessage());
            e.printStackTrace();
        }
    }
}