package service;

import model.Client;
import model.Gestionnaire;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthService {
    private List<Gestionnaire> gestionnaires;
    private List<Client> clients;

    public AuthService() {
        this.gestionnaires = new ArrayList<>();
        Gestionnaire gestionnaire = new Gestionnaire("Admin", "Admin", "a", "a", "Direction");
        this.gestionnaires.add(gestionnaire);
        this.clients = new ArrayList<>();
    }
    
    public List<Gestionnaire> getAllGestionnaires() {
        return new ArrayList<>(gestionnaires); 
    }

    public Gestionnaire inscrireGestionnaire(String nom, String prenom, String email, String motPasse, String departement) {
        
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
        if (departement == null || departement.trim().isEmpty()) {
            throw new IllegalArgumentException("Le département ne peut pas être vide");
        }

        boolean emailExists = gestionnaires.stream()
                .anyMatch(g -> g.getEmail().equals(email));
        
        if (emailExists) {
            throw new IllegalStateException("Un gestionnaire avec cet email existe déjà");
        }

        Gestionnaire nouveauGestionnaire = new Gestionnaire(nom, prenom, email, motPasse, departement);
        gestionnaires.add(nouveauGestionnaire);
        return nouveauGestionnaire;
    }

    public Optional<Gestionnaire> authentifierGestionnaire(String email, String motPasse) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("L'email ne peut pas être vide");
        }
        if (motPasse == null || motPasse.trim().isEmpty()) {
            throw new IllegalArgumentException("Le mot de passe ne peut pas être vide");
        }

        return gestionnaires.stream()
                .filter(g -> g.getEmail().equals(email) && g.getMotPasse().equals(motPasse))
                .findFirst();
    }

    public Optional<Client> authentifierClient(String email, String motPasse) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("L'email ne peut pas être vide");
        }
        if (motPasse == null || motPasse.trim().isEmpty()) {
            throw new IllegalArgumentException("Le mot de passe ne peut pas être vide");
        }

        return clients.stream()
                .filter(client -> client.getEmail().equals(email) && client.getMotPasse().equals(motPasse))
                .findFirst();
    }

    public void inscrireClient(String nom, String prenom, String email, String motPasse) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("L'email ne peut pas être vide");
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
