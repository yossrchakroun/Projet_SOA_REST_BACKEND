package Controller;

import Model.Chambre;
import Model.Client;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import DAO.ReservationDAO;
import DAO.ClientDAO;
import DAO.ChambreDAO;
import Model.Reservation;
import java.util.List;

@Path("/Reservations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReservationController {

    private final ReservationDAO reservationDAO = new ReservationDAO();
    private final ClientDAO clientDAO = new ClientDAO();
    private final ChambreDAO chambreDAO = new ChambreDAO();

    @GET
    public List<Reservation> getAll() {
        return reservationDAO.getAllReservations();
    }

    @GET
    @Path("/consultRes/{id}")
    public Reservation getById(@PathParam("id") int id) {
        return reservationDAO.getReservation(id);
    }

    @POST
    @Path("/addRes")
    public Response add(Reservation r) {
        if (r.getClientId() == null || r.getChambreId() == null) {
            return Response.status(400).entity("clientId ou chambreId manquant").build();
        }

        Client client = clientDAO.getClient(r.getClientId());
        Chambre chambre = chambreDAO.getChambre(r.getChambreId());

        if (client == null || chambre == null) {
            return Response.status(404).entity("Client ou chambre introuvable").build();
        }

        r.setClient(client);
        r.setChambre(chambre);

        reservationDAO.addReservation(r);
        return Response.status(201).entity("Réservation ajoutée avec succès !").build();
    }

    @PUT
    @Path("/ModifyRes")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Reservation r) {

        // 1. Récupère la réservation existante depuis la base
        Reservation existing = reservationDAO.getReservation(r.getReservation_id());
        if (existing == null) {
            return Response.status(404).entity("Réservation non trouvée").build();
        }

        // 2. Met à jour les champs simples
        existing.setDateDebut(r.getDateDebut());
        existing.setDateFin(r.getDateFin());
        existing.setTotal(r.getTotal());
        existing.setStatus(r.getStatus());

        // 3. Si les IDs sont fournis → recharge les entités
        if (r.getClientId() != null) {
            Client client = clientDAO.getClient(r.getClientId());
            if (client == null) return Response.status(404).entity("Client introuvable").build();
            existing.setClient(client);
        }

        if (r.getChambreId() != null) {
            Chambre chambre = chambreDAO.getChambre(r.getChambreId());
            if (chambre == null) return Response.status(404).entity("Chambre introuvable").build();
            existing.setChambre(chambre);
        }

        // 4. Sauvegarde
        reservationDAO.updateReservation(existing);

        return Response.ok("Réservation modifiée avec succès !").build();
    }

    @DELETE
    @Path("/deleteRes/{id}")
    public Response delete(@PathParam("id") int id) {
        reservationDAO.deleteReservation(id);
        return Response.ok("Réservation supprimée").build();
    }
}