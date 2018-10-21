/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unice.banque.session;

import edu.unice.banque.entities.Personnee;
import edu.unice.banque.entities.Role;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author INES NASR
 */
@Stateless
@LocalBean
public class AuthentificationBean {

    @PersistenceContext(unitName = "TP3-BanqueInesDiallo-ejbPU")
    private EntityManager em;

    public Role authentification(String email, String password) {
        Query query = em.createQuery("SELECT p FROM Personnee p WHERE p.email =:email and p.password =:password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        try {
            Personnee p = (Personnee) query.getSingleResult();
            return p.getRole();
        } catch (Exception ex) {
            return Role.UNDEFINED;
        }
    }

    public Personnee getPersonneParEmail(String email) {
        Query query = em.createQuery("SELECT p FROM Personnee p WHERE p.email =:email");
        query.setParameter("email", email);
        try {
            Personnee p = (Personnee) query.getSingleResult();
            return p;
        } catch (Exception ex) {
            return null;
        }
    }

}
