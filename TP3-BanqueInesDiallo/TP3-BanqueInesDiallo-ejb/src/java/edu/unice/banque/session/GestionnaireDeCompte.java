/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unice.banque.session;

import edu.unice.banque.entities.Client;
import edu.unice.banque.entities.Compte;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author INES NASR
 */
@Stateless
@LocalBean
public class GestionnaireDeCompte {

    @PersistenceContext(unitName = "TP3-BanqueInesDiallo-ejbPU")
    private EntityManager em;
  
   private final Compte compteBancaire = new Compte();
   
    public  Compte deposer(Compte compte,int montant) {
     compteBancaire.setSolde(compteBancaire.getSolde() + montant);
        em.merge(compte);
        return update (compte);

    }

    public Compte retirer(Compte compte,int montant) {
        if (montant < compteBancaire.getSolde()) {
            compteBancaire.setSolde(compteBancaire.getSolde() - montant);
              em.merge(compte);
        return update (compte);

        } else {
            return null;
        }

    }
   public String showDetails(int compteId) {  
        return "CustomerDetails?idCompte=" + compteId;  
    }  

    public Compte getCompte(int idCompte) {
        return em.find(Compte.class, idCompte);  

    }
   public void transfertArgent(Long idDebiteur,Long idCrediteur, int montant){
        
        Compte compteDebiteur = chercherCompteById(idDebiteur);
        Compte compteCrediteur= chercherCompteById(idCrediteur);
        
       retirer(compteDebiteur,montant);
       deposer(compteCrediteur,montant);
        
        
        em.merge(compteDebiteur);
        em.merge(compteCrediteur);
    }
    
  
    
     public Compte consulter(long id) {   
        return em.find(Compte.class, id);
    }

    
     public Compte creerCompte(Long num, double solde, List<Client> proprietairesCompte){
       Compte compte = new Compte(num, solde, proprietairesCompte);
       em.persist(compte);
       return compte;
    }
     
     public void creerCompt(Long num, double solde) {
         Compte c = new Compte(num,solde);
         em.persist(c);
     
     }

    
      public Compte update(Compte compte) {
      return em.merge(compte); 
    }
      
    public List<Compte> getAllComptes() {
       Query query = em.createNamedQuery("Compte.findAll");  
        return query.getResultList(); 
    }
    
    public List<Compte> getComptes(int start, int nombreDeComptes){
    Query query=em.createNamedQuery("Compte.findAll");
    query.setFirstResult(start);
    query.setMaxResults(nombreDeComptes);
    
    return query.getResultList();
    }
    
    
    public void delete(Compte c){
    em.remove(c);    }
    
    public Compte chercherCompteById(Long id){
    Query query=em.createNamedQuery("Compte.findById").setParameter("id",id);
    return(Compte)query.getSingleResult();
    }
   
  
   public void creerComptesTest() {
   Client client1 = new Client();
   List<Client> proprietairesComptes = new ArrayList<>();
   proprietairesComptes.add(client1);
   creerCompte(12345678912L, 1500, proprietairesComptes); 
   creerCompte(12345688910L, 50000, proprietairesComptes); 
   creerCompte(12255678911L, 150000, proprietairesComptes); 
   creerCompte(12348878999L, 950000, proprietairesComptes);  
   creerCompte(12345678910L, 20000, proprietairesComptes);  
   creerCompte(12389654610L, 100000, proprietairesComptes);  
  
} 

  
  

   
}
