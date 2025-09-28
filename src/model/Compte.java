package model;

import model.enums.TypeCompte;
import java.util.ArrayList;


import java.math.BigDecimal;
import java.util.UUID;

public class Compte {
    private String idClient;
    private String idCompte;
    private TypeCompte typeCompte;
    private BigDecimal solde;

    public Compte(String idClient, TypeCompte typeCompte, BigDecimal solde) {
        this.idClient = idClient;
        this.typeCompte = typeCompte;
        this.solde = solde;
        this.idCompte = UUID.randomUUID().toString();
        this.typeCompte = typeCompte;
        this.solde = solde;
    }

    public String getIdClient() {
        return idClient;
    }
    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(String idCompte) {
        this.idCompte = idCompte;
    }

    public TypeCompte getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(TypeCompte typeCompte) {
        this.typeCompte = typeCompte;
    }

    public BigDecimal getSolde() {
        return solde;
    }

    public void setSolde(BigDecimal solde) {
        this.solde = solde;
    }

    

    @Override
    public String toString() {
        return "Compte{" +
                "idCClient='" + idClient + '\'' +
                "idCompte='" + idCompte + '\'' +
                ", typeCompte=" + typeCompte +
                ", solde=" + solde +
                '}';
    }
}
