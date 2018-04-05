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
import negocio.Categorias;
import negocio.Regiones;
import util.RHException;
import util.ServiceLocator;

/**
 *
 * @author sebastianbd
 */
public class CategoriasDAO {
    public Categorias verCategorias() throws RHException, Exception {
        Categorias categoria = new Categorias();
      try {
          //TODO buscar consulta de privs
        String strSQL = "SELECT  * FROM  V_CATEGORIA ";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        ResultSet rs = prepStmt.executeQuery();
            
            ArrayList<String> nombre= new ArrayList<>();
            int i=0;
            if(rs!= null){
                while(rs.next()== true) {
                   nombre.add(rs.getString("N_NOMBRE"));
                   i++;
                }
                
            }
            categoria.setNombre(nombre);
        return categoria;
      } catch (SQLException e) {
           throw new RHException( "CategoriasDAO", "Error: "+ e.getMessage());
      }  finally {
         ServiceLocator.getInstance().liberarConexion();
      }      
    }
}
