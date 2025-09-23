package model;

import model.enums.TypeTransaction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class Transaction {
    private String IdTransaction;
    private BigDecimal montant;
    private Date date;
    private Compte compteDestination;
    private TypeTransaction typeTransaction;

    public Transaction(BigDecimal montant, Compte compteDestination, TypeTransaction typeTransaction) {
        this.IdTransaction = UUID.randomUUID().toString();
        this.montant = montant;
        this.date = new Date();
        this.compteDestination = compteDestination;
        this.typeTransaction = typeTransaction;
    }

    public String getIdTransaction() {
        return IdTransaction;
    }

    public void setIdTransaction(String idTransaction) {
        IdTransaction = idTransaction;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Compte getCompteDestination() {
        return compteDestination;
    }

    public void setCompteDestination(Compte compteDestination) {
        this.compteDestination = compteDestination;
    }

    public TypeTransaction getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(TypeTransaction typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "IdTransaction='" + IdTransaction + '\'' +
                ", montant=" + montant +
                ", date=" + date +
                ", compteDestination=" + compteDestination +
                ", typeTransaction=" + typeTransaction +
                '}';
    }
}
