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
public class KoordinaatitTest {
        Koordinaatit instance;

    public KoordinaatitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new Koordinaatit(0, 0);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of x method, of class Koordinaatit.
     */
    @Test
    public void testX() {
        System.out.println("x");
        Koordinaatit instance = new Koordinaatit(0, 0);
        int expResult = 0;
        int result = instance.x();
        assertEquals(expResult, result);
    }

    /**
     * Test of y method, of class Koordinaatit.
     */
    @Test
    public void testY() {
        System.out.println("y");
        Koordinaatit instance = new Koordinaatit(0, 0);
        int expResult = 0;
        int result = instance.y();
        assertEquals(expResult, result);
    }

    /**
     * Test of incx method, of class Koordinaatit.
     */
    @Test
    public void testIncx() {
        System.out.println("incx");
        instance.incx();
        assertEquals(1, instance.x());
    }

    /**
     * Test of incy method, of class Koordinaatit.
     */
    @Test
    public void testIncy() {
        System.out.println("incy");
        instance.incy();
        assertEquals(1, instance.y());
    }

    /**
     * Test of decx method, of class Koordinaatit.
     */
    @Test
    public void testDecx() {
        System.out.println("decx");
        instance.decx();
        assertEquals(-1, instance.x());
    }

    /**
     * Test of decy method, of class Koordinaatit.
     */
    @Test
    public void testDecy() {
        System.out.println("decy");
        instance.decy();
        assertEquals(-1, instance.y());
    }

    /**
     * Test of incx method, of class Koordinaatit.
     */
    @Test
    public void testIncx_int() {
        System.out.println("incx");
        int maara = 5;
        int vanha = instance.x();
        instance.incx(maara);
        assertEquals(maara + vanha, instance.x());
    }

    /**
     * Test of incy method, of class Koordinaatit.
     */
    @Test
    public void testIncy_int() {
        System.out.println("incy");
        int maara = 5;
        int vanha = instance.y();
        instance.incy(maara);
        assertEquals(maara + vanha, instance.y());
    }

    /**
     * Test of decx method, of class Koordinaatit.
     */
    @Test
    public void testDecx_int() {
        System.out.println("decx");
        int maara = 5;
        int vanha = instance.x();
        instance.decx(maara);
        assertEquals(vanha - maara, instance.x());
    }

    /**
     * Test of decy method, of class Koordinaatit.
     */
    @Test
    public void testDecy_int() {
        System.out.println("decy");
        int maara = 5;
        int vanha = instance.y();
        instance.decy(maara);
        assertEquals(vanha - maara, instance.y());
    }
    /**
     * Test of onkoVieressa method, of class Koordinaatit.
     */
    @Test
    public void testOnkoVieressa() {
        System.out.println("onkoVieressa");
        this.instance = new Koordinaatit(2, 2);
        Koordinaatit eka = new Koordinaatit(1, 2);
        Koordinaatit toka = new Koordinaatit(3, 2);
        Koordinaatit kolmas = new Koordinaatit(2, 1);
        Koordinaatit neljas = new Koordinaatit(2, 3);
        assertTrue(instance.onkoVieressa(eka));
        assertTrue(instance.onkoVieressa(toka));
        assertTrue(instance.onkoVieressa(kolmas));
        assertTrue(instance.onkoVieressa(neljas));
    }

    /**
     * Test of equals method, of class Koordinaatit.
     */
//    @Test
//    public void testEquals() {
//        System.out.println("equals");
//        Object obj = null;
//        Koordinaatit instance = null;
//        boolean expResult = false;
//        boolean result = instance.equals(obj);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of toString method, of class Koordinaatit.
     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        Koordinaatit instance = null;
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    

}
