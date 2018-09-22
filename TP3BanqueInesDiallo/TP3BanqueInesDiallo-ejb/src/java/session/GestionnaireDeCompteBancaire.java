/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.CompteBancaire;
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

    @PersistenceContext(unitName = "TP3BanqueInesDiallo-ejbPU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private CompteBancaire compteBancaire;

    public void deposer(int montant) {
        compteBancaire.setSolde(compteBancaire.getSolde() + montant);
    }

    public int retirer(int montant) {
        if (montant < compteBancaire.getSolde()) {
            compteBancaire.setSolde(compteBancaire.getSolde() - montant);
            return montant;
        } else {
            return 0;
        }

    }

    public void persist(Object object) {
        em.persist(object);
    }

    public void creerCompte(CompteBancaire c) {
        em.persist(c);
    }

    public List<CompteBancaire> getAllComptes() {
        Query query = em.createNamedQuery("CompteBancaire.findAll");
        return query.getResultList();
    }
    
   public void creerComptesTest() {  
   creerCompte(new CompteBancaire("John Lennon", 150000));  
   creerCompte(new CompteBancaire("Paul McCartney", 950000));  
   creerCompte(new CompteBancaire("Ringo Starr", 20000));  
   creerCompte(new CompteBancaire("Georges Harrisson", 100000));  
} 
   
   public void initialize(){
       creerCompte(new CompteBancaire("John Lennon", 150000));
   }

   
}
