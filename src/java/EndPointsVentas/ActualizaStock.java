/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EndPointsVentas;

import datos.ProductoRegionDAO;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import negocio.ProductoRegion;
import org.json.simple.JSONObject;
import util.RHException;
import util.Util;

/**
 *
 * @author sebastianbd
 */
@Path("actualizarStock")
public class ActualizaStock extends Util {
    
    @POST    
    @Consumes(MediaType.APPLICATION_JSON)
    public JSONObject actualizaStock (@QueryParam("user") String usuario, @QueryParam("pass") String password, 
            @QueryParam("producto") String producto,@QueryParam("region") String region,
            @QueryParam("stock") String cantidad)throws RHException, Exception{
        
        conectarBD(usuario,password);
        ProductoRegionDAO prodRegDao = new ProductoRegionDAO();
        JSONObject obj = new JSONObject();
        ProductoRegion prodReg = new ProductoRegion();
        try{
            prodReg.setProducto(producto);
            prodReg.setRegion(region);
            prodReg.setStock(cantidad);
            prodReg=prodRegDao.actualizarStock(prodReg);
        
        obj.put("estado", "ProdRegion actualizado");
        return obj;
        }catch(Exception e){
            obj.put("error", e.getMessage());
            return obj;
        }
         
    } 
}
