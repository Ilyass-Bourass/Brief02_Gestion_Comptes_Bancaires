package model;

import model.enums.Role;

import java.util.UUID;

public class Gestionnaire extends Personne {
    private String Uuid;
    private String departement;

    public Gestionnaire(String nom, String prenom, String email, String motPasse, Role role ,String department) {
        super(nom, prenom, email, motPasse, role);
        this.Uuid = UUID.randomUUID().toString();
        this.departement = department;
    }

    public String getUuid() {
        return Uuid;
    }

    public void setUuid(String uuid) {
        Uuid = uuid;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    @Override
    public String toString() {
        return "Gestionnaire{" +
                "Uuid='" + Uuid + '\'' +
                ", departement='" + departement + '\'' +
                '}';
    }
}
