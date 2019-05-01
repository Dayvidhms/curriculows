package ws;

import com.google.gson.Gson;
import controller.Usuario;
import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.UsuarioDAO;

@Path("usuario")
public class UsuarioResource {

    @Context
    private UriInfo context;

    public UsuarioResource() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        throw new UnsupportedOperationException();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @POST
    @Consumes("application/json")
    @Path("/postInsert")
    public void inserirUsuario(String usuario) throws SQLException {
        Gson gson = new Gson();
        Usuario usuarioResultado;

        usuarioResultado = (Usuario) gson.fromJson(usuario, Usuario.class);

        UsuarioDAO dao = new UsuarioDAO();
        dao.insertUser(usuarioResultado);
    }

}
