package main15;

import java.util.Arrays;
import kayttoliittyma.Kayttoliittyma;
import kayttoliittyma.Piirtoalusta;
import kayttoliittyma.RatkaisijaKuuntelija;
import kayttoliittyma.SekoittajaKuuntelija;
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
        lauta.lisaaLaatatSekoitettuna();
        
        
        Piirtoalusta p = new Piirtoalusta(lauta);
        Peli peli = new Peli(lauta, p);
        
        SekoittajaKuuntelija sk = new SekoittajaKuuntelija(peli);
        RatkaisijaKuuntelija rk = new RatkaisijaKuuntelija(peli);
        Kayttoliittyma k = new Kayttoliittyma(p, rk, sk);
        k.run();

        peli.pelaa();
    }

}
