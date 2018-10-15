/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unice.banque.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author INES NASR
 */
@Entity 
@Table(name = "COMPTEBANCAIRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name="CompteBancaire.findAll",query="SELECT c FROM Compte c ORDER BY c.numero"),
    @NamedQuery(name="CompteBancaire.findByNumero",query="SELECT c FROM Compte c WHERE c.numero = :numero"),
    @NamedQuery(name="CompteBancaire.nbComptes",query="SELECT COUNT(c) FROM Compte c")})
public class OldCompteBancaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private int solde;

    public OldCompteBancaire(int solde) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public OldCompteBancaire() {
    }

    public OldCompteBancaire(String nom, int solde) {
        this.nom = nom;
        this.solde = solde;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OldCompteBancaire)) {
            return false;
        }
        OldCompteBancaire other = (OldCompteBancaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CompteBancaire[ id=" + id + " ]";
    }

 
}
