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
import edu.unice.banque.entities.Operation;
import edu.unice.banque.entities.Role;
import edu.unice.banque.entities.TypeOperation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;

/**
 *
 * @author deptinfo
 */
@Singleton
@LocalBean
@Startup
public class InitDbBean {

    @EJB
    private GestionnaireClientBean gestionnaireClientBean;
    @EJB
    private GestionnaireAdministrateurBean gestionnaireAdministrateurBean;
    @EJB
    private GestionnaireConseillerBean gestionnaireConseillerBean;

    @PostConstruct
    public void initBase() {
        System.out.println("edu.unice.banque.session.InitBD.initBase()");
        creerClientDeTest();
        creerAministrateurs();
        creerConseillers();

    }

    public void creerClientDeTest() {
        Client clientProprietaire = new Client();
        clientProprietaire.setNom("NASR");
        clientProprietaire.setPrenom("Ines");
        clientProprietaire.setSexe("Femme");
        clientProprietaire.setAdresse("100, bv de la madeleine, 06000, Nice");
        clientProprietaire.setNumeroTelephone("0765326598");
        clientProprietaire.setRole(Role.CLIENT);
        clientProprietaire.setEmail("ines@gmail.com");
        clientProprietaire.setPassword("ines");

        Conseiller conseiller = new Conseiller("DECHAMPS", "Maxime", "0492626262", "Nice CARRAS", "Homme", "maxime@gmail.com", "maxime", Role.CONSEILLER);
        conseiller.setAdministrateur(new Administrateur("admin", "admin", "04432315", "Magnan", "Femme", "admin", "admin", Role.ADMIN));
        clientProprietaire.setConseiller(conseiller);

        Compte compte = new CompteCourant(0, 500);
        compte.setNumeroCompte(10001L);
        compte.setSolde(50000);

        List<Operation> operations = new ArrayList<Operation>();
        operations.add(new Operation(TypeOperation.RETRAIT, new Date(), 110));
        operations.add(new Operation(TypeOperation.VERSEMENT, new Date(), 120));
        operations.add(new Operation(TypeOperation.VIREMENT, new Date(), 130));
        operations.add(new Operation(TypeOperation.RETRAIT, new Date(), 140));

        compte.setListeOperations(operations);
        List<Compte> comptes = new ArrayList<Compte>();
        comptes.add(compte);

        clientProprietaire.setListComptes(comptes);

        gestionnaireClientBean.addClient(clientProprietaire);

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
