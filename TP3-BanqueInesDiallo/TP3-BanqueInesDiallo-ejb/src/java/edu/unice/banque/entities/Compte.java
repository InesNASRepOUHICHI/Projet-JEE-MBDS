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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author INES NASR
 */
@Entity  @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) 
@XmlRootElement
@NamedQueries({
    @NamedQuery(name="Compte.findAll",query="SELECT c FROM Compte c ORDER BY c.numero"),
    @NamedQuery(name="Compte.findByNumero",query="SELECT c FROM Compte c WHERE c.numero = :numero"),
    @NamedQuery(name="Compte.nbComptes",query="SELECT COUNT(c) FROM Compte c")})

public class Compte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numero;
    private double solde;
    
    @ManyToMany(cascade={CascadeType.PERSIST}, fetch= FetchType.EAGER)
    private List<Client> listeClientsProprietaires;

    public Compte() {
    }

  

    public Compte(Long num, double solde) {
       this.numero=num;
       this.solde=solde;
    }
    
    
    
    

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
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

    public Compte(Long numero, double solde, List<Client> listeClientsProprietaires) {
        this.numero = numero;
        this.solde = solde;
        this.listeClientsProprietaires = listeClientsProprietaires;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.numero);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.solde) ^ (Double.doubleToLongBits(this.solde) >>> 32));
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
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Compte{" + "numero=" + numero + ", solde=" + solde + ", listeClientsProprietaires=" + listeClientsProprietaires + '}';
    }

    
}
