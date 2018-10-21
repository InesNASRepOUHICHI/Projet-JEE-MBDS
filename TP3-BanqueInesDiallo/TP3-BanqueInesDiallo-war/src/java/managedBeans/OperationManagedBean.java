/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import edu.unice.banque.entities.Client;
import edu.unice.banque.entities.Operation;
import edu.unice.banque.entities.Personnee;
import edu.unice.banque.session.GestionnaireClientBean;
import edu.unice.banque.session.GestionnaireOperationBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;

import javax.faces.view.ViewScoped;

/**
 *
 * @author INES NASR
 */
@Named(value = "operationManagedBean")
@ViewScoped
public class OperationManagedBean implements Serializable {

    @EJB
    private GestionnaireClientBean gestionnaireClientBean;
    @EJB
    private GestionnaireOperationBean gestionnaireOperationBean;

    private Operation operation;

    private Long id;

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Operation> getOperations() {

        List<Operation> operations = new ArrayList<Operation>();
        Personnee p = UserLoginManagedBean.personneConnectee;
        Client c = gestionnaireClientBean.findClientByEmail(p.getEmail());
        for (int i = 0; i < c.getListComptes().size(); i++) {
            operations.addAll(c.getListComptes().get(i).getListeOperations());
        }
        return operations;
    }

    public void load() {
        this.operation = gestionnaireOperationBean.getOperation(id);
    }

    public String showDetails(int id) {
        return "detailsOperation?id=" + id;
    }

    public String update() {
        gestionnaireOperationBean.updateOperation(operation);
        return "listeOperations?faces-redirect=true";
    }

    public String list() {
        return "listeOperations?faces-redirect=true";
    }

}
