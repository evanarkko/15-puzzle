
package main15;

import kayttoliittyma.Piirtoalusta;
import pelilauta.Lauta;

/**
 * Sisältää peliloopin
 * @author eamiller
 */
public class Peli {
    private Lauta lauta;
    private Piirtoalusta piirtoalusta;
    //private tekoäly tko-aly;

    public Peli(Lauta lauta, Piirtoalusta p) {
        this.lauta = lauta;
        this.piirtoalusta = p;
    }
    
    /**
     * vie peliä eteenpäin yhden siirron tekoälyn käskyjen mukaan.
     * Ei käytetä jos pelaaja pelaa itse. Metodi varmaankin turha,
     * saatan heivata.
     */
    private void eteneTkoAly(){
        //Tee asioita
        
    }
    
    /**
     * Peliloopin sisältävä metodi, jota kutsutaan mainista.
     * Saa animaation aikaan kutsumalla jokaisella iteraatiolla
     * ensin etene-metodia ja sitten repaint-metodia.
     * @throws InterruptedException 
     */
    public void pelaa() throws InterruptedException{
        while(true){
            Thread.sleep(1000);
            eteneTkoAly();
            piirtoalusta.repaint();
        }
    }
    
}
