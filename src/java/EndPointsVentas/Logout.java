/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EndPointsVentas;


import util.Util;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import util.RHException;
import org.json.simple.JSONObject;
import util.ServiceLocator;

/**
 *
 * @author sebastianbd
 */
@Path("logout")
public class Logout extends Util{
    
  
   
    @GET    
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject cerrarSesion(@QueryParam("user") String usuario, @QueryParam("pass") String password)throws RHException{
         JSONObject obj = new JSONObject();
        try{
            cerrarConexion();
            obj.put("estado", "Cerrada la conexion ");
            return obj;
        }catch(Exception e){
            obj.put("estado", e.getMessage());
            return obj;
        }
    }
}    