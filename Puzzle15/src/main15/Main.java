
package main15;

import java.util.Arrays;
import kayttoliittyma.Kayttoliittyma;
import kayttoliittyma.Piirtoalusta;
import pelilauta.Laatta;
import pelilauta.Lauta;

/**
 *
 * @author eamiller
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Laatta laatta = new Laatta(1, 50, 50);
        Lauta lauta = new Lauta(5);
        lauta.lisaaLaatatJarjestykseen();
        System.out.println(lauta.onkoJarjestyksessa());
        
        
        Piirtoalusta p = new Piirtoalusta(lauta);
        Kayttoliittyma k = new Kayttoliittyma(p);
        k.run();
    }
    
}
