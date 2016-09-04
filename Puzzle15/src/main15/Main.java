package main15;

import Pelilogiikka.Peli;
import java.util.Arrays;
import kuuntelijat.HiirenKuuntelija;
import kayttoliittyma.Kayttoliittyma;
import kayttoliittyma.Piirtoalusta;
import kuuntelijat.NappaintenKuuntelija;
import kuuntelijat.RatkaisijaNapinKuuntelija;
import kuuntelijat.SekoittajaNapinKuuntelija;
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
        
        NappaintenKuuntelija nk = new NappaintenKuuntelija(peli.getLaatanSiirtaja());
        HiirenKuuntelija hk = new HiirenKuuntelija(peli.getLaatanSiirtaja());
        SekoittajaNapinKuuntelija sk = new SekoittajaNapinKuuntelija(peli);
        RatkaisijaNapinKuuntelija rk = new RatkaisijaNapinKuuntelija(peli);
        Kayttoliittyma k = new Kayttoliittyma(p, rk, sk, hk, nk);
        k.run();

        peli.pelaa();
    }

}
