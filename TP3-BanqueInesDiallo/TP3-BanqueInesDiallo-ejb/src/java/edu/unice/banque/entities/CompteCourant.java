/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unice.banque.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author deptinfo
 */
@Entity 
@DiscriminatorValue("COMPTE_COURANT")
public class CompteCourant extends Compte implements Serializable {
    private double montantPret;
    private double montantDecouvert;
    public CompteCourant() {
        
    }

    public CompteCourant(double montantPret, double montantDecouvert) {
        this.montantPret = montantPret;
        this.montantDecouvert = montantDecouvert;
    }

    public double getMontantPret() {
        return montantPret;
    }

    public void setMontantPret(double montantPret) {
        this.montantPret = montantPret;
    }

    public double getMontantDecouvert() {
        return montantDecouvert;
    }

    public void setMontantDecouvert(double montantDecouvert) {
        this.montantDecouvert = montantDecouvert;
    }

   
    
    
}

  
