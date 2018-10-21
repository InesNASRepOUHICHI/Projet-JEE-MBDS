/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unice.banque.session;

import edu.unice.banque.entities.Client;
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
 * @author INES NASR
 */
@Stateless
@LocalBean
public class GestionnaireClientBean {

    final String Query_Select_All_Clients = "SELECT c FROM Client c";
    final String Query_Select_Client_By_Email = "SELECT c FROM Client c where c.email =:email";
    final String Query_Select_Client_By_Name = "SELECT c FROM client c WHERE c.nom =:nom";

    @PersistenceContext(unitName = "TP3-BanqueInesDiallo-ejbPU")
    private EntityManager em;

    public List<Client> getAllClient() {
        Query query = em.createQuery(Query_Select_All_Clients);
        return query.getResultList();
    }

    public void addClient(Client client) {
        em.persist(client);
    }

    public Client findClientByID(Long id) {
        return em.find(Client.class, id);
    }

    public Client findClientByEmail(String email) {
        Query query = em.createQuery(Query_Select_Client_By_Email);
        query.setParameter("email", email);
        try {
            return (Client) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.toString());
            return null;
        } catch (NonUniqueResultException en) {
            System.out.println(en.toString());
            List<Client> clients = (List<Client>) query.getResultList();
            return clients.get(0);
        }
    }

    public Client findClientByName(String nom) {
        Query query = em.createQuery(Query_Select_Client_By_Name);
        query.setParameter("nom", nom);
        try {
            return (Client) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException en) {
            List<Client> clients = (List<Client>) query.getResultList();
            return clients.get(0);
        }
    }

    public Client updateClient(Client client) {
        return em.merge(client);
    }

  

}
