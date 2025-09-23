package model;

import model.enums.Role;

import java.util.ArrayList;
import java.util.UUID;

public class Client extends Personne {
   private String Uuid;
   private ArrayList<Compte> comptes;


    public Client(String nom, String prenom, String email, String motPasse, Role role) {
        super(nom, prenom, email, motPasse, role);
        this.Uuid = UUID.randomUUID().toString();
        this.comptes = new ArrayList<>();
    }

    public String getUuid() {
        return Uuid;
    }

    public void setUuid(String uuid) {
        Uuid = uuid;
    }

    public ArrayList<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(ArrayList<Compte> comptes) {
        this.comptes = comptes;
    }

    @Override
    public String toString() {
        return super.toString() + "id" + this.Uuid + "comptes" + this.comptes;
    }
}
