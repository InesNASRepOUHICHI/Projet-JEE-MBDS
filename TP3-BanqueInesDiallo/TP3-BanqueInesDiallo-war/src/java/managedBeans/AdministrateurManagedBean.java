/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import edu.unice.banque.entities.Conseiller;
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
@Named(value = "administrateurMBean")
@ViewScoped
public class AdministrateurManagedBean implements Serializable {

    @EJB
    private GestionnaireConseillerBean conseillerManager;
    @EJB
    private GestionnaireAdministrateurBean administrateurManager;

    public List<Conseiller> getConseillers() {
        return administrateurManager.getAllConseiller();
    }

    public String supprimerConseiller(Conseiller conseiller) {
        administrateurManager.supprimerConseiller(conseiller);

        return "listeConseillers?faces-redirect=true";
    }

    public String showDetails(int id) {
        return "detailsConseiller?id=" + id;
    }

    public AdministrateurManagedBean() {
    }

    public GestionnaireConseillerBean getConseillerManager() {
        return conseillerManager;
    }

    public void setConseillerManager(GestionnaireConseillerBean conseillerManager) {
        this.conseillerManager = conseillerManager;
    }

}
