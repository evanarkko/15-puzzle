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
        lauta.lisaaLaatatJarjestykseen();
        Ratkaisija r = new Ratkaisija(lauta);
        r.siirraKohtiPaikkaa(new Koordinaatit(3, 3), new Koordinaatit(2, 3));
        r.siirraKohtiPaikkaa(new Koordinaatit(3, 3), new Koordinaatit(2, 3));
        r.siirraKohtiPaikkaa(new Koordinaatit(3, 3), new Koordinaatit(2, 3));
        
        
        Piirtoalusta p = new Piirtoalusta(lauta);
        Kayttoliittyma k = new Kayttoliittyma(p);
        Peli peli = new Peli(lauta, p);
        k.run();

//        peli.pelaa();

    }

}
