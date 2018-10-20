/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import edu.unice.banque.entities.Administrateur;
import edu.unice.banque.session.GestionnaireAdministrateur;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author deptinfo
 */
@Named(value = "administrateurDetailsMBean")
@ViewScoped
public class AdministrateurDetailsMBean  implements Serializable{
    private Administrateur administrateur;
    private Long id;

    @EJB
    private GestionnaireAdministrateur gestionnaireAdministrateur;

    
    public AdministrateurDetailsMBean() {
    }
    
    public String update() {   
    gestionnaireAdministrateur.update(administrateur);  
    return "listeAdministrateurs?faces-redirect=true";  
  }  
  
  /** 
   * Action handler - renvoie vers la page qui affiche la liste des clients 
   */  
  public String list() {  
    System.out.println("###LIST###");  
    return "listeAdministrateurs?faces-redirect=true";  
  }  
  
  public void load() {  
    this.administrateur = gestionnaireAdministrateur.findClientByID(id);  
  } 

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GestionnaireAdministrateur getGestionnaireAdministrateur() {
        return gestionnaireAdministrateur;
    }

    public void setGestionnaireAdministrateur(GestionnaireAdministrateur gestionnaireAdministrateur) {
        this.gestionnaireAdministrateur = gestionnaireAdministrateur;
    }
  
}
