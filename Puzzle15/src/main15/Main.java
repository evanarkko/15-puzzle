
package main15;

import java.util.Arrays;
import kayttoliittyma.Kayttoliittyma;
import kayttoliittyma.Piirtoalusta;
import pelilauta.Laatta;
import pelilauta.Lauta;
import pelilogiikka.Puzzle;

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
        Lauta lauta = new Lauta(4);
        lauta.lisaaLaatatJarjestykseen();
        lauta.siirraOikealle(2, 3);
        
        Puzzle puzzle = new Puzzle(lauta);
        Piirtoalusta p = new Piirtoalusta(puzzle);
        Kayttoliittyma k = new Kayttoliittyma(p);
        k.run();
    }
    
}
