package Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import DAO.ChambreDAO;
import Model.Chambre;

import java.time.LocalDate;
import java.util.List;
@Path("/chambres")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ChambreController {
    ChambreDAO dao = new ChambreDAO();

    @Path("/ListCH")
    @GET
    public List<Chambre> getAll() {
        return dao.getAllChambres();
    }

    @GET
    @Path("/consult/{id}")
    public Chambre getById(@PathParam("id") int id) {
        return dao.getChambre(id);
    }

    @POST
    @Path("/addCH")
    public void add(Chambre c) {
        dao.addChambre(c);
    }

    @PUT
    @Path("/modifyCH")
    public void update(Chambre c) {
        dao.updateChambre(c);
    }

    @DELETE
    @Path("/delete/{id}")
    public void delete(@PathParam("id") int id) {
        dao.deleteChambre(id);
    }


}
