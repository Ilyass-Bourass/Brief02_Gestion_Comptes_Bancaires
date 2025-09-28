package controller;

import java.util.List;

import model.Compte;
import service.CompteService;

public class CompteController {
    private CompteService compteService;

    public CompteController(CompteService compteService){
        this.compteService=compteService;
    }

    public List<Compte> listeComptes(){
        return compteService.getAllComptes();
    }

    public void afficherListeComptes(){
        List <Compte> comptes =listeComptes();

        if(comptes.isEmpty()){
            System.out.println("Aucun compte dans la liste");
            return;
        }

        System.out.println("\n=== Liste comptes pour le client ===");
        System.out.println("--------------------------------------");
        for(Compte c:comptes){
            System.out.println("IdCompte : "+c.getIdCompte());
            System.out.println("Type compte: "+c.getTypeCompte());
            System.out.println("Solde"+c.getSolde());
            System.out.println("--------------------------------------");
        }

    }

}
