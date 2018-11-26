/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.DemandAndSupplyManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Ami Gandhi
 */
public class DemandAndSupplyOrganization extends Organization{

    public DemandAndSupplyOrganization() {
        super(Type.DemandAndSupplyManger.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new DemandAndSupplyManagerRole());
        return roles;
    }
     
}
