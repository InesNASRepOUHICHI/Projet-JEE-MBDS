/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import edu.unice.banque.entities.Administrateur;
import edu.unice.banque.session.GestionnaireAdministrateur;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author deptinfo
 */
@Named(value = "administrateursMBean")
@ViewScoped
public class AdministrateursMBean  implements Serializable{

    @EJB
    private GestionnaireAdministrateur gestionnaireAdministrateur;

    private Administrateur administrateur;
    
    public AdministrateursMBean() {
    }
    
    public List<Administrateur> getAllAdministrateurs() {
        return gestionnaireAdministrateur.getAllAdministrateurs();
    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }
    
     public String showDetails(int id) {  
        return gestionnaireAdministrateur.showDetails(id);
    }
    
    
}
