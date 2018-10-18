/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

package edu.unice.banque.test;

import edu.unice.banque.session.GestionnaireDeCompte;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 */
/**
 *
 * @author INES NASR

@Singleton
@Startup
@LocalBean
public class Init implements Serializable {

  @EJB
  private GestionnaireDeCompte gestionnaireDeCompte;
  
   @PostConstruct
   public void initBase() {
       
           gestionnaireDeCompte.creerCompte(12345678912L, 1500); 
           gestionnaireDeCompte.creerCompte(12345688910L, 50000); 
           gestionnaireDeCompte.creerCompte(12255678911L, 150000);
           gestionnaireDeCompte.creerCompte(12348878999L, 950000);  
           gestionnaireDeCompte.creerCompte(12345678910L, 20000);  
           gestionnaireDeCompte.creerCompte(12389654610L, 100000);  
            
        
    }     
   
} 
   
 */