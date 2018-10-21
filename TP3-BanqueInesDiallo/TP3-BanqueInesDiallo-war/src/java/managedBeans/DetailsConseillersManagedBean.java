/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import edu.unice.banque.entities.Conseiller;
import edu.unice.banque.session.GestionnaireConseillerBean;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author deptinfo
 */
@Named(value = "detailsConseillers")
@ViewScoped
public class DetailsConseillersManagedBean implements Serializable {

    private Long id;
    private Conseiller conseiller;

    @EJB
    private GestionnaireConseillerBean conseillerManager;

    /**
     * Creates a new instance of detailsConseillers
     */
    public DetailsConseillersManagedBean() {
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

    public void load() {
        this.conseiller = conseillerManager.findConseillerByID(id);
    }

    public String update() {
        conseillerManager.updateConseiller(conseiller);
        return "listeConseillers?faces-redirect=true";
    }

    /**
     * Action handler - renvoie vers la page qui affiche la liste des
     * conseillers
     */
    public String list() {
        return "listeConseillers?faces-redirect=true";
    }

}
