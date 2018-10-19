/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unice.banque.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author INES NASR
 */
@Entity
public class Administrateur extends Personnee implements Serializable {

    @OneToMany
    private List<Conseiller> listeConseillers;

    public Administrateur() {
    }

    
    public Administrateur(List<Conseiller> listeConseillers) {
        this.listeConseillers = listeConseillers;
    }

    public Administrateur(List<Conseiller> listeConseillers, String nom, String prenom, String numeroTelephone, String adresse, String sexe, String email, String password, Role role) {
        super(nom, prenom, numeroTelephone, adresse, sexe, email, password, role);
        this.listeConseillers = listeConseillers;
    }

    public Administrateur(List<Conseiller> listeConseillers, Long id, String nom, String prenom, String numeroTelephone, String adresse, String sexe, String email, String password, Role role) {
        super(id, nom, prenom, numeroTelephone, adresse, sexe, email, password, role);
        this.listeConseillers = listeConseillers;
    }

    public List<Conseiller> getListeConseillers() {
        return listeConseillers;
    }

    public void setListeConseillers(List<Conseiller> listeConseillers) {
        this.listeConseillers = listeConseillers;
    }

    @Override
    public String toString() {
        return "Administrateur{" + "listeConseillers=" + listeConseillers + '}';
    }
    
    
}
