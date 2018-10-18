/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import edu.unice.banque.entities.Client;
import edu.unice.banque.session.GestionnaireDeClient;
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
public class ClientMBean implements Serializable {

    @EJB
    private GestionnaireDeClient clientManager;
     private Client client ;
    /**
     * Creates a new instance of ClientMBean
     */
     public List<Client> getClients() {  
         return clientManager.getAllClient();
    }  
     public String addClient(){
         clientManager.addClient(client);
         return "client ajouté ";
     }
    
   
    public ClientMBean() {
    }

  

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
}
