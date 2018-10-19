/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unice.banque.session;

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
public class InitBD {

    @EJB
    private GestionnaireDeCompte gestionnaireDeCompte;
    
    @PostConstruct
    public void initBase(){
     gestionnaireDeCompte.creerCompt(1L, 2);
        System.out.println("edu.unice.banque.session.InitBD.initBase()");
    }
}
