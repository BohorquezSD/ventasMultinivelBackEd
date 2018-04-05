/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EndPointsVentas;

/**
 *
 * @author sebastianbd
 */
import datos.RegionesDAO;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import negocio.Regiones;
import org.json.simple.JSONObject;
import util.RHException;
import util.Util;

/**
 *
 * @author sebastianbd
 */
@Path("verRegiones")
public class VerRegiones extends Util {
    
     @GET    
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject verRegiones(@QueryParam("user") String usuario, @QueryParam("pass") String password)throws RHException, Exception{
        ArrayList obj= new ArrayList();
        JSONObject obj2 = new JSONObject();
         try{
        conectarBD(usuario,password);
        RegionesDAO regDAO = new RegionesDAO();
        Regiones regiones = regDAO.verRegiones();
        
        for(int i=0; i<regiones.getNombre().size(); i++){
            JSONObject rol = new JSONObject();
            rol.put("codigo", regiones.getCodigo().get(i));
            rol.put("nombre", regiones.getNombre().get(i));
            obj.add(rol);
        }
            obj2.put("regiones", obj);
        return obj2;
        }catch(Exception e){
            obj2.put("error", e.getMessage());
            return obj2;
        }
    }
    
}