/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unice.banque.session;

import edu.unice.banque.entities.Administrateur;
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
public class GestionnaireAdministrateur {

    @PersistenceContext(unitName = "TP3-BanqueInesDiallo-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public void creerAministrateur(){
        String sexe [] = {"F","M"};
        int max =2;
        int min =0;
        int rand = (int)(Math.random() * (max-min));
       
        em.persist(new Administrateur("Diallo","Hawaou","04432314","Moulin",sexe[rand],"diallo@gmail.com","diallo","admin")); 
        em.persist(new Administrateur("ines","nasr","04432315","Magnan",sexe[rand],"nasr@gmail.com","nasr","admin")); 
        em.persist(new Administrateur("Diallo","Hasso","04432316","Arenas",sexe[rand],"hasso@gmail.com","diallo","admin")); 
        em.persist(new Administrateur("Perez","Mari","04438314","Thier",sexe[rand],"perez@gmail.com","perez","admin")); 
        em.persist(new Administrateur("Ezaher","Fatima","04432399","Moulin",sexe[rand],"fatima@gmail.com","fatima","admin")); 
        em.persist(new Administrateur("Lelaidier","Patrick","04532314","Liberatin",sexe[rand],"patrick@gmail.com","patrick","admin")); 




       }
   
    
}
