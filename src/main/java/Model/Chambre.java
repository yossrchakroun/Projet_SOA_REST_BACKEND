package Model;


import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "chambre")
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chambre_id;
    private String numero;
    private String type_chambre;
    private long capacite;
    private double prix_par_jour;
    private String equipements;
    @Column(name = "statut")
    private String status; // disponible / occupée
    private String description;

    @OneToMany(mappedBy = "chambre", cascade = CascadeType.ALL)
    @JsonbTransient
    private List<Reservation> reservations;

    // Getters & Setters
    @JsonbProperty("chambre_id")   // ← ET ÇA AUSSI
    public int getChambre_id() { return chambre_id; }
    @JsonbProperty("chambre_id")   // ← ET ÇA AUSSI
    public void setChambre_id(int id) { this.chambre_id = chambre_id; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getType_chambre() { return type_chambre; }
    public void setType_chambre(String type_chambre) { this.type_chambre = type_chambre; }

    public double getPrix_par_jour() { return prix_par_jour; }
    public void setPrix_par_jour(double prix_par_jour) { this.prix_par_jour = prix_par_jour; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public long getCapacite() {
        return capacite;
    }

    public void setCapacite(long capacite) {
        this.capacite = capacite;
    }

    public String getEquipements() {
        return equipements;
    }

    public void setEquipements(String equipements) {
        this.equipements = equipements;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Reservation> getReservations() { return reservations; }
    public void setReservations(List<Reservation> reservations) { this.reservations = reservations; }
}

