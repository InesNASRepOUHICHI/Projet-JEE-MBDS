/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unice.banque.session;

import edu.unice.banque.entities.Conseiller;
import edu.unice.banque.entities.Role;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author deptinfo
 */
@Stateless
@LocalBean
public class GestionnaireConseillerBean {
    
    final String Query_Select_All_Conseillers = "SELECT c FROM Conseiller c";

    @PersistenceContext(unitName = "TP3-BanqueInesDiallo-ejbPU")
    private EntityManager em;
    
     public List<Conseiller> getAllConseiller() {
        Query query = em.createQuery(Query_Select_All_Conseillers);
        return query.getResultList();
    }

    public void addConseiller(Conseiller conseiller) {
        em.persist(conseiller);
    }

    public Conseiller findConseillerByID(Long id) {
        return em.find(Conseiller.class, id);
    }

    

}
