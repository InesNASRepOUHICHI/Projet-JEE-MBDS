/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import edu.unice.banque.entities.Client;
import edu.unice.banque.session.GestionnaireDeClient;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author deptinfo
 */
@Named(value = "detailsClients")
@ViewScoped
public class DetailsClientsMBean implements Serializable{
    private Long id;
    private Client client;

    @EJB
    private GestionnaireDeClient clientManager;

    /**
     * Creates a new instance of detailsClients
     */
    
    
    public DetailsClientsMBean() {
    }
    
    public Client getDetail(){
        return client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public GestionnaireDeClient getClientManager() {
        return clientManager;
    }

    public void setClientManager(GestionnaireDeClient clientManager) {
        this.clientManager = clientManager;
    }
    
    
    public void load() {  
      this.client = clientManager.findClientByID(id);
   }
    public String update() { 
     clientManager.update(client);
     return "listeClients?faces-redirect=true";  
  }  
  
  /** 
   * Action handler - renvoie vers la page qui affiche la liste des clients 
   */  
  public String list() {  
    return "listeClients?faces-redirect=true";  
  }  
    
    
}
