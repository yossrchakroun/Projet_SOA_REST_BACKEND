package Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import DAO.ClientDAO;
import Model.Client;
import java.util.List;

@Path("/clients")
public class ClientController {

    private final ClientDAO dao = new ClientDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Client> getAll() {
        return dao.getAllClients();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Client getById(@PathParam("id") long id) {
        return dao.getClient((int) id);
    }

    @POST
    @Path("/ajoutCLT")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Client c) {
        dao.addClient(c);
        return Response.status(201).entity("Client ajouté avec succès").build();
    }

    @PUT
    @Path("/modifCLT")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Client c) {
        dao.updateClient(c);
        return Response.ok("Client modifié").build();
    }

    @DELETE
    @Path("/deleteCLT/{id}")
    public Response delete(@PathParam("id") long id) {
        dao.deleteClient((int) id);
        return Response.ok("Client supprimé").build();
    }
}