package Pelilogiikka;

import kayttoliittyma.Piirtoalusta;
import pelilauta.Lauta;
import ratkaisija.Ratkaisija;

/**
 * Sisältää peliloopin
 *
 * @author eamiller
 */
public class Peli {
    private Lauta lauta;
    private LaatanSiirtaja laatanSiirtaja;
    private Piirtoalusta piirtoalusta;
    private Ratkaisija ratkaisija;
    private boolean ratkaisuMode;
    private boolean sekoitusMode;
    private int sekoituksia;
    private int repaintTauko = 50;

    public Peli(Lauta lauta, Piirtoalusta p) {
        this.lauta = lauta;
        this.laatanSiirtaja = new LaatanSiirtaja(lauta);
        this.piirtoalusta = p;
        this.ratkaisija = new Ratkaisija(lauta);
        this.ratkaisuMode = false;
        this.sekoitusMode = false;
        sekoituksia = 0;
    }

    /**
     * vie peliä eteenpäin yhden siirron tekoälyn käskyjen mukaan. Ei käytetä
     * jos pelaaja pelaa itse. Metodi varmaankin turha, saatan heivata.
     */
    private void etenePeli() {
        if (ratkaisuMode) {
            repaintTauko = 150;
            ratkaisija.seuraavaSiirto();
            piirtoalusta.incMoves();
            if (lauta.onkoJarjestyksessa()) {
                piirtoalusta.setPeliRatkaistu(true);
                lopetaRatkaiseminen();
            }
        } else if (sekoitusMode) {
            piirtoalusta.setPeliRatkaistu(false);
            repaintTauko = 1;
            lauta.satunnainenSiirto();
            sekoituksia++;
            if (sekoituksia > 250) {
                lopetaSekoittaminen();
            }
        } else if (laatanSiirtaja.isSiirto()){
            laatanSiirtaja.siirto();
            piirtoalusta.incMoves();
            if (lauta.onkoJarjestyksessa()) {
                piirtoalusta.setPeliRatkaistu(true);
            }
        }
    }

    /**
     * Peliloopin sisältävä metodi, jota kutsutaan mainista. Saa animaation
     * aikaan kutsumalla jokaisella iteraatiolla ensin etene-metodia ja sitten
     * repaint-metodia.
     *
     * @throws InterruptedException
     */
    public void pelaa() throws InterruptedException {
        while (true) {
            Thread.sleep(repaintTauko);
            etenePeli();
            piirtoalusta.repaint();
        }
    }

    public void setRatkaisuMode(boolean ratkaisuMode) {
        this.ratkaisuMode = ratkaisuMode;
    }

    public void setSekoitusMode(boolean sekoitusMode) {
        this.sekoitusMode = sekoitusMode;
    }

    public void resetMoves() {
        piirtoalusta.resetMoves();
    }

    public void lopetaRatkaiseminen() {
        ratkaisuMode = false;
        ratkaisija.initialize();
    }

    public void lopetaSekoittaminen() {
        sekoituksia = 0;
        sekoitusMode = false;
    }

    public LaatanSiirtaja getLaatanSiirtaja() {
        return laatanSiirtaja;
    }
    
    
    

}
