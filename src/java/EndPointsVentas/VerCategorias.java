/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EndPointsVentas;

import datos.CategoriasDAO;
import datos.RegionesDAO;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import negocio.Categorias;
import negocio.Regiones;
import org.json.simple.JSONObject;
import util.RHException;
import util.Util;

/**
 *
 * @author sebastianbd
 */
@Path("verCategorias")
public class VerCategorias extends Util {
     @GET    
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject verRegiones(@QueryParam("user") String usuario, @QueryParam("pass") String password)throws RHException, Exception{
        ArrayList obj= new ArrayList();
        JSONObject obj2 = new JSONObject();
         try{
        conectarBD(usuario,password);
        CategoriasDAO categoriasDAO = new CategoriasDAO();
        Categorias categorias = categoriasDAO.verCategorias();
        
        for(int i=0; i<categorias.getNombre().size(); i++){
            JSONObject rol = new JSONObject();
            rol.put("nombre", categorias.getNombre().get(i));
            obj.add(rol);
        }
            obj2.put("categorias", obj);
        return obj2;
        }catch(Exception e){
            obj2.put("error", e.getMessage());
            return obj2;
        }
    }
    
}
