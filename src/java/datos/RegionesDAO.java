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
import negocio.Regiones;
import util.RHException;
import util.ServiceLocator;

/**
 *
 * @author sebastianbd
 */
public class RegionesDAO {

     public Regiones verRegiones() throws RHException, Exception {
        Regiones region = new Regiones();
      try {
          //TODO buscar consulta de privs
        String strSQL = "SELECT  * FROM  REGION ";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        ResultSet rs = prepStmt.executeQuery();
            ArrayList<String> codigo= new ArrayList<>();
            ArrayList<String> nombre= new ArrayList<>();
            int i=0;
            if(rs!= null){
                while(rs.next()== true) {
                   codigo.add(rs.getString("K_CODREGION"));
                   nombre.add(rs.getString("N_NOMBRE"));
                   i++;
                }
                
            }
            region.setNombre(nombre);
            region.setCodigo(codigo);
        return region;
      } catch (SQLException e) {
           throw new RHException( "RegionesDAO", "Error: "+ e.getMessage());
      }  finally {
         ServiceLocator.getInstance().liberarConexion();
      }      
    }
}    