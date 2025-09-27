package service;

import model.Client;
import java.util.List;

public class GestionnaireService {
    private AuthService authService;

    public GestionnaireService(AuthService authService) {
        this.authService = authService;
    }

    public void ajouterClient(String nom, String prenom, String email, String motPasse) {
        
        authService.inscrireClient(nom, prenom, email, motPasse);
    }

    public List<Client> getAllClients() {
        return authService.getAllClients();
    }

    
}
