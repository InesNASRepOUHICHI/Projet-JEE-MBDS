/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unice.banque.session;

import edu.unice.banque.entities.OldCompteBancaire;
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
public class GestionnaireDeCompteBancaire {

    @PersistenceContext(unitName = "TP3-BanqueInesDiallo-ejbPU")
    private EntityManager em;


    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private OldCompteBancaire compteBancaire;

    public  OldCompteBancaire deposer(OldCompteBancaire compte,int montant) {
     compteBancaire.setSolde(compteBancaire.getSolde() + montant);
        em.merge(compte);
        return update (compte);

    }

    public OldCompteBancaire retirer(OldCompteBancaire compte,int montant) {
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

    public OldCompteBancaire getCompte(int idCompte) {
        return em.find(OldCompteBancaire.class, idCompte);  

    }
   public void transfertArgent(Long idDebiteur,Long idCrediteur, int montant){
        
        OldCompteBancaire compteDebiteur = chercherCompteById(idDebiteur);
        OldCompteBancaire compteCrediteur= chercherCompteById(idCrediteur);
        
       retirer(compteDebiteur,montant);
       deposer(compteCrediteur,montant);
        
        
        em.merge(compteDebiteur);
        em.merge(compteCrediteur);
    }
    
  
    
     public OldCompteBancaire consulter(long id) {   
        return em.find(OldCompteBancaire.class, id);
    }


    public void persist(Object object) {
        em.persist(object);
    }

   
    
     public OldCompteBancaire creerCompte(String nom, int solde){
        OldCompteBancaire compte = new OldCompteBancaire(nom,solde);
       em.persist(compte);
       return compte;
    }

    
      public OldCompteBancaire update(OldCompteBancaire compte) {
      return em.merge(compte); 
    }
      
    public List<OldCompteBancaire> getAllComptes() {
       Query query = em.createNamedQuery("OldCompteBancaire.findAll");  
        return query.getResultList(); 
    }
    
    public List<OldCompteBancaire> getComptes(int start, int nombreDeComptes){
    Query query=em.createNamedQuery("OldCompteBancaire.findAll");
    query.setFirstResult(start);
    query.setMaxResults(nombreDeComptes);
    
    return query.getResultList();
    }
    
    
    public void delete(OldCompteBancaire c){
    em.remove(c);    }
    
    public OldCompteBancaire chercherCompteById(Long id){
    Query query=em.createNamedQuery("OldCompteBancaire.findById").setParameter("id",id);
    return(OldCompteBancaire)query.getSingleResult();
    }
   
  
   public void creerComptesTest() {     
   creerCompte("Ines", 1500); 
   creerCompte("Dialo", 50000); 
   creerCompte("John Lennon", 150000);  
   creerCompte("Paul McCartney", 950000);  
   creerCompte("Ringo Starr", 20000);  
   creerCompte("Georges Harrisson", 100000); 
  
} 

  
  

   
}
