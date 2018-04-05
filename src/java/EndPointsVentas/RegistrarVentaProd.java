/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EndPointsVentas;

import datos.VentaDAO;
import datos.VentaProdDAO;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import negocio.Venta;
import negocio.VentaProd;
import org.json.simple.JSONObject;
import util.RHException;
import util.Util;

/**
 *
 * @author sebastianbd
 */
@Path("regVentaProd")
public class RegistrarVentaProd extends Util {
    
    @POST    
    @Consumes(MediaType.APPLICATION_JSON)
    public JSONObject regCliente (@QueryParam("user") String usuario, @QueryParam("pass") String password, 
            @QueryParam("producto") String producto,@QueryParam("venta") String venta,
            @QueryParam("cantidad") String cantidad)throws RHException, Exception{
        
        conectarBD(usuario,password);
        VentaProdDAO ventaDao = new VentaProdDAO();
        JSONObject obj = new JSONObject();
        VentaProd ventaProd = new VentaProd();
        try{
            ventaProd.setProducto(producto);
            ventaProd.setVenta(venta);
            ventaProd.setCantidad(cantidad);
            ventaProd=ventaDao.regVenta(ventaProd);
        
        obj.put("estado", "VentaProd registrada");
        return obj;
        }catch(Exception e){
            obj.put("error", e.getMessage());
            return obj;
        }
         
    } 
}