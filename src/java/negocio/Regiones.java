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
public class Regiones {
    private ArrayList<String> codigo;
    private ArrayList<String> nombre;
    private ArrayList<String> cod_pais;

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

    public ArrayList<String> getCod_pais() {
        return cod_pais;
    }

    public void setCod_pais(ArrayList<String> cod_pais) {
        this.cod_pais = cod_pais;
    }

    
    
}
