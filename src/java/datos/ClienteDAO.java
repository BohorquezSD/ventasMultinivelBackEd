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
import negocio.Role;
import util.RHException;
import util.ServiceLocator;

/**
 *
 * @author sebastianbd
 */
public class ClienteDAO {
    public Cliente regCliente(Cliente cliente, String rep_asociado) throws RHException, Exception {
      try {
        String strSQL = "INSERT  INTO CLIENTE VALUES (\'"+ cliente.getCodigo()+"\',\' "+cliente.getNombre() + " "
                        + "\',\' "+cliente.getApellido()+"\',\' "+cliente.getDireccion()+"\',\' "+ cliente.getCiudad()
                        +"\' ,\' "+cliente.getTelefono()+"\',\' "+cliente.getCorreo()+"\' ,\'"+rep_asociado+ "\')";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
          PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        prepStmt.executeUpdate();
        prepStmt.close();
        ServiceLocator.getInstance().commit();
            
        return cliente;
      } catch (SQLException e) {
           throw new RHException( "ClienteDAO", "Error: "+ e.getMessage());
      }  finally {
         ServiceLocator.getInstance().liberarConexion();
      }      
    }
    
    public Cliente verCliente(String rep) throws RHException, Exception {
        Cliente cliente = new Cliente();
      try {
        String strSQL = "SELECT  * FROM  CLIENTE where N_NOMBRE = INITCAP(" + rep + ")";
          Connection conexion = ServiceLocator.getInstance().tomarConexion();
          PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
          ResultSet rs = prepStmt.executeQuery();
            rs.next();
            cliente.setCodigo(rs.getString(1));
            cliente.setNombre(rs.getString(2));
            cliente.setApellido(rs.getString(3));
            cliente.setCorreo(rs.getString(7));
            cliente.setTelefono(rs.getString(6));
            cliente.setDireccion(rs.getString(4));
            cliente.setCiudad(rs.getString(5));
        return cliente;
      } catch (SQLException e) {
           throw new RHException( "ClienteDAO", "Error: "+ e.getMessage());
      }  finally {
         ServiceLocator.getInstance().liberarConexion();
      }      
    }
}
