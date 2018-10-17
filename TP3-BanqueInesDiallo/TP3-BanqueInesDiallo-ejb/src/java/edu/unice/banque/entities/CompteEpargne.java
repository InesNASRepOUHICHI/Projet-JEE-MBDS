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
public class CompteEpargne extends  Compte implements Serializable {
 private double taux;
 private double maxEpargne;
 private double minEpargne;

    public CompteEpargne() {
    }

    public CompteEpargne(Long numero, double solde, List<Client> listeClientsProprietaires,double taux,double maxEpargne,double minEpargne) {
        super(numero, solde, listeClientsProprietaires);
        this.taux = taux;
        this.maxEpargne = maxEpargne;
        this.minEpargne = minEpargne;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    public double getMaxEpargne() {
        return maxEpargne;
    }

    public void setMaxEpargne(double maxEpargne) {
        this.maxEpargne = maxEpargne;
    }

    public double getMinEpargne() {
        return minEpargne;
    }

    public void setMinEpargne(double minEpargne) {
        this.minEpargne = minEpargne;
    }

    @Override
    public String toString() {
        return "CompteEpargne{" + "taux=" + taux + ", maxEpargne=" + maxEpargne + ", minEpargne=" + minEpargne + '}';
    }
 
   
    
}
