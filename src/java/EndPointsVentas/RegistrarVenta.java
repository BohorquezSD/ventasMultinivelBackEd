/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EndPointsVentas;

import datos.ClienteDAO;
import datos.GeneraUsuarioDAO;
import datos.VentaDAO;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import negocio.Cliente;
import negocio.Venta;
import org.json.simple.JSONObject;
import util.RHException;
import util.Util;

/**
 *
 * @author sebastianbd
 */
@Path("regVenta")
public class RegistrarVenta extends Util {
    
    @POST    
    @Consumes(MediaType.APPLICATION_JSON)
    public JSONObject regCliente (@QueryParam("user") String usuario, @QueryParam("pass") String password, 
            @QueryParam("fecha") String fecha,@QueryParam("precioFinal") String precioFinal,
            @QueryParam("estado") String estado, @QueryParam("cedula") String cedula )throws RHException, Exception{
        
        conectarBD(usuario,password);
        VentaDAO ventaDao = new VentaDAO();
        JSONObject obj = new JSONObject();
        Venta venta = new Venta();
        try{
            venta.setFecha(fecha);
            venta.setPrecioFinal(precioFinal);
            venta.setEstado(estado);
            venta=ventaDao.regVenta(venta, cedula);
        
        obj.put("estado", "Venta registrada");
        return obj;
        }catch(Exception e){
            obj.put("error", e.getMessage());
            return obj;
        }
         
    } 
}


