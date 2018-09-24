/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entities.CompteBancaire;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;

import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import session.GestionnaireDeCompteBancaire;

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

    private CompteBancaire compte;

    private int montant = 0;

  


    public CompteMBean() {
   
          
    }
     public List<CompteBancaire> getComptes() {  
    return compteManager.getAllComptes();
    }  
    public void creerComptesTest(){
        compteManager.creerComptesTest();
    }
  

public String showDetails(CompteBancaire compte) {  
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

    public CompteBancaire getCompte() {
        return compte;
    }

    public void setCompte(CompteBancaire compte) {
        this.compte = compte;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

  

 
   

}
