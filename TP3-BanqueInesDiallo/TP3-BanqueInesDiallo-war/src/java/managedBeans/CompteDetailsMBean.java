/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import edu.unice.banque.entities.OldCompteBancaire;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import edu.unice.banque.session.GestionnaireDeCompteBancaire;

/**
 *
 * @author INES NASR
 */
@Named(value = "compteDetailsMBean")
@Dependent
public class CompteDetailsMBean implements Serializable{

    @EJB
    private GestionnaireDeCompteBancaire gestionnaireDeCompteBancaire;
 private int id;  
  private OldCompteBancaire compte; 
    /**
     * Creates a new instance of CompteDetailsMBean
     */
  
  
   public OldCompteBancaire getDetails() {  
    return compte;  
  }  
  
  /** 
   * Action handler - met à jour la base de données en fonction du client passé 
   * en paramètres, et renvoie vers la page qui affiche la liste des clients. 
   */  
  public String update() {  
    System.out.println("###UPDATE###");  
    compte = gestionnaireDeCompteBancaire.update(compte);  
    return "CompteList";  
  }  
  
  /** 
   * Action handler - renvoie vers la page qui affiche la liste des clients 
   */  
  public String list() {  
    System.out.println("###LIST###");  
    return "CompteList";  
  }  
  
  public void loadCompte() {  
    this.compte = gestionnaireDeCompteBancaire.getCompte(id);  
  }  
  
    public CompteDetailsMBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  
    
}
