/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unice.banque.session;

import edu.unice.banque.entities.Administrateur;
import edu.unice.banque.entities.Conseiller;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author deptinfo
 */
@Singleton
@LocalBean
@Startup
public class InitBD {

    @EJB
    private GestionnaireAdministrateur gestionnaireAdministrateur;

    @PersistenceContext(unitName = "TP3-BanqueInesDiallo-ejbPU")
    private EntityManager em;

    @EJB
    private GestionnaireDeCompte gestionnaireDeCompte;
    
    
    @PostConstruct
    public void initBase(){
     gestionnaireDeCompte.creerCompt(1L, 2);
     gestionnaireDeCompte.creerCompt(2L, 2);
     System.out.println("edu.unice.banque.session.InitBD.initBase()");
     gestionnaireAdministrateur.creerAministrateur();
     
    }

    public void persist(Object object) {
        em.persist(object);
    }
    
    
}
