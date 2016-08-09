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
public class LautaTest {
    Lauta instance;
    
    public LautaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Lauta(4);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of lisaaLaatat method, of class Lauta.
     */
    @Test
    public void testLisaaLaatat() {
        System.out.println("lisaaLaatat");
        instance.lisaaLaatat();
        int laattoja = instance.getLaattoja();
        assertEquals(laattoja, 15);
    }


    /**
     * Test of getLaattoja method, of class Lauta.
     */
    @Test
    public void testGetLaattoja() {
        System.out.println("getLaattoja");
        int expResult = 15;
        int result = instance.getLaattoja();
        assertEquals(expResult, result);
    }

    /**
     * Test of lisaaLaatatJarjestykseen method, of class Lauta.
     */
    @Test
    public void testLisaaLaatatJarjestykseen() {
        System.out.println("lisaaLaatatJarjestykseen");
        instance.lisaaLaatatJarjestykseen();
        assertTrue(instance.onkoJarjestyksessa());
    }

    /**
     * Test of siirraOikealle method, of class Lauta.
     */
    @Test
    public void testSiirraOikealle() {
        System.out.println("siirraOikealle");
        int x = 0;
        int y = 0;
        instance.siirraOikealle(x, y);
        assertNull(instance.getLauta()[x][y]);
    }

    /**
     * Test of siirraVasemmalle method, of class Lauta.
     */
    @Test
    public void testSiirraVasemmalle() {
        System.out.println("siirraVasemmalle");
        int x = 1;
        int y = 1;
        instance.siirraVasemmalle(x, y);
        assertNull(instance.getLauta()[x][y]);
    }

    /**
     * Test of siirraAlas method, of class Lauta.
     */
    @Test
    public void testSiirraAlas() {
        System.out.println("siirraAlas");
        int x = 0;
        int y = 0;
        instance.siirraAlas(x, y);
        assertNull(instance.getLauta()[x][y]);
    }

    /**
     * Test of siirraYlos method, of class Lauta.
     */
    @Test
    public void testSiirraYlos() {
        System.out.println("siirraYlos");
        int x = 0;
        int y = 1;
        instance.siirraYlos(x, y);
        assertNull(instance.getLauta()[x][y]);
    }

    /**
     * Test of getLaatatYhtenaListana method, of class Lauta.
     */
    @Test
    public void testGetLaatatYhtenaListana() {
        System.out.println("getLaatatYhtenaListana");
        Laatta[] result = instance.getLaatatYhtenaListana();
        assertEquals(15, result.length);
    }

    /**
     * Test of onkoJarjestyksessa method, of class Lauta.
     */
    @Test
    public void testOnkoJarjestyksessa() {
        System.out.println("onkoJarjestyksessa");
        instance.lisaaLaatatJarjestykseen();
        boolean result = instance.onkoJarjestyksessa();
        assertTrue(result);
    }
    
}
