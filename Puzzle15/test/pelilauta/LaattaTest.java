/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelilauta;

import java.awt.Graphics;
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
public class LaattaTest {
    Laatta instance;
    
    public LaattaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Laatta(1, 0, 0);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getArvo method, of class Laatta.
     */
    @Test
    public void testGetArvo() {
        System.out.println("getArvo");
        int expResult = 1;
        int result = instance.getArvo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPelikoordinaatit method, of class Laatta.
     */
    @Test
    public void testSetPelikoordinaatit() {
        System.out.println("setPelikoordinaatit");
        int x = 0;
        int y = 0;
        instance.setPelikoordinaatit(x, y);
    }

    /**
     * Test of setTrueKoordinaatit method, of class Laatta.
     */
    @Test
    public void testSetTrueKoordinaatit() {
        System.out.println("setTrueKoordinaatit");
        int x = 0;
        int y = 0;
        instance.setTrueKoordinaatit(x, y);
    }

    /**
     * Test of siirraOikealle method, of class Laatta.
     */
    @Test
    public void testSiirraOikealle() {
        System.out.println("siirraOikealle");
        instance.siirraOikealle();
        int uusix = instance.getPelikoordinaatit().x();
        assertEquals(uusix, 1);
    }

    /**
     * Test of siirraVasemmalle method, of class Laatta.
     */
    @Test
    public void testSiirraVasemmalle() {
        System.out.println("siirraVasemmalle");
        instance.setPelikoordinaatit(1, 1);
        instance.siirraVasemmalle();
        assertEquals(instance.getPelikoordinaatit().x(), 0);
    }

    /**
     * Test of siirraAlas method, of class Laatta.
     */
    @Test
    public void testSiirraAlas() {
        System.out.println("siirraAlas");
        instance.siirraAlas();
        assertEquals(instance.getPelikoordinaatit().y(), 1);
    }

    /**
     * Test of siirraYlos method, of class Laatta.
     */
    @Test
    public void testSiirraYlos() {
        System.out.println("siirraYlos");
        instance.setPelikoordinaatit(1, 1);
        instance.siirraYlos();
        assertEquals(0, instance.getPelikoordinaatit().y());
    }
    
}
