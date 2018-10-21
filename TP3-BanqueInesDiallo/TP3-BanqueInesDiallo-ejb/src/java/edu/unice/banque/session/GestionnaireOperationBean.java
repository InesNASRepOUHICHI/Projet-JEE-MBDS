/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unice.banque.session;

import edu.unice.banque.entities.Operation;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author INES NASR
 */
@Stateless
@LocalBean
public class GestionnaireOperationBean {

    final String Query_Select_All_Operations = "SELECT c FROM Operation p";

    @PersistenceContext(unitName = "TP3-BanqueInesDiallo-ejbPU")
    private EntityManager em;

    public void createOperation(Operation operation) {
        em.persist(operation);
    }

    public Operation updateOperation(Operation operation) {
        return em.merge(operation);
    }

    public Operation getOperation(Long operationId) {
        return em.find(Operation.class, operationId);
    }

    public List<Operation> getOperations() {
        TypedQuery<Operation> query = em.createQuery(Query_Select_All_Operations, Operation.class);
        return query.getResultList();
    }
    

    public void supprimerOperation(Operation operation) {
        em.remove(operation);
    }

}
