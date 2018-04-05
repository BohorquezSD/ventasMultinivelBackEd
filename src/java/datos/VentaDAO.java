/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.Cliente;
import negocio.Regiones;
import negocio.Venta;
import util.RHException;
import util.ServiceLocator;

/**
 *
 * @author sebastianbd
 */
public class VentaDAO {
    public Venta regVenta(Venta venta, String cliente ) throws RHException, Exception {
      try {
          System.out.println("Entro");
        String strSQL = "INSERT  INTO VENTA VALUES (SEQ_VENTA.NEXTVAL ,DATE \'"+venta.getFecha()
                        + "\',\' "+venta.getPrecioFinal()+"\',\'"+venta.getEstado()+"\',\'"+ cliente
                        +"\' )";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
          PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        prepStmt.executeUpdate();
        prepStmt.close();
        ServiceLocator.getInstance().commit();
            
        return venta;
      } catch (SQLException e) {
           throw new RHException( "ClienteDAO", "Error: "+ e.getMessage());
      }  finally {
         ServiceLocator.getInstance().liberarConexion();
      }      
    }
    
     public Venta traeVenta(String fecha, String cliente, String precio) throws RHException, Exception {
       Venta venta = new Venta();
      try {
          System.out.println("ENTRA" + fecha + cliente + precio);
        String strSQL = "SELECT  * FROM  VENTA WHERE F_FECHA = TO_DATE("+ fecha +", \'YYYY-MM-DD\') AND K_CLIENTE ="+cliente+" AND V_PRECIOFINAL="+precio+"";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        ResultSet rs = prepStmt.executeQuery();
            
            String codigo;
            rs.next();
            codigo=rs.getString(1);
                
            venta.setCodigo(codigo);
        return venta; 
         } catch (SQLException e) {
           throw new RHException( "RegionesDAO", "Error: "+ e.getMessage());
      }  finally {
         ServiceLocator.getInstance().liberarConexion();
      }    
    }
}
