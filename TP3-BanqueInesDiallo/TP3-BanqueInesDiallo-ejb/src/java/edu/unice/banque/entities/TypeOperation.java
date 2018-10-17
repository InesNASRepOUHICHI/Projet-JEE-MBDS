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
public enum TypeOperation {
    
    VIREMENT("VIREMENT"),
    VERSEMENT("VE VIREMENT(\"VIRRSEMENT"),
    RETRAIT("RETRAIT");
 
    private final String typeOperation;
 
    TypeOperation(String typeOp) {
        this.typeOperation = typeOp;
    }
 
    public String gettypeOperation() {
        return typeOperation;
    }
    
}
