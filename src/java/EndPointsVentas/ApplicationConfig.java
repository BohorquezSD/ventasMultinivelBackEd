/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EndPointsVentas;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author sebastianbd
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(EndPointsVentas.ActualizaStock.class);
        resources.add(EndPointsVentas.Login.class);
        resources.add(EndPointsVentas.Logout.class);
        resources.add(EndPointsVentas.RegistrarCliente.class);
        resources.add(EndPointsVentas.RegistrarVenta.class);
        resources.add(EndPointsVentas.RegistrarVentaProd.class);
        resources.add(EndPointsVentas.VerCategorias.class);
        resources.add(EndPointsVentas.VerClientes.class);
        resources.add(EndPointsVentas.VerPrivilegios.class);
        resources.add(EndPointsVentas.VerProductos.class);
        resources.add(EndPointsVentas.VerRegiones.class);
        resources.add(EndPointsVentas.VerRepVentas.class);
        resources.add(EndPointsVentas.VerRoles.class);
        resources.add(EndPointsVentas.VerVenta.class);
    }
    
}
