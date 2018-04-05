/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EndPointsVentas;

import datos.ClienteDAO;
import datos.RegionesDAO;
import datos.VentaDAO;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import negocio.Cliente;
import negocio.Regiones;
import negocio.Venta;
import org.json.simple.JSONObject;
import util.RHException;
import util.Util;

/**
 *
 * @author sebastianbd
 */
@Path("verVenta")
public class VerVenta extends Util {
       @GET    
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject verVenta(@QueryParam("user") String usuario, @QueryParam("pass") String password,@QueryParam("cod") String codigo,
                                @QueryParam("fecha") String fecha, @QueryParam("precio") String precio)throws RHException, Exception{
        JSONObject obj2 = new JSONObject();
         try{
        conectarBD(usuario,password);
        VentaDAO ventasDAO = new VentaDAO();
        Venta venta = ventasDAO.traeVenta("\'"+ fecha + "\'","\'"+ codigo + "\'","\'"+ precio+"\'" );
            obj2.put("codigo", venta.getCodigo());
        return obj2;
        }catch(Exception e){
            obj2.put("error", e.getMessage());
            return obj2;
        }
    }
    
}
