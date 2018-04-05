/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import negocio.Cliente;
import negocio.ProductoRegion;
import util.RHException;
import util.ServiceLocator;

/**
 *
 * @author sebastianbd
 */
public class ProductoRegionDAO {
     public ProductoRegion actualizarStock(ProductoRegion prodReg) throws RHException, Exception {
      try {
        String strSQL = "UPDATE PRODUCTO_REGION SET Q_STOCK =\'"+prodReg.getStock()+"\' WHERE K_PRODUCTO =\'"+prodReg.getProducto()+"\' "
                + " AND K_REGION= \'"+prodReg.getRegion()+"\'";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
          PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        prepStmt.executeUpdate();
        prepStmt.close();
        ServiceLocator.getInstance().commit();
            
        return prodReg;
      } catch (SQLException e) {
           throw new RHException( "ProdRegionDAO", "Error: "+ e.getMessage());
      }  finally {
         ServiceLocator.getInstance().liberarConexion();
      }      
    }
}
