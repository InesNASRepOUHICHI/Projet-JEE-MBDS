/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unice.banque.session;

import edu.unice.banque.entities.Administrateur;
import edu.unice.banque.entities.Client;
import edu.unice.banque.entities.Conseiller;
import edu.unice.banque.entities.Role;
import java.util.List;
import javax.ejb.EJB;
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
public class GestionnaireDeConseiller {

    @EJB
    private GestionnaireDeClient gestionnaireDeClient;

    @EJB
    private GestionnaireAdministrateur gestionnaireAdministrateur;
    
    
    
    

    @PersistenceContext(unitName = "TP3-BanqueInesDiallo-ejbPU")
    private EntityManager em;
     

   public void  creerConseiller(){
        String sexe [] = {"F","M"};
        List<Administrateur> admins = gestionnaireAdministrateur.getAllAdministrateurs();
        em.persist(new Conseiller(admins.get((int)(Math.random() * admins.size())),"Lelaidier","Patrick","04532314","Liberatin",sexe[(int)(Math.random() *2)],"patrick@gmail.com","patrick",Role.CONSEILLER));    
        em.persist(new Conseiller(admins.get((int)(Math.random() * admins.size())),"Diallo", "Hasso", "04432316", "Arenas", sexe[(int)(Math.random() *2)], "hasso@gmail.com", "diallo", Role.CONSEILLER));
        em.persist(new Conseiller(admins.get((int)(Math.random() * admins.size())),"Perez", "Mari", "04438314", "Thier", sexe[(int)(Math.random() *2)], "perez@gmail.com", "perez", Role.CONSEILLER));
        em.persist(new Conseiller(admins.get((int)(Math.random() * admins.size())),"Ezaher", "Fatima", "04432399", "Moulin", sexe[(int)(Math.random() *2)], "fatima@gmail.com", "fatima", Role.CONSEILLER));
        em.persist(new Conseiller(admins.get((int)(Math.random() * admins.size())),"Lelaidier", "Patrick", "04532314", "Liberatin", sexe[(int)(Math.random() *2)], "patrick@gmail.com", "patrick", Role.CONSEILLER));
       
        
      
    }
   
       public Conseiller findClientByID(Long id) {
        return em.find(Conseiller.class, id);
    }
   
    public List<Conseiller> getAllConseillers() {
        Query query = em.createQuery("SELECT c FROM Conseiller c");
        return query.getResultList();
    }
    
     public String showDetails(int id) {
        System.out.println("dans show");
        return "conseillerDetail?id=" + id;
    }

    public void update(Conseiller conseiller) {
        em.merge(conseiller);
    }

    public void persist(Object object) {
        em.persist(object);
    }
}
