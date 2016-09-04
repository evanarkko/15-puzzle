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
    Lauta l;
    Ratkaisija ratkaisija;
    
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
        l = new Lauta(4);
        l.lisaaLaatatSekoitettuna();
        ratkaisija = new Ratkaisija(l);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of siirraNullSpacea method, of class Ratkaisija.
     */
    @Test
    public void testSiirraNullSpacea_Suunta_Alas() {
        int y = l.getNullSpace().y();
        ratkaisija.siirraNullSpacea(Suunta.ALAS);
        boolean toimii = false;
        if(y == 3 && y == l.getNullSpace().y()) toimii = true;
        if(y == l.getNullSpace().y()-1) toimii = true;
        assertTrue(toimii);
        
        
    }
    
    /**
     * Test of siirraNullSpacea method, of class Ratkaisija.
     */
    @Test
    public void testSiirraNullSpacea_Suunta_Ylos() {
        Koordinaatit alkuNull = new Koordinaatit(l.getNullSpace().x(), l.getNullSpace().y());
        ratkaisija.siirraNullSpacea(Suunta.YLOS);
        boolean toimii = true;
        if(alkuNull.equals(l.getNullSpace())){
            if(alkuNull.y()!=0)toimii = false;
        }
        assertTrue(toimii);
    }
    
    /**
     * Test of siirraNullSpacea method, of class Ratkaisija.
     */
    @Test
    public void testSiirraNullSpacea_Suunta_Vasen() {
        Koordinaatit alkuNull = new Koordinaatit(l.getNullSpace().x(), l.getNullSpace().y());
        ratkaisija.siirraNullSpacea(Suunta.VASEN);
        boolean toimii = true;
        if(alkuNull.equals(l.getNullSpace())){
            if(alkuNull.x()!=0)toimii = false;
        }
        assertTrue(toimii);
        
    }
    
    /**
     * Test of siirraNullSpacea method, of class Ratkaisija.
     */
    @Test
    public void testSiirraNullSpacea_Suunta_Oikea() {
        Koordinaatit alkuNull = new Koordinaatit(l.getNullSpace().x(), l.getNullSpace().y());
        ratkaisija.siirraNullSpacea(Suunta.OIKEA);
        boolean toimii = true;
        if(alkuNull.equals(l.getNullSpace())){
            if(alkuNull.x()!=3)toimii = false;
        }
        assertTrue(toimii);
        
    }
    
}
