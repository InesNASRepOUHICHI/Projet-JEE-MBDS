/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unice.banque.entities;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author deptinfo
 */
@Entity
@DiscriminatorValue("COMPTE_EPARGNE")
public class CompteEpargne extends Compte implements Serializable {

    private double taux;
    private double maxEpargne;
    private double minEpargne;

    public CompteEpargne() {
    }

    public CompteEpargne(double taux, double maxEpargne, double minEpargne) {
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
