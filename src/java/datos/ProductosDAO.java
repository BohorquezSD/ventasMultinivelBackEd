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
import negocio.Productos;
import negocio.Regiones;
import util.RHException;
import util.ServiceLocator;

/**
 *
 * @author sebastianbd
 */
public class ProductosDAO {
    
    public Productos verProductos(String region, String categoria) throws RHException, Exception {
        Productos productos = new Productos();
      try {
          //TODO buscar consulta de privs
        String strSQL = "SELECT P.K_CODPRODUCTO CODIGO , P.N_NOMBRE NOMBRE, P.O_DESCRIPCION DESCRIPCION, "
                + "S.N_NOMBRE SUBCATEGORIA, PRE.V_PRECIO PRECIO, PR.Q_STOCK STOCK FROM MULTINIVEL.PRODUCTO P," 
                +  "MULTINIVEL.SUBCATEGORIA S, MULTINIVEL.CATEGORIA C , MULTINIVEL.REGION R, "
                + "MULTINIVEL.PRODUCTO_REGION PR, MULTINIVEL.PRECIO PRE WHERE P.K_SUBCATEGORIA = S.K_CODSUBCATEGORIA"
                + " AND S.K_CATEGORIA = C.K_CODCATEGORIA AND R.K_CODREGION = PR.K_REGION AND"
                + " P.K_CODPRODUCTO = PR.K_PRODUCTO AND PRE.K_PRODUCTO = P.K_CODPRODUCTO AND "
                + "R.N_NOMBRE= "+region+" AND C.N_NOMBRE = "+categoria+"";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        ResultSet rs = prepStmt.executeQuery();
        
        
            ArrayList<String> codigo = new ArrayList<>();
            ArrayList<String> nombre= new ArrayList<>();
            ArrayList<String> descripcion= new ArrayList<>();
            ArrayList<String> subcategoria= new ArrayList<>();
            ArrayList<String> precio= new ArrayList<>();
            ArrayList<String> stock= new ArrayList<>();
        
            int i=0;
            if(rs!= null){
                while(rs.next()== true) {
                   codigo.add(rs.getString(1)); 
                   nombre.add(rs.getString(2));
                   descripcion.add(rs.getString(3));
                   subcategoria.add(rs.getString(4));
                   precio.add(rs.getString(5));
                   stock.add(rs.getString(6));
                   i++;
                }
                
            }
            productos.setCodigo(codigo);
            productos.setNombre(nombre);
            productos.setSubcategoria(subcategoria);
            productos.setDescripcion(descripcion);
            productos.setPrecio(precio);
            productos.setStock(stock);
        return productos;
      } catch (SQLException e) {
           throw new RHException( "ProductosDAO", "Error: "+ e.getMessage());
      }  finally {
         ServiceLocator.getInstance().liberarConexion();
      }      
    }
}
