/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import edu.unice.banque.entities.Compte;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import edu.unice.banque.session.GestionnaireCompteBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author INES NASR
 */
@Named(value = "compteDetailsMBean")
@ViewScoped
public class CompteDetailsMBean implements Serializable{

    @EJB
  private GestionnaireCompteBean gestionnaireDeCompteBancaire;
  private Long id;  
  private Compte compte; 
    /**
     * Creates a new instance of CompteDetailsMBean
     */
  
  
   public Compte getDetails() {  
    return compte;  
  }  
  
  /** 
   * Action handler - met à jour la base de données en fonction du client passé 
   * en paramètres, et renvoie vers la page qui affiche la liste des clients. 
   */  
  public String update() {  
    System.out.println("###UPDATE###");  
    compte = gestionnaireDeCompteBancaire.updateCompte(compte);  
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

    public GestionnaireCompteBean getGestionnaireDeCompteBancaire() {
        return gestionnaireDeCompteBancaire;
    }

    public void setGestionnaireDeCompteBancaire(GestionnaireCompteBean gestionnaireDeCompteBancaire) {
        this.gestionnaireDeCompteBancaire = gestionnaireDeCompteBancaire;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

  
  
    
}
