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
    private Long idCrediteur;
    private Client client;
    private Compte compte;
    private CompteEpargne compteEpargne;
    private CompteCourant compteCourant;

    private List<Compte> comptesClient;
    private List<Compte> comptes;

    private String message = "";

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

    public Long getIdCrediteur() {
        return idCrediteur;
    }

    public void setIdCrediteur(Long idCrediteur) {
        this.idCrediteur = idCrediteur;
    }

    public GestionnaireCompteBean getCompteManager() {
        return compteManager;
    }

    public void setCompteManager(GestionnaireCompteBean compteManager) {
        this.compteManager = compteManager;
    }

    public GestionnaireClientBean getClientManager() {
        return clientManager;
    }

    public void setClientManager(GestionnaireClientBean clientManager) {
        this.clientManager = clientManager;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Compte> getComptes() {
        if (this.comptes == null) {
            this.comptes = compteManager.getComptes();
        }
        return this.comptes;
    }

    public List<Compte> getComptesClient() {
        if (this.comptesClient == null) {
            Personnee p = UserLoginManagedBean.personneConnectee;
            Client c = clientManager.findClientByEmail(p.getEmail());
            this.comptesClient = c.getListComptes();
        }
        return this.comptesClient;
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

        Conseiller conseiller = (Conseiller) UserLoginManagedBean.personneConnectee;

        client.setRole(Role.CLIENT);
        client.setConseiller(conseiller);

        List<Compte> listeComptesClient = new ArrayList<Compte>();
        listeComptesClient.add(compte);
        client.setListComptes(listeComptesClient);

        clientManager.addClient(client);

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
        return "nouvelleOperation?id=" + id;
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

    public String creerOperation() {
        System.out.println("NV OPERATION----");
        message = "Opération en cours...";
        operation.setDate(new Date());
        compte.getListeOperations().add(operation);
        double nouveauSolde = 0;
        if (operation.getType().toString().equals("VERSEMENT")) {
            nouveauSolde = compte.getSolde() + operation.getMontant();
        } else if (operation.getType().toString().equals("RETRAIT")) {
            nouveauSolde = compte.getSolde() - operation.getMontant();

            if (nouveauSolde < 0) {
                message = "Solde insuffisant";
                return "nouvelleOperation?id=" + id;
            }
        } else if (operation.getType().toString().equals("VIREMENT")) {
            System.out.println("VIREMENT----");
            nouveauSolde = compte.getSolde() - operation.getMontant();
            if (nouveauSolde < 0) {
                message = "Solde insuffisant";
                return "nouvelleOperation?id=" + id;
            }
            Compte compteACrediter = compteManager.getCompte(idCrediteur);
            double soldeCompteCredite = compteACrediter.getSolde() + operation.getMontant();
            compteACrediter.setSolde(soldeCompteCredite);
            compteManager.updateCompte(compteACrediter);
        }
        compte.setSolde(nouveauSolde);
        compteManager.updateCompte(compte);

        return "listeOperations";
    }

}
