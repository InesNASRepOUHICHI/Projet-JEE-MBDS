/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unice.banque.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author INES NASR
 */
@Entity
public class Client extends Personnee implements Serializable {

    private int estCoProprietaire;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "client_compte",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "compte_id")
    )
    private List<Compte> listComptes = new ArrayList<Compte>();

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private Conseiller conseiller;

    public Client() {
    }

    public Client(int estCoProprietaire, List<Compte> listComptes, Conseiller conseiller, List<Operation> listeOperations) {
        this.estCoProprietaire = estCoProprietaire;
        this.listComptes = listComptes;
        this.conseiller = conseiller;
    }

    public Client(int estCoProprietaire, List<Compte> listComptes, Conseiller conseiller, List<Operation> listeOperations, String nom, String prenom, String numeroTelephone, String adresse, String sexe, String email, String password, Role role) {
        super(nom, prenom, numeroTelephone, adresse, sexe, email, password, role);
        this.estCoProprietaire = estCoProprietaire;
        this.listComptes = listComptes;
        this.conseiller = conseiller;
    }

    public Client(int estCoProprietaire, List<Compte> listComptes, Conseiller conseiller, List<Operation> listeOperations, Long id, String nom, String prenom, String numeroTelephone, String adresse, String sexe, String email, String password, Role role) {
        super(id, nom, prenom, numeroTelephone, adresse, sexe, email, password, role);
        this.estCoProprietaire = estCoProprietaire;
        this.listComptes = listComptes;
        this.conseiller = conseiller;
    }

    public int isEstCoProprietaire() {
        return estCoProprietaire;
    }

    public void setEstCoProprietaire(int estCoProprietaire) {
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
        return super.toString() + "Client{" + "estCoProprietaire=" + estCoProprietaire + ", listComptes=" + listComptes + ", conseiller=" + conseiller + '}';
    }

    public int getEstCoProprietaire() {
        return estCoProprietaire;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.estCoProprietaire;
        return hash;
    }

}
