/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import edu.unice.banque.entities.Conseiller;
import edu.unice.banque.session.GestionnaireDeConseiller;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author deptinfo
 */
@Named(value = "conseillerMBean")
@ViewScoped
public class ConseillerMBean implements Serializable{

    @EJB
    private GestionnaireDeConseiller gestionnaireDeConseiller;

    /**
     * Creates a new instance of ConseillerMBean
     */
    public ConseillerMBean() {
    }
    
    public List<Conseiller> getAllConseillers(){
         List<Conseiller> conseillers = gestionnaireDeConseiller.getAllConseillers();
        return conseillers;
    }
    public String showDetails(int id) {  
       return  gestionnaireDeConseiller.showDetails(id);
    }
}
