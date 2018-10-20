/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unice.banque.entities;

/**
 *
 * @author INES NASR
 */
public enum Role {
    CLIENT("CLIENT"),
    CONSEILLER("CONSEILLER"),
    ADMIN("ADMIN"),
    UNDEFINED("UNDEFINED");
 
    private final String role;
 
    Role(String role) {
        this.role = role;
    }
 
    public String getRole() {
        return role;
    }
}
