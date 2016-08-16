package ratkaisija;

import com.sun.org.apache.bcel.internal.generic.IFEQ;
import java.util.ArrayList;
import pelilauta.*;
import ratkaisija.*;

/**
 * Pelin ratkaiseva tekoäly
 *
 * @author eamiller
 */
public class Ratkaisija {
    private final Lauta lauta;
//    private ArrayList<Koordinaatit> alaKoske; AVUKSI JOTTA PAKKA EI SEKOITU (?)
    private Suunta nullinKiertoSuunta;// SUUNTA, JOTA PITKIN NULLSPACE KIERTÄÄ LAATTAA (TODNÄK. VAIHTELEE)

    public Ratkaisija(Lauta lauta) {
        this.lauta = lauta;
        this.nullinKiertoSuunta = Suunta.ALAS;
    }
    
    /**
     * Siirtää yhtä laattaa ja siis lähenee pelin ratkaisua yhdellä siirrolla
     */
    public void seuraavaSiirto() {
        if (!lauta.onkoRiviJarjestyksessa(0)) {
            seuraavaSiirtoEkaRivi();
        }
    }
    
    /**
     * Siirtää yhtä laattaa ekan rivin ratkaisemiseksi. Ehkä turha.
     */
    public void seuraavaSiirtoEkaRivi() {
        
    }
    
    /**
     * Tekee siirron tietyn laatan saamiseksi
     * lähemmäs haluttua kohdetta (jos tarve).
     * @param k1 siirrettävän laatan koordinaatit
     * @param k2 kohteen koordinaatit
     * @return palauttaa true jos laatta on jo kohdepaikassa, muulloin false.
     * return statementit pitävät huolen siitä, että metodi ei suorita useata asiaa kerrallaan.
     */
    public boolean siirraKohtiPaikkaa(Koordinaatit k1, Koordinaatit k2){
        if(k1.x()<k2.x()){
            yritaSiirtaaLaattaa(k1, Suunta.OIKEA);
            return false;
        }
        if(k1.x()>k2.x()){
            yritaSiirtaaLaattaa(k1, Suunta.VASEN);
            return false;
        }
        if(k1.y()<k2.y()){
            System.out.println("check 1");
            yritaSiirtaaLaattaa(k1, Suunta.ALAS);
            return false;
        }
        if(k1.y()>k2.y()){
            yritaSiirtaaLaattaa(k1, Suunta.YLOS);
            return false;
        }
        return true;
    }
    
    /**
     * Yrittää siirtää laattaa annettuun suuntaan. Jos kyseinen paikka
     * ei ole tyhjä, siirretään nullSpacea (tyhjää tilaa) haluttuun paikkaan päin.
     * @param k Siirrettävän laatan koordinaatit
     * @param s Siirtosuunta
     */
    private void yritaSiirtaaLaattaa(Koordinaatit k, Suunta s){
        Koordinaatit nullToivottu = new Koordinaatit(k.x(), k.y());
        switch(s){
            case VASEN:
                nullToivottu.decx();
                if(lauta.getNullSpace().equals(nullToivottu)){
                    lauta.siirraVasemmalle(k.x(), k.y());
                }else{
                    siirraNullSpacea(k, s);
                    //siirrä nullspacea haluttuun paikkaan
                }
                break;
            case OIKEA:
                nullToivottu.incx();
                if(lauta.getNullSpace().equals(nullToivottu)){
                    lauta.siirraOikealle(k.x(), k.y());
                }else{
                    siirraNullSpacea(k, s);
                    //siirrä nullspacea haluttuun paikkaan
                }
                break;
            case YLOS:
                nullToivottu.decy();
                if(lauta.getNullSpace().equals(nullToivottu)){
                    lauta.siirraYlos(k.x(), k.y());
                }else{
                    siirraNullSpacea(k, s);
                    //siirrä nullspacea haluttuun paikkaan
                }
                break;
            case ALAS:
                nullToivottu.incy();
                if(lauta.getNullSpace().equals(nullToivottu)){
                    System.out.println("check2");
                    lauta.siirraAlas(k.x(), k.y());
                }else{
                    siirraNullSpacea(k, s);
                    //siirrä nullspacea haluttuun paikkaan
                }
                break;
        }
    }
    
    /**
     * Siirtää nullspacea toivottua paikkaa kohti siten, että lopulta 
     * tiettyä laattaa voidaan siirtää haluttuun suuntaan.
     * @param vaista Seuraavaksi siirrettävä laatta, joka ei saa siirtyä.
     * @param s Suunta, johon väistettävä laatta halutaan siirtää.
     */
    public void siirraNullSpacea(Koordinaatit vaista, Suunta s){
        Koordinaatit haluttuPaikka = maaritaPaikka(vaista, s); //Määritetään nullspacen haluttu paikka
        int nullx = lauta.getNullSpace().x();
        int nully = lauta.getNullSpace().y();
        
        if(vaista.onkoVieressa(lauta.getNullSpace())){//Aletaan kiertämään 
            
        }
        
        //TÄSSÄ PRIORISOIDAAN X-SUUNTAAN LIIKKUMISTA, MUTTA KANNATTAAKO TÄMÄ AINA?
        if(nullx<haluttuPaikka.x()){
            siirraNullSpacea(Suunta.OIKEA);
        }else if(nullx>haluttuPaikka.x()){
            siirraNullSpacea(Suunta.VASEN);
        }else if(nully< haluttuPaikka.y()){
            siirraNullSpacea(Suunta.ALAS);
        }else if(nully>haluttuPaikka.y()){
            siirraNullSpacea(Suunta.YLOS);
        }
    }
    
    /**
     * Siirtää nullspacea haluttuun suuntaan yhden paikan.
     * @param s haluttu suunta
     */
    public void siirraNullSpacea(Suunta s) {
        int nullx = lauta.getNullSpace().x();
        int nully = lauta.getNullSpace().y();
        try {
            switch (s) {
                case OIKEA:
                    lauta.siirraVasemmalle(nullx + 1, nully);
                    break;
                case VASEN:
                    lauta.siirraOikealle(nullx - 1, nully);
                    break;
                case YLOS:
                    lauta.siirraAlas(nullx, nully - 1);
                    break;
                case ALAS:
                    lauta.siirraYlos(nullx, nully + 1);
                    break;
            }
        } catch (Exception e) {
            System.out.println("Nullpointer nullSpacea siirtäessä");
        }
    }
    
    /**
     * Määrittää koordinaatin, on annetun koordinaatin vieressä annetussa suunnassa.
     * Käytetään nullSpacen siirtämisen apuna. Yksinkertainen, mutta rumannäköinen.
     * @param minkaVieressa Annettu koordinaatti (oletettavasti nullSpace)
     * @param s Annettu suunta
     * @return vieressä oleva koordinaatti
     */
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
