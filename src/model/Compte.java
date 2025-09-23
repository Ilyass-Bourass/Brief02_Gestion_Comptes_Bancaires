package model;

import model.enums.TypeCompte;
import java.util.ArrayList;


import java.math.BigDecimal;
import java.util.UUID;

public class Compte {
    private String idCompte;
    private TypeCompte typeCompte;
    private BigDecimal solde;
    private  ArrayList<Transaction> transactions;

    public Compte(TypeCompte typeCompte, BigDecimal solde, ArrayList<Transaction> transactions) {
        this.idCompte = UUID.randomUUID().toString();
        this.typeCompte = typeCompte;
        this.solde = solde;
        this.transactions = transactions;
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

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "idCompte='" + idCompte + '\'' +
                ", typeCompte=" + typeCompte +
                ", solde=" + solde +
                ", transactions=" + transactions +
                '}';
    }
}
