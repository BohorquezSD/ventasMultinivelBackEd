/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EndPointsVentas;

import datos.ProductosDAO;
import datos.RegionesDAO;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import negocio.Productos;
import negocio.Regiones;
import org.json.simple.JSONObject;
import util.RHException;
import util.Util;

/**
 *
 * @author sebastianbd
 */
@Path("verProductos")
public class VerProductos extends Util {
    
     @GET    
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject verRegiones(@QueryParam("user") String usuario, @QueryParam("pass") String password, 
            @QueryParam("region") String region, @QueryParam("categoria") String categoria)throws RHException, Exception{
        ArrayList obj= new ArrayList();
        JSONObject obj2 = new JSONObject();
         try{
        conectarBD(usuario,password);
        ProductosDAO productosDAO = new ProductosDAO();
        Productos prod = productosDAO.verProductos("\'"+region+"\'", "\'"+categoria+"\'");
        
        for(int i=0; i<prod.getCodigo().size(); i++){
            JSONObject rol = new JSONObject();
            rol.put("codigo", prod.getCodigo().get(i));
            rol.put("nombre", prod.getNombre().get(i));
            rol.put("descripcion", prod.getDescripcion().get(i));
            rol.put("subcategoria", prod.getSubcategoria().get(i));
            rol.put("precio", prod.getPrecio().get(i));
            rol.put("stock",prod.getStock().get(i));
            obj.add(rol);
        }
            obj2.put("productos", obj);
        return obj2;
        }catch(Exception e){
            obj2.put("error", e.getMessage());
            return obj2;
        }
    
    }
    
}