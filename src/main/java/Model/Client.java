package Model;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int client_id;
    private String nom;
    private String email;
    private String telephone;
    private String type_client;
    private String organisation;

    public Client (){}
    public Client(int client_id, String nom, String email, String telephone,String type_client, String organisation){
        this.client_id=client_id;
        this.nom=nom;
        this.email=email;
        this.telephone=telephone;
        this.type_client=type_client;
        this.organisation=organisation;

    }

    // Relation OneToMany avec Reservation
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @JsonbTransient   // ← CETTE LIGNE SAUVE TOUT
    private List<Reservation> reservations;
    @JsonbProperty("client_id")   // ← ET ÇA AUSSI
    public int getClient_id() {
        return client_id;
    }
    @JsonbProperty("client_id")   // ← ET ÇA AUSSI
    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getType_client() {
        return type_client;
    }

    public void setType_client(String type_client) {
        this.type_client = type_client;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }
    @JsonbTransient
    public List<Reservation> getReservations() { return reservations; }
    public void setReservations(List<Reservation> reservations) { this.reservations = reservations; }

}

