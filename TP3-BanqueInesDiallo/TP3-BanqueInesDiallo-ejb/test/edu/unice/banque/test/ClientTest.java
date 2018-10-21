/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unice.banque.test;

import edu.unice.banque.entities.Client;
import edu.unice.banque.session.GestionnaireClientBean;
import javax.ejb.EJB;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author INES NASR
 */
public class ClientTest {

    @EJB
    private GestionnaireClientBean clientManager;

    public ClientTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getClientByEmail() {
        Client c = clientManager.findClientByEmail("ines@gmail.com");
        assertEquals(c.getNom(), "NASR");
    }
}
