/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EndPointsVentas;

import datos.ClienteDAO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import negocio.Cliente;
import org.json.simple.JSONObject;
import util.RHException;
import util.Util;

/**
 *
 * @author sebastianbd
 */
@Path("verClientes")
public class VerClientes extends Util {
       @GET    
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject verRoles(@QueryParam("user") String usuario, @QueryParam("pass") String password, @QueryParam("search") String search)throws RHException, Exception{
        JSONObject obj= new JSONObject();
        JSONObject obj2 = new JSONObject();
         try{
        conectarBD(usuario,password);
         ClienteDAO repDao = new ClienteDAO();
         Cliente cliente = repDao.verCliente("\'"+ search +"\'");
        
            obj.put("codigo", cliente.getCodigo());
            obj.put("nombre", cliente.getNombre());
            obj.put("apellido", cliente.getApellido());
            obj.put("direccion",cliente.getDireccion());
            obj.put("ciudad",cliente.getCiudad()); 
            obj.put("telefono",cliente.getTelefono());
            obj.put("correo",cliente.getCorreo());
           
        obj2.put("cliente", obj);
        return obj2;
        }catch(Exception e){
            obj2.put("error", e.getMessage());
            return obj2;
        }
    }
    
}
