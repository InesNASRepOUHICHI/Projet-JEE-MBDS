/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import edu.unice.banque.entities.Conseiller;
import edu.unice.banque.session.GestionnaireDeConseiller;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author deptinfo
 */
@Named(value = "conseillersDetailsMBean")
@Dependent
public class ConseillerDetailsMBean implements Serializable{

    @EJB
    private GestionnaireDeConseiller gestionnaireDeConseiller;
    
    private Long id;
    private Conseiller conseiller;
    
    public ConseillerDetailsMBean() {
    }
    
    public void load() {  
      this.conseiller = gestionnaireDeConseiller.findClientByID(id);
   }
    public String update() { 
     gestionnaireDeConseiller.update(conseiller);
     return "listeConseillers?faces-redirect=true";  
  }  
  
  /** 
   * Action handler - renvoie vers la page qui affiche la liste des clients 
   */  
  public String list() {  
    return "listeConseillers?faces-redirect=true";  
  }  

    public GestionnaireDeConseiller getGestionnaireDeConseiller() {
        return gestionnaireDeConseiller;
    }

    public void setGestionnaireDeConseiller(GestionnaireDeConseiller gestionnaireDeConseiller) {
        this.gestionnaireDeConseiller = gestionnaireDeConseiller;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Conseiller getConseiller() {
        return conseiller;
    }

    public void setConseiller(Conseiller conseiller) {
        this.conseiller = conseiller;
    }
  
    
}
