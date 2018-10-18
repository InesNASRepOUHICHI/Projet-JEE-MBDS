/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unice.banque.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author INES NASR
 */
@Entity
public class Client extends Personnee implements Serializable  {
    private boolean estCoProprietaire;
    
    @ManyToMany
    private List<Compte> listComptes;
    
    @ManyToOne(cascade={CascadeType.ALL}, fetch= FetchType.EAGER)
    private Conseiller conseiller;
    
    @OneToMany(cascade={CascadeType.ALL}, fetch= FetchType.EAGER)
    private List<Operation> listeOperations;

    public Client() {
    }

    public Client(boolean estCoProprietaire, List<Compte> listComptes, Conseiller conseiller, List<Operation> listeOperations) {
        this.estCoProprietaire = estCoProprietaire;
        this.listComptes = listComptes;
        this.conseiller = conseiller;
        this.listeOperations = listeOperations;
    }

    public Client(boolean estCoProprietaire, List<Compte> listComptes, Conseiller conseiller, List<Operation> listeOperations, String nom, String prenom, String numeroTelephone, String adresse, String sexe, String email, String password, String role) {
        super(nom, prenom, numeroTelephone, adresse, sexe, email, password, role);
        this.estCoProprietaire = estCoProprietaire;
        this.listComptes = listComptes;
        this.conseiller = conseiller;
        this.listeOperations = listeOperations;
    }

    public Client(boolean estCoProprietaire, List<Compte> listComptes, Conseiller conseiller, List<Operation> listeOperations, Long id, String nom, String prenom, String numeroTelephone, String adresse, String sexe, String email, String password, String role) {
        super(id, nom, prenom, numeroTelephone, adresse, sexe, email, password, role);
        this.estCoProprietaire = estCoProprietaire;
        this.listComptes = listComptes;
        this.conseiller = conseiller;
        this.listeOperations = listeOperations;
    }

   

    public boolean isEstCoProprietaire() {
        return estCoProprietaire;
    }

    public void setEstCoProprietaire(boolean estCoProprietaire) {
        this.estCoProprietaire = estCoProprietaire;
    }

    public List<Compte> getListComptes() {
        return listComptes;
    }

    public void setListComptes(List<Compte> listComptes) {
        this.listComptes = listComptes;
    }

 

    public Conseiller getConseiller() {
        return conseiller;
    }

    public void setConseiller(Conseiller conseiller) {
        this.conseiller = conseiller;
    }

    public List<Operation> getListeOperations() {
        return listeOperations;
    }

    public void setListeOperations(List<Operation> listeOperations) {
        this.listeOperations = listeOperations;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (this.estCoProprietaire != other.estCoProprietaire) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Client{" + "estCoProprietaire=" + estCoProprietaire + ", listComptes=" + listComptes + ", conseiller=" + conseiller + ", listeOperations=" + listeOperations + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.estCoProprietaire ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.listComptes);
        hash = 97 * hash + Objects.hashCode(this.conseiller);
        hash = 97 * hash + Objects.hashCode(this.listeOperations);
        return hash;
    }

   
}