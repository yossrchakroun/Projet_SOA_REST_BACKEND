package Model;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservation_id;

    @Column(name = "date_debut")
    private LocalDate dateDebut;

    @Column(name = "date_fin")
    private LocalDate dateFin;

    private double total;

    @Column(name = "statut")
    private String status;

    // ON GARDE LES RELATIONS POUR HIBERNATE
    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonbTransient
    private Client client;

    @ManyToOne
    @JoinColumn(name = "chambre_id")
    @JsonbTransient
    private Chambre chambre;

    // ON AJOUTE LES IDs POUR LE JSON (c’est ce que tu veux !)
    @Transient  // ← pas en base, juste pour le JSON
    private int clientId;

    @Transient
    private int chambreId;

    // GETTERS & SETTERS
    public int getReservation_id() { return reservation_id; }
    public void setReservation_id(int reservation_id) { this.reservation_id = reservation_id; }

    public LocalDate getDateDebut() { return dateDebut; }
    public void setDateDebut(LocalDate dateDebut) { this.dateDebut = dateDebut; }

    public LocalDate getDateFin() { return dateFin; }
    public void setDateFin(LocalDate dateFin) { this.dateFin = dateFin; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public Chambre getChambre() { return chambre; }
    public void setChambre(Chambre chambre) { this.chambre = chambre; }

    // LES IDs POUR LE JSON
    public Integer getClientId() {
        return client != null ? client.getClient_id() : clientId;
    }
    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getChambreId() {
        return chambre != null ? chambre.getChambre_id() : chambreId;
    }
    public void setChambreId(Integer chambreId) {
        this.chambreId = chambreId;
    }
}