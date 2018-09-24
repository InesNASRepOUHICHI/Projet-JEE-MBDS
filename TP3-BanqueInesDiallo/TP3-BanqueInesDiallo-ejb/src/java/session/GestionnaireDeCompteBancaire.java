/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.CompteBancaire;
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
    private CompteBancaire compteBancaire;

    public  CompteBancaire deposer(CompteBancaire compte,int montant) {
     compteBancaire.setSolde(compteBancaire.getSolde() + montant);
        em.merge(compte);
        return update (compte);

    }

    public CompteBancaire retirer(CompteBancaire compte,int montant) {
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

    public CompteBancaire getCompte(int idCompte) {
        return em.find(CompteBancaire.class, idCompte);  

    }
   public void transfertArgent(Long idDebiteur,Long idCrediteur, int montant){
        
        CompteBancaire compteDebiteur = chercherCompteById(idDebiteur);
        CompteBancaire compteCrediteur= chercherCompteById(idCrediteur);
        
       retirer(compteDebiteur,montant);
       deposer(compteCrediteur,montant);
        
        
        em.merge(compteDebiteur);
        em.merge(compteCrediteur);
    }
    
  
    
     public CompteBancaire consulter(long id) {   
        return em.find(CompteBancaire.class, id);
    }


    public void persist(Object object) {
        em.persist(object);
    }

   
    
     public CompteBancaire creerCompte(String nom, int solde){
        CompteBancaire compte = new CompteBancaire(nom,solde);
       em.persist(compte);
       return compte;
    }

    
      public CompteBancaire update(CompteBancaire compte) {
      return em.merge(compte); 
    }
      
    public List<CompteBancaire> getAllComptes() {
       Query query = em.createNamedQuery("CompteBancaire.findAll");  
        return query.getResultList(); 
    }
    
    public List<CompteBancaire> getComptes(int start, int nombreDeComptes){
    Query query=em.createNamedQuery("CompteBancaire.findAll");
    query.setFirstResult(start);
    query.setMaxResults(nombreDeComptes);
    
    return query.getResultList();
    }
    
    
    public void delete(CompteBancaire c){
    em.remove(c);    }
    
    public CompteBancaire chercherCompteById(Long id){
    Query query=em.createNamedQuery("CompteBancaire.findById").setParameter("id",id);
    return(CompteBancaire)query.getSingleResult();
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
