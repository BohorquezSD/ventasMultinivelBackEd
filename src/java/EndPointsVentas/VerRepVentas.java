/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EndPointsVentas;


import datos.RepVentasDAO;
import java.sql.Array;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import negocio.RepVentas;
import org.json.simple.JSONObject;
import util.RHException;
import util.Util;

/**
 *
 * @author sebastianbd
 */
@Path("verRepVentas")
public class VerRepVentas extends Util {
    
     @GET    
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject verRoles(@QueryParam("user") String usuario, @QueryParam("pass") String password, @QueryParam("search") String search)throws RHException, Exception{
        JSONObject obj= new JSONObject();
        JSONObject obj2 = new JSONObject();
         try{
        conectarBD(usuario,password);
        RepVentasDAO repDao = new RepVentasDAO();
         RepVentas representante = repDao.verRepVentas("\'"+ search +"\'");
        
            obj.put("codigo", representante.getCodigo());
            obj.put("nombre", representante.getNombre());
            obj.put("apellido", representante.getApellido());
            obj.put("correo",representante.getCorreo());
            obj.put("genero",representante.getGenero());
            obj.put("fechaNac",representante.getFechaNac());
            obj.put("fechaCon",representante.getFechaCon());
            obj.put("telefono",representante.getTelefono());
            obj.put("direccion",representante.getDireccion());
            
        obj2.put("representante", obj);
        return obj2;
        }catch(Exception e){
            obj2.put("error", e.getMessage());
            return obj2;
        }
    }
    
}