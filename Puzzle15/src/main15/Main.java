package main15;

import java.util.Arrays;
import kayttoliittyma.Kayttoliittyma;
import kayttoliittyma.Piirtoalusta;
import pelilauta.Koordinaatit;
import pelilauta.Laatta;
import pelilauta.Lauta;
import ratkaisija.Ratkaisija;
import ratkaisija.Suunta;

/**
 *
 * @author eamiller
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Laatta laatta = new Laatta(1, 50, 50);
        Lauta lauta = new Lauta(4);
        
        int[] arvot = {11, 12, 4, 3,
                       10, 8, 7, 5,
                       15, 6, 2, 13 , 
                       9, 14, 1, 0};
        lauta.lisaaLaatat(arvot);
        Ratkaisija r = new Ratkaisija(lauta);
        
        
        Piirtoalusta p = new Piirtoalusta(lauta);
        Kayttoliittyma k = new Kayttoliittyma(p);
        Peli peli = new Peli(lauta, p);
        k.run();

        peli.pelaa();

    }

}
