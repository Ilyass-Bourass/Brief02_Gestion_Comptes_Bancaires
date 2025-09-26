package model;

import model.enums.Role;

import java.util.UUID;

public class Client extends Personne {
   private String Uuid;


    public Client(String nom, String prenom, String email, String motPasse) {
        super(nom, prenom, email, motPasse, Role.CLIENT);
        this.Uuid = UUID.randomUUID().toString();
    }

    public String getUuid() {
        return Uuid;
    }

    public void setUuid(String uuid) {
        Uuid = uuid;
    }



    @Override
    public String toString() {
        return "id" + this.Uuid + "client: "+super.toString() ;
    }
}
