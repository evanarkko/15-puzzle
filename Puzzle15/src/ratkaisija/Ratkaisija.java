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
    private ArrayList<Koordinaatit> alaKoske;//AVUKSI JOTTA PAKKA EI SEKOITU (?)
    private Suunta nullinKiertoSuunta; // SUUNTA, JOTA PITKIN NULLSPACE KIERTÄÄ LAATTAA (TODNÄK. VAIHTELEE)
    private boolean muodostelma;//Kertoo pitääkö tehdä erikoiskikkailut
    private boolean muodostelma2;

    public Ratkaisija(Lauta lauta) {
        this.lauta = lauta;
        this.nullinKiertoSuunta = Suunta.ALAS;
        this.muodostelma = false;
        this.muodostelma2 = false;
    }

    /**
     * Siirtää yhtä laattaa ja siis lähenee pelin ratkaisua yhdellä siirrolla
     */
    public void seuraavaSiirto() {
        if (!lauta.onkoRiviJarjestyksessa(0)) {
            seuraavaSiirtoEkaRivi();
        }else{
            System.out.println("Eka rivi valmis");
        }
    }

    /**
     * Siirtää yhtä laattaa ekan rivin ratkaisemiseksi. Ehkä turha.
     */
    public void seuraavaSiirtoEkaRivi() {
        if (muodostelma2) {//1234 tokassa muodostelmassa (1:nen 2:sen alla)
            boolean viimeistely = lauta.laatanKoordinaatit(4).equals(new Koordinaatit(3, 0));
            if (!lauta.getNullSpace().equals(new Koordinaatit(3, 0)) && !viimeistely) {
                System.out.println("oikeeta yläkulmaa alas.");
                if (lauta.getNullSpace().x() != 3) {
                    siirraNullSpacea(Suunta.OIKEA);
                } else {
                    siirraNullSpacea(Suunta.YLOS);
                }
            }else if (siirraKohtiPaikkaa(lauta.laatanKoordinaatit(4), new Koordinaatit(3, 0))){//Oikea yläkulma on tyhjä, joten siirretään eka rivi paikoilleen
                if(siirraKohtiPaikkaa(lauta.laatanKoordinaatit(3), new Koordinaatit(2, 0))){
                    if(siirraKohtiPaikkaa(lauta.laatanKoordinaatit(2), new Koordinaatit(1, 0))){
                        if(siirraKohtiPaikkaa(lauta.laatanKoordinaatit(1), new Koordinaatit(0, 0))){
                            
                        }
                    }
                }
            }
        }else
        if (muodostelma) {//1,2,3,4 ekassa muodostelmassa
            if (lauta.getNullSpace().equals(new Koordinaatit(3, 1))) {
                siirraNullSpacea(Suunta.ALAS);
            } else if (siirraKohtiPaikkaa(lauta.laatanKoordinaatit(1), new Koordinaatit(0, 1))) {
                if (siirraKohtiPaikkaa(lauta.laatanKoordinaatit(2), new Koordinaatit(0, 0))) {
                    if (siirraKohtiPaikkaa(lauta.laatanKoordinaatit(3), new Koordinaatit(1, 0))) {
                        if (siirraKohtiPaikkaa(lauta.laatanKoordinaatit(4), new Koordinaatit(2, 0))) {
                            muodostelma2 = true;
                        }
                    }
                }
            }
        } else {
            if (!siirraKohtiPaikkaa(lauta.laatanKoordinaatit(1), new Koordinaatit(0, 0))) {
                System.out.println("siirretän ygöst");
//            siirraKohtiPaikkaa(lauta.laatanKoordinaatit(1), new Koordinaatit(0, 0));
            } else if (!siirraKohtiPaikkaa(lauta.laatanKoordinaatit(2), new Koordinaatit(1, 0))) {
                System.out.println("siirrtn kagost");
//            siirraKohtiPaikkaa(lauta.laatanKoordinaatit(2), new Koordinaatit(1,0));
            } else if (!siirraKohtiPaikkaa(lauta.laatanKoordinaatit(3), new Koordinaatit(2, 0))) {
                System.out.println("siirretntnent kolmst");
//            siirraKohtiPaikkaa(lauta.laatanKoordinaatit(3), new Koordinaatit(2, 0));
            } else if (!siirraKohtiPaikkaa(lauta.laatanKoordinaatit(4), new Koordinaatit(2, 1))) {
                System.out.println("siirmrn nelst");
//            siirraKohtiPaikkaa(lauta.laatanKoordinaatit(4), new Koordinaatit(2,1));
            } else {
                muodostelma = true;
            }
        }

    }

    /**
     * Tekee siirron tietyn laatan saamiseksi lähemmäs haluttua kohdetta (jos
     * tarve).
     *
     * @param siirrettava siirrettävän laatan koordinaatit
     * @param kohde kohteen koordinaatit
     * @return palauttaa true jos laatta on jo kohdepaikassa, muulloin false.
     * return statementit pitävät huolen siitä, että metodi ei suorita useata
     * asiaa kerrallaan.
     */
    public boolean siirraKohtiPaikkaa(Koordinaatit siirrettava, Koordinaatit kohde) {
        if (siirrettava.x() < kohde.x()) {
            yritaSiirtaaLaattaa(siirrettava, Suunta.OIKEA);
            return false;
        }
        if (siirrettava.x() > kohde.x()) {
            yritaSiirtaaLaattaa(siirrettava, Suunta.VASEN);
            return false;
        }
        if (siirrettava.y() < kohde.y()) {
            yritaSiirtaaLaattaa(siirrettava, Suunta.ALAS);
            return false;
        }
        if (siirrettava.y() > kohde.y()) {
            yritaSiirtaaLaattaa(siirrettava, Suunta.YLOS);
            return false;
        }
        return true;
    }

    /**
     * Yrittää siirtää laattaa annettuun suuntaan. Jos kyseinen paikka ei ole
     * tyhjä, siirretään nullSpacea (tyhjää tilaa) haluttuun paikkaan päin.
     *
     * @param k Siirrettävän laatan koordinaatit
     * @param s Siirtosuunta
     */
    private void yritaSiirtaaLaattaa(Koordinaatit k, Suunta s) {
        Koordinaatit nullToivottu = new Koordinaatit(k.x(), k.y());
        switch (s) {
            case VASEN:
                nullToivottu.decx();
                if (lauta.getNullSpace().equals(nullToivottu)) {
                    lauta.siirraVasemmalle(k.x(), k.y());
                } else {
                    siirraNullSpacea(k, s);
                    //siirrä nullspacea haluttuun paikkaan
                }
                break;
            case OIKEA:
                nullToivottu.incx();
                if (lauta.getNullSpace().equals(nullToivottu)) {
                    lauta.siirraOikealle(k.x(), k.y());
                } else {
                    siirraNullSpacea(k, s);
                    //siirrä nullspacea haluttuun paikkaan
                }
                break;
            case YLOS:
                nullToivottu.decy();
                if (lauta.getNullSpace().equals(nullToivottu)) {
                    lauta.siirraYlos(k.x(), k.y());
                } else {
                    siirraNullSpacea(k, s);
                    //siirrä nullspacea haluttuun paikkaan
                }
                break;
            case ALAS:
                nullToivottu.incy();
                if (lauta.getNullSpace().equals(nullToivottu)) {
                    lauta.siirraAlas(k.x(), k.y());
                } else {
                    siirraNullSpacea(k, s);
                    //siirrä nullspacea haluttuun paikkaan
                }
                break;
        }
    }

    /**
     * Siirtää nullspacea toivottua paikkaa kohti siten, että lopulta tiettyä
     * laattaa voidaan siirtää haluttuun suuntaan.
     *
     * @param vaista Seuraavaksi siirrettävä laatta, joka ei saa siirtyä.
     * @param s Suunta, johon väistettävä laatta halutaan siirtää.
     */
    public void siirraNullSpacea(Koordinaatit vaista, Suunta s) {
        Koordinaatit haluttuPaikka = maaritaPaikka(vaista, s); //Määritetään nullspacen haluttu paikka
        int nullx = lauta.getNullSpace().x();
        int nully = lauta.getNullSpace().y();
        boolean onSiirretty = false;

        if (vaista.onkoViistossa(lauta.getNullSpace())) {//Ei huomioi kiertosuuntaa ja on muutenkin tyhmä
            switch (s) {
                case YLOS:
                    if (nully > vaista.y()) {//null on alaviistossa
                        siirraNullSpacea(Suunta.YLOS);
                        onSiirretty = true;
                    }
                    break;
                case VASEN:
                    if (nullx > vaista.x()) {//null on oikeaviistossa
                        siirraNullSpacea(Suunta.VASEN);
                        onSiirretty = true;
                    }
                    break;
                case ALAS:
                    if (nully < vaista.y()) {
                        siirraNullSpacea(Suunta.ALAS);
                        onSiirretty = true;
                    }
                    break;
                case OIKEA:
                    if (nullx < vaista.x()) {
                        siirraNullSpacea(Suunta.OIKEA);
                        onSiirretty = true;
                    }
                    break;
            }
        } else if (vaista.onkoVieressa(lauta.getNullSpace())) {//Null vieressä. Aletaan kiertämään 
            onSiirretty = true;
            switch (s) {
                case YLOS:
                    if (nullx != vaista.x()) {//null on sivussa eikä alla
                        siirraNullSpacea(Suunta.YLOS);
                    } else//null on alla (pitäisi saada ylös)
                     if (nullx < 3) {
                            siirraNullSpacea(Suunta.OIKEA);//Suositaan oikealta kiertämistä
                        } else {
                            siirraNullSpacea(Suunta.VASEN);
                        }
                    break;
                case VASEN:
                    if (nully != vaista.y()) {//null päällä tai alla
                        siirraNullSpacea(Suunta.VASEN);
                    } else//null on piilossa oikealla
                     if (nully > 0) {
                            siirraNullSpacea(Suunta.YLOS);//Suositaan oikealta kiertämistä
                        } else {
                            siirraNullSpacea(Suunta.ALAS);//HUOM SUUNTAMUUTTUJA HYVÄ OLLA
                        }
                    break;
                case ALAS:
                    if (nullx != vaista.x()) {//null sivussa eikä päällä
                        siirraNullSpacea(Suunta.ALAS);
                    } else//null on piilossa päällä
                     if (nullx < 3) {
                            siirraNullSpacea(Suunta.OIKEA);
                        } else {
                            siirraNullSpacea(Suunta.VASEN);
                        }
                    break;
                case OIKEA:
                    if (nully != vaista.y()) { //null yllä tai alla
                        siirraNullSpacea(Suunta.OIKEA);
                    } else//null vasemmalla
                     if (nully < 3) {
                            siirraNullSpacea(Suunta.ALAS);
                        } else {
                            siirraNullSpacea(Suunta.YLOS);
                        }
            }
        }

        if (!onSiirretty) {
            if (nullx < haluttuPaikka.x()) {
                siirraNullSpacea(Suunta.OIKEA);
            } else if (nullx > haluttuPaikka.x()) {
                siirraNullSpacea(Suunta.VASEN);
            } else if (nully < haluttuPaikka.y()) {
                siirraNullSpacea(Suunta.ALAS);
            } else if (nully > haluttuPaikka.y()) {
                siirraNullSpacea(Suunta.YLOS);
            }
        }

    }

    /**
     * Siirtää nullspacea haluttuun suuntaan yhden paikan.
     *
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
     * Määrittää koordinaatin, on annetun koordinaatin vieressä annetussa
     * suunnassa. Käytetään nullSpacen siirtämisen apuna. Yksinkertainen, mutta
     * rumannäköinen.
     *
     * @param minkaVieressa Annettu koordinaatti (oletettavasti nullSpace)
     * @param s Annettu suunta
     * @return vieressä oleva koordinaatti
     */
    private Koordinaatit maaritaPaikka(Koordinaatit minkaVieressa, Suunta s) {
        Koordinaatit maarita = null;//nullspacen haluttu paikka
        if (null != s) {
            switch (s) {
                case OIKEA:
                    maarita = new Koordinaatit(minkaVieressa.x() + 1, minkaVieressa.y());
                    break;
                case VASEN:
                    maarita = new Koordinaatit(minkaVieressa.x() - 1, minkaVieressa.y());
                    break;
                case YLOS:
                    maarita = new Koordinaatit(minkaVieressa.x(), minkaVieressa.y() - 1);
                    break;
                case ALAS:
                    maarita = new Koordinaatit(minkaVieressa.x(), minkaVieressa.y() + 1);
                    break;
                default:
                    break;
            }
        }
        return maarita;
    }

}
