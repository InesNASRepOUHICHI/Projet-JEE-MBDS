/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package edu.unice.banque.session;


import edu.unice.banque.entities.Compte;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

 
/**
 *
 * @author INES NASR
*/
@Singleton
@Startup
@LocalBean
public class Init  {
  @EJB
  private GestionnaireDeCompte gestionnaireDeCompte;
  
   @PostConstruct
   public void initBase() {
      
           gestionnaireDeCompte.creerCompte(new Compte(1l, 1500)); 
           gestionnaireDeCompte.creerCompte(new Compte(2l, 50000)); 
           gestionnaireDeCompte.creerCompte(new Compte(3l, 150000));
           gestionnaireDeCompte.creerCompte(new Compte(4l, 950000));  
           gestionnaireDeCompte.creerCompte(new Compte(5l, 20000));  
           gestionnaireDeCompte.creerCompte(new Compte(6l, 100000));  
            
        
    }     
   
   
   
   
   
         /*  gestionnaireDeCompte.creerComptesTest();   
         @Test
   public void testListeCompte()
   {
       Compte compte = gestionnaireDeCompte.consulter(1);
       assertEquals(compte.getSolde(), 1500);
   }
   */
   
} 
   
 