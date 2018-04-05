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
public class Privilegio {
    
    private ArrayList grantee;
    private ArrayList grantedRole;
    private ArrayList  privilege;

    public ArrayList getGrantee() {
        return grantee;
    }

    public void setGrantee(ArrayList grantee) {
        this.grantee = grantee;
    }

    public ArrayList getGrantedRole() {
        return grantedRole;
    }

    public void setGrantedRole(ArrayList grantedRole) {
        this.grantedRole = grantedRole;
    }

    public ArrayList getPrivilege() {
        return privilege;
    }

    public void setPrivilege(ArrayList privilege) {
        this.privilege = privilege;
    }

    
}
