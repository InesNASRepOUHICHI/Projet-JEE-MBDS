/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import edu.unice.banque.entities.Client;
import edu.unice.banque.entities.Compte;
import edu.unice.banque.entities.CompteCourant;
import edu.unice.banque.entities.CompteEpargne;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import edu.unice.banque.session.GestionnaireDeCompte;
import java.util.ArrayList;

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
    private GestionnaireDeCompte compteManager;

    private Client client; 
    private Compte compte;
    private CompteEpargne compteEpargne;
    private CompteCourant compteCourant;

    private int montant = 0;
    private String typeDeCompte = "CC";
    
   public CompteMBean() {
       client = new Client();
       compte = new Compte();
       compteEpargne = new CompteEpargne();
       compteCourant = new CompteCourant();
    }
     public List<Compte> getComptes() {  
    return compteManager.getComptes();
    }  
     
    public String addCompte(){
        Compte compteACreer = null;
        System.out.println(typeDeCompte);
        if(typeDeCompte.equals("CC")){
            compteACreer = new CompteCourant(compteCourant.getMontantPret(), compteCourant.getMontantDecouvert());
        } else if(typeDeCompte.equals("CE")){
            compteACreer = new CompteEpargne(compteEpargne.getTaux(), compteEpargne.getMaxEpargne(), compteEpargne.getMinEpargne());
        }
        compteACreer.setNumeroCompte(compte.getNumeroCompte());
        compteACreer.setSolde(compte.getSolde());
        
        List<Client> clientsProprietaires = new ArrayList<Client>();
        clientsProprietaires.add(client);
        compteACreer.setListeClientsProprietaires(clientsProprietaires);
        
         compteManager.creerCompte(compteACreer);
         return "client ajouté ";
     }
 

public String showDetails(Long id) {  
      return "detailsCompte?id=" + id;   
    }  
public String ajouterMontant(){
        compteManager.deposer(compte, montant);
        return "Montant ajouté";
    }
    
     public String retirerMontant(){
        compteManager.retirer(compte, montant);
        return "Monrtant retiré";
    }
 public void suppression(){
         compteManager.delete(this.compte);
     }
 
  public String update() {  
        System.out.println("###UPDATE###");  
        compte = compteManager.update(compte);
        return "listeComptes";  
    }  
public String showDetails(long compteId) {  
        return "CompteDetails?id=" + compteId;}   

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public GestionnaireDeCompte getCompteManager() {
        return compteManager;
    }

    public void setCompteManager(GestionnaireDeCompte compteManager) {
        this.compteManager = compteManager;
    }

    public String getTypeDeCompte() {
        return typeDeCompte;
    }

    public void setTypeDeCompte(String typeDeCompte) {
        this.typeDeCompte = typeDeCompte;
    }

    public CompteEpargne getCompteEpargne() {
        return compteEpargne;
    }

    public void setCompteEpargne(CompteEpargne compteEpargne) {
        this.compteEpargne = compteEpargne;
    }

    public CompteCourant getCompteCourant() {
        return compteCourant;
    }

    public void setCompteCourant(CompteCourant compteCourant) {
        this.compteCourant = compteCourant;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }



}
