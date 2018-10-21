/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unice.banque.session;

import edu.unice.banque.entities.Conseiller;
import edu.unice.banque.entities.Role;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author deptinfo
 */
@Stateless
@LocalBean
public class GestionnaireConseillerBean {

    final String Query_Find_Conseiller_By_ID = "SELECT c FROM Conseiller c where c.id = : id";

    @PersistenceContext(unitName = "TP3-BanqueInesDiallo-ejbPU")
    private EntityManager em;

    public void addConseiller(Conseiller conseiller) {
        conseiller.setRole(Role.CONSEILLER);
        em.merge(conseiller);
    }

    public Conseiller updateConseiller(Conseiller conseiller) {
        return em.merge(conseiller);
    }

    public String showDetails(int id) {
        return "detailsConseiller?id=" + id;
    }

    public Conseiller findConseillerByID(Long id) {
        System.out.println(em.find(Conseiller.class, id));
        return em.find(Conseiller.class, id);
    }

}
