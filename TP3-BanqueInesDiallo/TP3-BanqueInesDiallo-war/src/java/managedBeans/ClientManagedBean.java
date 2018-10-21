/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import edu.unice.banque.entities.Client;
import edu.unice.banque.session.GestionnaireClientBean;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;

import javax.faces.view.ViewScoped;

/**
 *
 * @author INES NASR
 */
@Named(value = "clientMBean")
@ViewScoped
public class ClientManagedBean implements Serializable {

    @EJB
    private GestionnaireClientBean clientManager;
     private Client client ;
    /**
     * Creates a new instance of ClientManagedBean
     */
     public List<Client> getClients() {  
         return clientManager.getAllClient();
    }  
     public String addClient(){
         clientManager.addClient(client);
         return "client ajouté ";
     }
    
   
    public ClientManagedBean() {
    }

  

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    public String showDetails(int id) {  
       return "detailsClient?id=" + id;
    }

}
