/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unice.banque.session;

import edu.unice.banque.entities.Administrateur;
import edu.unice.banque.entities.Client;
import edu.unice.banque.entities.Role;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author deptinfo
 */
@Stateless
@LocalBean
public class GestionnaireAdministrateur {

    @PersistenceContext(unitName = "TP3-BanqueInesDiallo-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public Administrateur findClientByName(String nom) {
        Query query = em.createQuery("SELECT a FROM Administrateur a WHERE a.NOM =:nom");
        query.setParameter("nom", nom);
        return (Administrateur) query.getSingleResult();
    }
    
    public void creerAministrateur() {
        String sexe[] = {"F", "M"};
        int max = 2;
        int min = 0;
        int rand = (int) (Math.random() * (max - min));
        em.persist(new Administrateur("Diallo", "Hawaou", "04432314", "Moulin", sexe[rand], "diallo@gmail.com", "diallo", Role.ADMIN));
        rand = (int) (Math.random() * (max - min));
        em.persist(new Administrateur("ines", "nasr", "04432315", "Magnan", sexe[rand], "nasr@gmail.com", "nasr", Role.ADMIN));
    }
    
    public List<Administrateur> getAllAdministrateurs() {
        Query query = em.createQuery("SELECT a FROM Administrateur a");
        return query.getResultList();
    }
    
    public String showDetails(int id) {
        System.out.println("dans show");
        return "administrateurDetails?id=" + id;
    }
    
     public void update(Administrateur administrateur) {
        em.merge(administrateur);
    }
     
     public Administrateur findClientByID(Long id) {
        return em.find(Administrateur.class, id);
    }


}
