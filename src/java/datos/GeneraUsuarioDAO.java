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
import negocio.Privilegio;
import util.RHException;
import util.ServiceLocator;

/**
 *
 * @author sebastianbd
 */
public class GeneraUsuarioDAO {
     public void crearCliente(String cliente) throws RHException, Exception {
      try {
          //TODO buscar consulta de privs
          System.out.println(cliente);
        String strSQL = "CREATE USER "+ cliente + "  IDENTIFIED BY  "+ cliente + 
                        " DEFAULT TABLESPACE DEFAULT_USER " +
                        "QUOTA 1M ON DEFAULT_USER";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        prepStmt.executeQuery();
           System.out.println("Se creo el usuario");
      } catch (SQLException e) {
           throw new RHException( "RegistroDAO", "Error: "+ e.getMessage());
      }  finally {
         ServiceLocator.getInstance().liberarConexion();
      }      
    }
     
    public void darPermisos(String cliente) throws RHException, Exception {
      try {
          //TODO buscar consulta de privs
        String strSQL = "GRANT CONNECT, R_CLIENTE TO " + cliente;
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        ResultSet rs = prepStmt.executeQuery();
           
      } catch (SQLException e) {
           throw new RHException( "RegistroDAO", "Error: "+ e.getMessage());
      }  finally {
         ServiceLocator.getInstance().liberarConexion();
      }      
    }
}
