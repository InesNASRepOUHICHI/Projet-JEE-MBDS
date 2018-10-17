/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unice.banque.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author INES NASR
 */
@Entity
public class Conseiller extends Personnee implements Serializable {

    @OneToMany
    private List<Client> listeClients;
    
    @ManyToOne
    private Administrateur administrateur;

    public Conseiller() {
    }
    
    

    public Conseiller(List<Client> listeClients, Administrateur administrateur) {
        this.listeClients = listeClients;
        this.administrateur = administrateur;
    }

    public Conseiller(List<Client> listeClients, Administrateur administrateur, String nom, String prenom, String numeroTelephone, String adresse, String sexe, String email, String password, String role) {
        super(nom, prenom, numeroTelephone, adresse, sexe, email, password, role);
        this.listeClients = listeClients;
        this.administrateur = administrateur;
    }

    public Conseiller(List<Client> listeClients, Administrateur administrateur, Long id, String nom, String prenom, String numeroTelephone, String adresse, String sexe, String email, String password, String role) {
        super(id, nom, prenom, numeroTelephone, adresse, sexe, email, password, role);
        this.listeClients = listeClients;
        this.administrateur = administrateur;
    }

    public List<Client> getListeClients() {
        return listeClients;
    }

    public void setListeClients(List<Client> listeClients) {
        this.listeClients = listeClients;
    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }

    @Override
    public String toString() {
        return "Conseiller{" + "listeClients=" + listeClients + ", administrateur=" + administrateur + '}';
    }
    
    
    
    
}
