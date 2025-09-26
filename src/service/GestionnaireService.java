package service;

import model.Client;
import java.util.ArrayList;
import java.util.List;

public class GestionnaireService {
    private List<Client> clients;

    public GestionnaireService() {
        this.clients = new ArrayList<>();
    }

    public void ajouterClient(String nom, String prenom, String email, String motPasse) {
        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom ne peut pas être vide");
        }
        if (prenom == null || prenom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le prénom ne peut pas être vide");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("L'email ne peut pas être vide");
        }
        if (motPasse == null || motPasse.trim().isEmpty()) {
            throw new IllegalArgumentException("Le mot de passe ne peut pas être vide");
        }

        boolean emailExists = clients.stream()
                .anyMatch(c -> c.getEmail().equals(email));

        if (emailExists) {
            throw new IllegalStateException("Un client avec cet email existe déjà");
        }

        Client nouveauClient = new Client(nom, prenom, email, motPasse);
        clients.add(nouveauClient);
    }

    public List<Client> getAllClients() {
        return new ArrayList<>(clients);
    }

    
}
