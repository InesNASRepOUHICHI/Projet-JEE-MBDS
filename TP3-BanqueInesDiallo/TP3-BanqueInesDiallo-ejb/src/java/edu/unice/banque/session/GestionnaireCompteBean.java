/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unice.banque.session;

import edu.unice.banque.entities.Compte;
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
public class GestionnaireCompteBean {

    final String Query_Select_All_Comptes = "SELECT c FROM Compte c";

    @PersistenceContext(unitName = "TP3-BanqueInesDiallo-ejbPU")
    private EntityManager em;

    public void createCompte(Compte compte) {
        em.persist(compte);
    }

    public Compte updateCompte(Compte compte) {
        return em.merge(compte);
    }

    public Compte getCompte(Long compteId) {
        return em.find(Compte.class, compteId);
    }

    public List<Compte> getComptes() {
        TypedQuery<Compte> query = em.createQuery(Query_Select_All_Comptes, Compte.class);
        return query.getResultList();
    }
    

   public void supprimerCompte(Compte compte) {
    em.remove(em.merge(compte));
 }
}
