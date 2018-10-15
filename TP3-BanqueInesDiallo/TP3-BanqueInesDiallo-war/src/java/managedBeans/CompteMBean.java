/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import edu.unice.banque.entities.OldCompteBancaire;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;

import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import edu.unice.banque.session.GestionnaireDeCompteBancaire;

/**
 *
 * @author INES NASR
 */
@Named(value = "compteMBean")
@ViewScoped
public class CompteMBean implements Serializable {

   

    /**
     * Creates a new instance of CompteMBean
     */
    @EJB
    private GestionnaireDeCompteBancaire compteManager;

    private OldCompteBancaire compte;

    private int montant = 0;

  


    public CompteMBean() {
   
          
    }
     public List<OldCompteBancaire> getComptes() {  
    return compteManager.getAllComptes();
    }  
    public void creerComptesTest(){
        compteManager.creerComptesTest();
    }
  

public String showDetails(OldCompteBancaire compte) {  
        this.compte = compte;  
        return "détailCompte?faces-redirect=true";  
    }  
public String ajouterMontant(){
        compteManager.deposer(compte, montant);
        return "Montant ajouté";
    }
    
     public String retirerMontant(){
        compteManager.retirer(compte, montant);
        return "Monrtant retiré";
    }
 public void suppress(){
         compteManager.delete(this.compte);
     }
 
  public String update() {  
        System.out.println("###UPDATE###");  
        compte = compteManager.update(compte);
        return "listeComptes";  
    }  
public String showDetails(long compteId) {  
        return "CompteDetails?id=" + compteId;}   

    public OldCompteBancaire getCompte() {
        return compte;
    }

    public void setCompte(OldCompteBancaire compte) {
        this.compte = compte;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

  

 
   

}
