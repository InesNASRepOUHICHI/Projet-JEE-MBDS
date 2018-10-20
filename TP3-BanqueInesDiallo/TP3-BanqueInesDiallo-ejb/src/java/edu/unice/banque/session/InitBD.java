/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unice.banque.session;

import edu.unice.banque.entities.Administrateur;
import edu.unice.banque.entities.Compte;
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
    public void initBase() {
        System.out.println("edu.unice.banque.session.InitBD.initBase()");
        gestionnaireAdministrateur.creerAministrateur();

        gestionnaireDeCompte.creerCompte(new Compte(1l, 1500));
        gestionnaireDeCompte.creerCompte(new Compte(2l, 50000));
        gestionnaireDeCompte.creerCompte(new Compte(3l, 150000));
        gestionnaireDeCompte.creerCompte(new Compte(4l, 950000));
        gestionnaireDeCompte.creerCompte(new Compte(5l, 20000));
        gestionnaireDeCompte.creerCompte(new Compte(6l, 100000));

    }

    public void persist(Object object) {
        em.persist(object);
    }

}
