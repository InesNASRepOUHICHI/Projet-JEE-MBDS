/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unice.banque.session;

import edu.unice.banque.entities.Administrateur;
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
public class GestionnaireAdministrateurBean {

    final String Query_Select_All_Administrateurs = "SELECT a FROM Administrateur a";
    // final String Query_Select_All_Conseillers = "SELECT c FROM Conseiller c where c.administrateur_id = : id";
    final String Query_Select_All_Conseillers = "SELECT c FROM Conseiller c ";

    @PersistenceContext(unitName = "TP3-BanqueInesDiallo-ejbPU")
    private EntityManager em;

    public List<Administrateur> getAllAdministrateur() {
        Query query = em.createQuery(Query_Select_All_Administrateurs);
        return query.getResultList();
    }

    public void addAdministrateur(Administrateur administrateur) {
        em.persist(administrateur);
    }

    public Administrateur findAdministrateurByID(Long id) {
        return em.find(Administrateur.class, id);
    }

    public List<Conseiller> getAllConseiller() {
        Query query = em.createQuery(Query_Select_All_Conseillers);
        //query.setParameter("administrateur_id", id);
        return query.getResultList();
    }

    public void supprimerConseiller(Conseiller conseiller) {
        em.remove(em.merge(conseiller));
    }
}
