/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unice.banque.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author INES NASR
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_COMPTE")
@DiscriminatorValue("COMPTE")
@XmlRootElement
public class Compte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long numeroCompte;
    private double solde;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Client> listeClientsProprietaires = new ArrayList<Client>();

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Operation> listeOperations = new ArrayList<Operation>();

    public Compte() {
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public List<Client> getListeClientsProprietaires() {
        return listeClientsProprietaires;
    }

    public void setListeClientsProprietaires(List<Client> listeClientsProprietaires) {
        this.listeClientsProprietaires = listeClientsProprietaires;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.solde) ^ (Double.doubleToLongBits(this.solde) >>> 32));
        return hash;
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
        final Compte other = (Compte) obj;
        if (Double.doubleToLongBits(this.solde) != Double.doubleToLongBits(other.solde)) {
            return false;
        }
        if (!Objects.equals(this.numeroCompte, other.numeroCompte)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.listeClientsProprietaires, other.listeClientsProprietaires)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Compte{" + "id=" + id + ", numeroCompte=" + numeroCompte + ", solde=" + solde + ", listeClientsProprietaires=" + listeClientsProprietaires + ", listeOperations=" + listeOperations + '}';
    }

   

    public Compte(Long numeroCompte, double solde) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
    }

    public Compte(Long id, Long numeroCompte, double solde, List<Client> listeClientsProprietaires) {
        this.id = id;
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.listeClientsProprietaires = listeClientsProprietaires;
    }

    public Long getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(Long numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

}
