/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import negocio.VentaProd;
import util.RHException;
import util.ServiceLocator;

/**
 *
 * @author sebastianbd
 */
public class VentaProdDAO {
    public VentaProd regVenta(VentaProd ventaProd) throws RHException, Exception {
      try {
        String strSQL = "INSERT INTO PRODUCTO_VENTA VALUES(\'"+ventaProd.getProducto()+ "\'"
                        + ",\'"+ventaProd.getVenta()+"\',\'"+ ventaProd.getCantidad()+"\')";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
          PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        prepStmt.executeUpdate();
        prepStmt.close();
        ServiceLocator.getInstance().commit();
            
        return ventaProd;
      } catch (SQLException e) {
           throw new RHException( "VentaProdDAO", "Error: "+ e.getMessage());
      }  finally {
         ServiceLocator.getInstance().liberarConexion();
      }      
    }
}
