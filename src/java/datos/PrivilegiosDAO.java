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
public class PrivilegiosDAO {
     public Privilegio verPrivilegios(String privilegio) throws RHException, Exception {
        Privilegio priv = new Privilegio();
      try {
          //TODO buscar consulta de privs
        String strSQL = "select a.grantee, b.role, b.privilege from dba_role_privs a full outer join role_tab_privs b on b.role=a.granted_role where a.grantee= UPPER(" + privilegio + ")";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
          PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
          ResultSet rs = prepStmt.executeQuery();
            
            ArrayList<String> grantee= new ArrayList<>();
            ArrayList<String> granted_role = new ArrayList<>();
            ArrayList<String> privilege = new ArrayList<>();
            int i=0;
            if(rs!= null){
                while(rs.next()== true) {
                   grantee.add(rs.getString(1));
                   granted_role.add(rs.getString(2));
                   privilege.add(rs.getString(3));
                   i++;
                }
                
            }
  
              priv.setGrantee(grantee);
              priv.setGrantedRole(granted_role);
              priv.setPrivilege(privilege);
        return priv;
      } catch (SQLException e) {
           throw new RHException( "PrivilegiosDAO", "Error: "+ e.getMessage());
      }  finally {
         ServiceLocator.getInstance().liberarConexion();
      }      
    }
    
}
