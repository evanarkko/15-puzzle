package ratkaisija;

import java.util.ArrayList;
import pelilauta.*;
import ratkaisija.*;

/**
 * Pelin ratkaiseva tekoäly
 *
 * @author eamiller
 */
public class Ratkaisija {
    private Lauta lauta;
//    private ArrayList<Koordinaatit> alaSiirra; AVUKSI JOTTA PAKKA EI SEKOITU (?)

    public Ratkaisija(Lauta lauta) {
        this.lauta = lauta;
    }
    
    /**
     * Siirtää yhtä laattaa ja siis lähenee pelin ratkaisua yhdellä siirrolla
     */
    public void seuraavaSiirto() {
        if (!lauta.onkoRiviJarjestyksessa(0)) {
            seuraavaSiirtoEkaRivi();
        }
    }
    
    
    public void seuraavaSiirtoEkaRivi() {
        
    }
    
    /**
     * Tekee siirron tietyn laatan saamiseksi
     * lähemmäs haluttua kohdetta.
     * @param k1 siirrettävän laatan koordinaatit
     * @param k2 kohteen koordinaatit
     * @return palauttaa true jos laatta on jo kohdepaikassa, muulloin false.
     */
    public boolean siirraKohtiPaikkaa(Koordinaatit k1, Koordinaatit k2){
        if(k1.x()!=k2.x()){
            siirraLeveysSuunnassa(k1, k2.x());
            return false;
        }
        if(k1.y()!=k2.y()){
            siirraPystySuunnassa(k1, k2.y());
            return false;
        }
        return true;
    }
    
    
    public void siirraLeveysSuunnassa(Koordinaatit k1, int x2) {
        if (k1.x() < x2){
            yritaSiirtaaLaattaa(k1, Suunta.OIKEA);
        }
        if (k1.x() > x2){
            yritaSiirtaaLaattaa(k1, Suunta.VASEN);
        }
    }

    public void siirraPystySuunnassa(Koordinaatit k1, int y2) {
        if (k1.y() < y2);//mennään alas
        if (k1.y() > y2);//mennään ylös
    }
    
    private void yritaSiirtaaLaattaa(Koordinaatit k, Suunta s){
        switch(s){
            case VASEN:
                if(lauta.getNullSpace().x() == k.x()-1){
                    lauta.siirraVasemmalle(k.x(), k.y());
                }else{
                    //siirrä nullspacea haluttuun paikkaan
                }
                break;
            case OIKEA:
                if(lauta.getNullSpace().x() == k.x()+1){
                    lauta.siirraOikealle(k.x(), k.y());
                }else{
                    //siirrä nullspacea haluttuun paikkaan
                }
                break;
            case YLOS:
                if(lauta.getNullSpace().y() == k.y()-1){
                    lauta.siirraYlos(k.x(), k.y());
                }else{
                    //siirrä nullspacea haluttuun paikkaan
                }
                break;
            case ALAS:
                if(lauta.getNullSpace().y() == k.y()+1){
                    lauta.siirraAlas(k.x(), k.y());
                }else{
                    //siirrä nullspacea haluttuun paikkaan
                }
                break;
        }
    }
    
    /**
     * Siirtää nullspacea toivottua paikkaa kohti siten, että lopulta 
     * tiettyä laattaa voidaan siirtää haluttuun suuntaan.
     * @param vaistettava Seuraavaksi siirrettävä laatta, joka ei saa siirtyä.
     * @param s Suunta, johon väistettävä laatta halutaan siirtää.
     */
    public void siirraNullSpacea(Koordinaatit vaistettava, Suunta s){
        Koordinaatit haluttuPaikka = maaritaPaikka(vaistettava, s); //Määritetään nullspacen haluttu paikka
        
        if(lauta.getNullSpace().x()<haluttuPaikka.x()){
            siirraNullSpacea(Suunta.VASEN);
        }else if(lauta.getNullSpace().x()>haluttuPaikka.x()){
            siirraNullSpacea(Suunta.VASEN);
        }else if(lauta.getNullSpace().y()< haluttuPaikka.y()){
            siirraNullSpacea(Suunta.ALAS);
        }else if(lauta.getNullSpace().y()>haluttuPaikka.y()){
            siirraNullSpacea(Suunta.YLOS);
        }
    }
    
    /**
     * Siirtää nullspacea haluttuun suuntaan.
     * @param s haluttu suunta
     */
    public void siirraNullSpacea(Suunta s) {
        int x = lauta.getNullSpace().x();
        int y = lauta.getNullSpace().y();
        try {
            switch (s) {
                case OIKEA:
                    lauta.siirraVasemmalle(x + 1, y);
                    break;
                case VASEN:
                    lauta.siirraOikealle(x - 1, y);
                    break;
                case YLOS:
                    lauta.siirraAlas(x, y - 1);
                    break;
                case ALAS:
                    lauta.siirraYlos(x, y + 1);
                    break;
            }
        } catch (Exception e) {
            System.out.println("Nullpointer nullSpacea siirtäessä");
        }

    }
    
    private Koordinaatit maaritaPaikka(Koordinaatit minkaVieressa, Suunta s){
        Koordinaatit maarita = null;//nullspacen haluttu paikka
        if(null!=s)switch (s) {
            case OIKEA:
                maarita = new Koordinaatit(minkaVieressa.x()+1, minkaVieressa.y());
                break;
            case VASEN:
                maarita = new Koordinaatit(minkaVieressa.x()-1, minkaVieressa.y());
                break;
            case YLOS:
                maarita = new Koordinaatit(minkaVieressa.x(), minkaVieressa.y()-1);
                break;
            case ALAS:
                maarita = new Koordinaatit(minkaVieressa.x(), minkaVieressa.y()+1);
                break;
            default:
                break;
        }
        return maarita;
    }

}
