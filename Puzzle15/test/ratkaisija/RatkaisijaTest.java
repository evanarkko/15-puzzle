/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ratkaisija;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pelilauta.Koordinaatit;
import pelilauta.Lauta;

/**
 *
 * @author eamiller
 */
public class RatkaisijaTest {
    
    public RatkaisijaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Lauta l = new Lauta(4);
        Ratkaisija ratkaisija = new Ratkaisija(l);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of seuraavaSiirto method, of class Ratkaisija.
     */
    @Test
    public void testSeuraavaSiirto() {
        System.out.println("seuraavaSiirto");
        Ratkaisija instance = null;
        instance.seuraavaSiirto();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of siirraKohtiPaikkaa method, of class Ratkaisija.
     */
    @Test
    public void testSiirraKohtiPaikkaa() {
        System.out.println("siirraKohtiPaikkaa");
        Koordinaatit siirrettava = null;
        Koordinaatit kohde = null;
        Ratkaisija instance = null;
        boolean expResult = false;
        boolean result = instance.siirraKohtiPaikkaa(siirrettava, kohde);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of siirraNullSpacea method, of class Ratkaisija.
     */
    @Test
    public void testSiirraNullSpacea_Koordinaatit_Suunta() {
        System.out.println("siirraNullSpacea");
        Koordinaatit vaista = null;
        Suunta s = null;
        Ratkaisija instance = null;
        instance.siirraNullSpacea(vaista, s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of siirraNullSpacea method, of class Ratkaisija.
     */
    @Test
    public void testSiirraNullSpacea_Suunta_Alas() {
        System.out.println("siirraNullSpaceaAlas");
        
    }
    
    /**
     * Test of siirraNullSpacea method, of class Ratkaisija.
     */
    @Test
    public void testSiirraNullSpacea_Suunta_Ylos() {
        System.out.println("siirraNullSpacea");
        
    }
    
    /**
     * Test of siirraNullSpacea method, of class Ratkaisija.
     */
    @Test
    public void testSiirraNullSpacea_Suunta_Vasen() {
        System.out.println("siirraNullSpacea");
        
    }
    
    /**
     * Test of siirraNullSpacea method, of class Ratkaisija.
     */
    @Test
    public void testSiirraNullSpacea_Suunta_Oikea() {
        System.out.println("siirraNullSpacea");
        
    }
    
}
