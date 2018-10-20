/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unice.banque.session;

import edu.unice.banque.entities.Client;
import edu.unice.banque.entities.Conseiller;
import edu.unice.banque.entities.Role;
import java.util.List;
import javax.ejb.EJB;
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
public class GestionnaireDeClient {

    @EJB
    private GestionnaireDeConseiller gestionnaireDeConseiller;

    @PersistenceContext(unitName = "TP3-BanqueInesDiallo-ejbPU")
    private EntityManager em;
    
   

    public void persist(Object object) {
        em.persist(object);
    }

    public List<Client> getAllClient() {
        Query query = em.createQuery("SELECT c FROM Client c");
        return query.getResultList();
    }

    public void addClient(Client client) {
        em.persist(client);
    }

    public Client findClientByID(Long id) {
        return em.find(Client.class, id);
    }

    public Client findClientByName(String nom) {
        Query query = em.createQuery("SELECT c FROM client c WHERE c.nom =:nom");
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

    public String showDetails(int id) {
        System.out.println("dans show");
        return "detailsClient?id=" + id;
    }

    public void update(Client client) {
        em.merge(client);
    }
    
    public void creerClient(){
        
        String sexe [] = {"F","M"};
        List<Conseiller> conseillers = gestionnaireDeConseiller.getAllConseillers();
        
        em.persist(new Client(0,conseillers.get((int)(Math.random() * conseillers.size())),"Lelaidier","Patrick","04532314","Liberation",sexe[(int)(Math.random() *2)],"patrick@gmail.com","patrick",Role.CLIENT));    
        //em.persist(new Client(conseillers.get(0,conseillers.get((int)(Math.random() * conseillers.size())),"Diallo", "Hasso", "04432316", "Arenas", sexe[(int)(Math.random() *2)], "hasso@gmail.com", "diallo", Role.ADMIN)));
        em.persist(new Client(1,conseillers.get((int)(Math.random() * conseillers.size())),"Perez", "Mari", "04438314", "Thier", sexe[(int)(Math.random() *2)], "perez@gmail.com", "perez", Role.CLIENT));
        em.persist(new Client(0,conseillers.get((int)(Math.random() * conseillers.size())),"Ezaher", "Fatima", "04432399", "Moulin", sexe[(int)(Math.random() *2)], "fatima@gmail.com", "fatima", Role.CLIENT));
        em.persist(new Client(1,conseillers.get((int)(Math.random() * conseillers.size())),"Lelaidier", "Patrick", "04532314", "Liberatin", sexe[(int)(Math.random() *2)], "patrick@gmail.com", "patrick", Role.CLIENT));

    
    }

}
