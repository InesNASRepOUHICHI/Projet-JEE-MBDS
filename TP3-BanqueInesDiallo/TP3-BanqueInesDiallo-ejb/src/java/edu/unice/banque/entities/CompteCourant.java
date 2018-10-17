/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unice.banque.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author deptinfo
 */
@Entity 
public class CompteCourant extends Compte implements Serializable {
    private double montantPret;
    private double montantDecouvert;
    public CompteCourant() {
        
    }

    public CompteCourant(Long numero, double solde, List<Client> listeClientsProprietaires,double pret,double montantDecouvert) {
        super(numero, solde, listeClientsProprietaires);
        this.montantPret = pret;
        this.montantDecouvert = montantDecouvert;
    }
    
    
}

  
