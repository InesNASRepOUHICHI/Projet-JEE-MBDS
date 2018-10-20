/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unice.banque.session;

import edu.unice.banque.entities.Administrateur;
import edu.unice.banque.entities.Client;
import edu.unice.banque.entities.Compte;
import edu.unice.banque.entities.CompteCourant;
import edu.unice.banque.entities.Conseiller;
import edu.unice.banque.entities.Role;
import java.util.ArrayList;
import java.util.List;
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
public class InitDbBean {

    @EJB
    private GestionnaireCompteBean gestionnaireCompteBean;
    @EJB
    private GestionnaireAdministrateurBean gestionnaireAdministrateurBean;
    @EJB
    private GestionnaireConseillerBean gestionnaireConseillerBean;

    @PostConstruct
    public void initBase() {
        System.out.println("edu.unice.banque.session.InitBD.initBase()");
        creerCompteDeTest();
        creerAministrateurs();
        creerConseillers();
        
        

    }

    public void creerCompteDeTest() {
        Client clientProprietaire = new Client();
        clientProprietaire.setNom("NASR");
        clientProprietaire.setPrenom("Ines");
        clientProprietaire.setAdresse("100, bv de la madeleine, 06000, Nice");
        clientProprietaire.setNumeroTelephone("0765326598");
        clientProprietaire.setRole(Role.CLIENT);
        clientProprietaire.setEmail("ines@gmail.com");
        clientProprietaire.setPassword("ines");
        
        Conseiller conseiller = new Conseiller("DECHAMPS", "Maxime", "0492626262", "Nice CARRAS", "Homme", "maxime@gmail.com", "maxime", Role.CONSEILLER);
        conseiller.setAdministrateur(new Administrateur("admin", "admin", "04432315", "Magnan", "Femme", "admin", "admin", Role.ADMIN));
        clientProprietaire.setConseiller(conseiller);
        
        List<Client> proprietairesComptes = new ArrayList<>();
        proprietairesComptes.add(clientProprietaire);
        
        Compte compte = new CompteCourant(0, 500);
        compte.setNumeroCompte(10001L);
        compte.setSolde(50000);
        compte.setListeClientsProprietaires(proprietairesComptes);

        gestionnaireCompteBean.createCompte(compte);
        

    }

    public void creerAministrateurs() {

        gestionnaireAdministrateurBean.addAdministrateur(new Administrateur("Diallo", "Hawaou", "04432314", "Moulin", "Femme", "diallo@gmail.com", "diallo", Role.ADMIN));
        gestionnaireAdministrateurBean.addAdministrateur(new Administrateur("ines", "nasr", "04432315", "Magnan", "Femme", "nasr@gmail.com", "nasr", Role.ADMIN));
        gestionnaireAdministrateurBean.addAdministrateur(new Administrateur("Diallo", "Hasso", "04432316", "Arenas", "Homme", "hasso@gmail.com", "diallo", Role.ADMIN));

    }
    
    public void creerConseillers() {
        gestionnaireConseillerBean.addConseiller(new Conseiller("Perez", "Mari", "04438314", "Thier", "Femme", "perez@gmail.com", "perez", Role.CONSEILLER));
        gestionnaireConseillerBean.addConseiller(new Conseiller("Ezaher", "Fatima", "04432399", "Moulin", "Homme", "fatima@gmail.com", "fatima", Role.CONSEILLER));
        gestionnaireConseillerBean.addConseiller(new Conseiller("Lelaidier", "Patrick", "04532314", "Liberatin", "Femme", "patrick@gmail.com", "patrick", Role.CONSEILLER));

    }

}
