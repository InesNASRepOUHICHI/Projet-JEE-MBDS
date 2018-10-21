/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import edu.unice.banque.entities.Administrateur;
import edu.unice.banque.entities.Conseiller;
import edu.unice.banque.entities.Personnee;
import edu.unice.banque.session.GestionnaireAdministrateurBean;
import edu.unice.banque.session.GestionnaireConseillerBean;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;

import javax.faces.view.ViewScoped;

/**
 *
 * @author INES NASR
 */
@Named(value = "conseillerMBean")
@ViewScoped
public class ConseillerManagedBean implements Serializable {

    @EJB
    private GestionnaireConseillerBean conseillerManager;
    @EJB
    private GestionnaireAdministrateurBean administrateurManager;
    private Conseiller conseiller;

    public List<Conseiller> getConseillers() {
        return administrateurManager.getAllConseiller();
    }

    public String addConseiller() {
        Personnee p = UserLoginManagedBean.personneConnectee;
        conseiller.setAdministrateur((Administrateur) p);
        conseillerManager.addConseiller(conseiller);
        return "listeConseillers?faces-redirect=true";

    }

    public ConseillerManagedBean() {
        conseiller = new Conseiller();
    }

    public GestionnaireConseillerBean getConseillerManager() {
        return conseillerManager;
    }

    public void setConseillerManager(GestionnaireConseillerBean conseillerManager) {
        this.conseillerManager = conseillerManager;
    }

    public Conseiller getConseiller() {
        return conseiller;
    }

    public void setConseiller(Conseiller conseiller) {
        this.conseiller = conseiller;
    }

}
