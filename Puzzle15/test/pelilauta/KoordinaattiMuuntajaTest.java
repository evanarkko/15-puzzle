/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelilauta;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eamiller
 */
public class KoordinaattiMuuntajaTest {
    
    public KoordinaattiMuuntajaTest() {
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
    public void testSomeMethod() {
    }
    
    

    /**
     * Test of trueToGame method, of class KoordinaattiMuuntaja.
     */
    @Test
    public void testTrueToGame() {
        KoordinaattiMuuntaja instance = new KoordinaattiMuuntaja(50, 50);
        Koordinaatit expResult = null;
        Koordinaatit result = instance.trueToGame();
        assertEquals(expResult, result);
    }

    /**
     * Test of gameToTrue method, of class KoordinaattiMuuntaja.
     */
    @Test
    public void testGameToTrue() {
        System.out.println("gameToTrue");
        Koordinaatit k = null;
        KoordinaattiMuuntaja instance = null;
        Koordinaatit expResult = null;
        Koordinaatit result = instance.gameToTrue(k);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
