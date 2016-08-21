
package main15;

import kayttoliittyma.Piirtoalusta;
import pelilauta.Lauta;
import ratkaisija.Ratkaisija;

/**
 * Sisältää peliloopin
 * @author eamiller
 */
public class Peli {
    private Lauta lauta;
    private Piirtoalusta piirtoalusta;
    private Ratkaisija ratkaisija;
    //private tekoäly tko-aly;

    public Peli(Lauta lauta, Piirtoalusta p) {
        this.lauta = lauta;
        this.piirtoalusta = p;
        this.ratkaisija = new Ratkaisija(lauta);
    }
    
    /**
     * vie peliä eteenpäin yhden siirron tekoälyn käskyjen mukaan.
     * Ei käytetä jos pelaaja pelaa itse. Metodi varmaankin turha,
     * saatan heivata.
     */
    private void eteneTkoAly(){
        ratkaisija.seuraavaSiirto();
    }
    
    /**
     * Peliloopin sisältävä metodi, jota kutsutaan mainista.
     * Saa animaation aikaan kutsumalla jokaisella iteraatiolla
     * ensin etene-metodia ja sitten repaint-metodia.
     * @throws InterruptedException 
     */
    public void pelaa() throws InterruptedException{
        while(true){
            Thread.sleep(200);
            
            eteneTkoAly();
            piirtoalusta.repaint();
        }
    }
    
}
