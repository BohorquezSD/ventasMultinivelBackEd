/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;

/**
 *
 * @author sebastianbd
 */
public class Categorias {
    private ArrayList<String> codigo;
    private ArrayList<String> nombre;
    private ArrayList<String> descripcion;

    public ArrayList<String> getCodigo() {
        return codigo;
    }

    public void setCodigo(ArrayList<String> codigo) {
        this.codigo = codigo;
    }

    public ArrayList<String> getNombre() {
        return nombre;
    }

    public void setNombre(ArrayList<String> nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(ArrayList<String> descripcion) {
        this.descripcion = descripcion;
    }

 
}
