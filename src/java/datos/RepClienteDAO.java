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
import negocio.Cliente;
import negocio.RepCliente;
import util.RHException;
import util.ServiceLocator;

public class RepClienteDAO {

    public void regRepCliente(RepCliente repCli) throws RHException, Exception {
      try {
        String strSQL = "INSERT INTO REPRESENTANTE_CLIENTE VALUES(\'"+ repCli.getIdRep()+"\',\' "+repCli.getIdCli() + " "
                        + "\', "+repCli.getFechaInicio()+", "+repCli.getFechaFin()+",  "+"NULL"+")";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        prepStmt.executeUpdate();
        prepStmt.close();
        ServiceLocator.getInstance().commit();
            
      } catch (SQLException e) {
           throw new RHException( "ClienteDAO", "Erroraca: "+ e.getMessage());
      }  finally {
         ServiceLocator.getInstance().liberarConexion();
      }      
    }
    
    
}
