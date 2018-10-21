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
import edu.unice.banque.entities.Conseiller;
import edu.unice.banque.entities.Operation;
import edu.unice.banque.entities.Personnee;
import edu.unice.banque.entities.Role;
import edu.unice.banque.session.GestionnaireClientBean;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import edu.unice.banque.session.GestionnaireCompteBean;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author INES NASR
 */
@Named(value = "compteMBean")
@ViewScoped
public class CompteManagedBean implements Serializable {

    /**
     * Creates a new instance of CompteManagedBean
     */
    @EJB
    private GestionnaireCompteBean compteManager;
    @EJB
    private GestionnaireClientBean clientManager;

    private Long id;
    private Client client;
    private Compte compte;
    private CompteEpargne compteEpargne;
    private CompteCourant compteCourant;

    private Operation operation = new Operation();
    private String typeDeCompte = "CC";

    public CompteManagedBean() {
        client = new Client();
        compte = new Compte();
        compteEpargne = new CompteEpargne();
        compteCourant = new CompteCourant();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Compte> getComptes() {
        return compteManager.getComptes();
    }

    public List<Compte> getComptesClient() {
        Personnee p = UserLoginManagedBean.personneConnectee;
        Client c = clientManager.findClientByEmail(p.getEmail());
        return c.getListComptes();
    }

    public String addCompte() {
        Compte compteACreer = null;
        if (typeDeCompte.equals("CC")) {
            compteACreer = new CompteCourant(compteCourant.getMontantPret(), compteCourant.getMontantDecouvert());
        } else if (typeDeCompte.equals("CE")) {
            compteACreer = new CompteEpargne(compteEpargne.getTaux(), compteEpargne.getMaxEpargne(), compteEpargne.getMinEpargne());
        }
        compteACreer.setNumeroCompte(compte.getNumeroCompte());
        compteACreer.setSolde(compte.getSolde());

        List<Client> clientsProprietaires = new ArrayList<Client>();
        Conseiller conseiller = (Conseiller) UserLoginManagedBean.personneConnectee;

        client.setRole(Role.CLIENT); 
        client.setConseiller(conseiller);
        clientsProprietaires.add(client);
        compteACreer.setListeClientsProprietaires(clientsProprietaires);

        compteManager.createCompte(compteACreer);
        
        return "listeClients";
    }

    public String showDetails(Long id) {
        return "detailsCompte?id=" + id;
    }



    public String supprimerCompte(Compte compte) {
        compteManager.supprimerCompte(compte);

        return "listeComptes?faces-redirect=true";
    }
 

    public String update() {
        compteManager.updateCompte(compte);
        return "listeComptes";
    }
    
    public String nouvelleOperation(Long id) {
        return "nouvelleOperation?id="+id;
    }
    
    public String list() {
        return "listeComptes";
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
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

    public void load() {
        this.compte = compteManager.getCompte(id);
    }
    
    public String creerOperation(){
        operation.setDate(new Date());
        compte.getListeOperations().add(operation);
        double nouveauSolde =0;
        if (operation.getType().toString().equals("VERSEMENT")){
            nouveauSolde = compte.getSolde() + operation.getMontant();
        } else if (operation.getType().toString().equals("RETRAIT")){
            nouveauSolde = compte.getSolde() - operation.getMontant();
        } else if (operation.getType().toString().equals("VIREMENT")){
            nouveauSolde = compte.getSolde() - operation.getMontant();
        }
        System.out.println(nouveauSolde);
        compte.setSolde(nouveauSolde);
        compteManager.updateCompte(compte);
        return "listeOperations";
    }

}
