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
import negocio.RepVentas;
import negocio.Role;
import util.RHException;
import util.ServiceLocator;

/**
 *
 * @author sebastianbd
 */
public class RepVentasDAO {
    public RepVentas verRepVentas(String rep) throws RHException, Exception {
        RepVentas representante = new RepVentas();
      try {
        String strSQL = "SELECT  * FROM  REP_VENTAS where N_NOMBRE = INITCAP(" + rep + ")";
          Connection conexion = ServiceLocator.getInstance().tomarConexion();
          PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
          ResultSet rs = prepStmt.executeQuery();
            rs.next();
            representante.setCodigo(rs.getString(1));
            representante.setNombre(rs.getString(2));
            representante.setApellido(rs.getString(3));
            representante.setCorreo(rs.getString(4));
            representante.setGenero(rs.getString(5));
            representante.setFechaNac(rs.getString(6));
            representante.setFechaCon(rs.getString(7));
            representante.setTelefono(rs.getString(8));
            representante.setDireccion(rs.getString(9));
        return representante;
      } catch (SQLException e) {
           throw new RHException( "RepVentasDAO", "Error: "+ e.getMessage());
      }  finally {
         ServiceLocator.getInstance().liberarConexion();
      }      
    }
    
}
