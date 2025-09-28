package service;

import model.Compte;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import model.enums.TypeCompte;

public class CompteService {
    private List<Compte> comptes;

    public CompteService() {
        this.comptes = new ArrayList<>();
    }

    public Compte ajouterCompte(String idClient,String typeCompte, BigDecimal solde) {  
        if (idClient == null || idClient.trim().isEmpty()) {
            throw new IllegalArgumentException("L'ID du client ne peut pas être vide");
        }
        if (typeCompte == null || typeCompte.trim().isEmpty()) {
            throw new IllegalArgumentException("Le type de compte ne peut pas être vide");
        }
        if (solde == null) {
            throw new IllegalArgumentException("Le solde ne peut pas être vide");
        }
        Compte nouveauCompte = new Compte(idClient, TypeCompte.valueOf(typeCompte), solde);
        comptes.add(nouveauCompte);
        return nouveauCompte;
    }

    public List<Compte> getAllComptes() {
        return new ArrayList<>(comptes);
    }

    // Méthode pour obtenir les comptes d'un client spécifique
    public List<Compte> getComptesByClientId(String idClient) {
        List<Compte> comptesClient = new ArrayList<>();
        for (Compte compte : comptes) {
            if (compte.getIdClient().equals(idClient)) {
                comptesClient.add(compte);
            }
        }
        return comptesClient;
    }
}
