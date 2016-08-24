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
    private ArrayList<Integer> alaKoske;//AVUKSI JOTTA PAKKA EI SEKOITU (?)
    private boolean nullinKierto; // FALSE JOS TOIMITAAN NORMISTI, TRUE, JOS MUUTOS 
    private Suunta nullinKiertoSuunta;//VASEN (myötäp.) tai OIKEA (vastap.)
    private boolean muodostelma;//Kertoo pitääkö tehdä erikoiskikkailut
    private boolean muodostelma2;
    private boolean muodostelma3;
    private boolean loppusilaus;
    private int loppuPyörittelyCounter;

    public Ratkaisija(Lauta lauta) {
        this.lauta = lauta;
        this.alaKoske = new ArrayList<>();
        this.nullinKierto = false;
        this.nullinKiertoSuunta = Suunta.VASEN;
        this.muodostelma = false;
        this.muodostelma2 = false;
        this.muodostelma3 = false;
        this.loppusilaus = false;
        this.loppuPyörittelyCounter = 0;
    }

    /**
     * Siirtää yhtä laattaa ja siis lähenee pelin ratkaisua yhdellä siirrolla
     */
    public void seuraavaSiirto() {
        if (!lauta.onkoRiviJarjestyksessa(0)) {
            seuraavaSiirtoEkaRivi();
        } else if(!lauta.onkoRiviJarjestyksessa(1)){
            seuraavaSiirtoTokaRivi();
        }else if(!lauta.onkoJarjestyksessa()){
            seuraavaSiirtoLoput();
        }else{
            System.out.println("mitaihmetta");
        }
    }

    /**
     * Siirtää yhtä laattaa ekan rivin ratkaisemiseksi.
     */
    private void seuraavaSiirtoEkaRivi() {
        if (muodostelma2) {//1234 tokassa muodostelmassa (1:nen 2:sen alla)
            boolean viimeistely = lauta.laatanKoordinaatit(4).equals(new Koordinaatit(3, 0));
            if (!lauta.getNullSpace().equals(new Koordinaatit(3, 0)) && !viimeistely) {
                System.out.println("oikeeta yläkulmaa alas.");
                if (lauta.getNullSpace().x() != 3) {
                    siirraNullSpacea(Suunta.OIKEA);
                } else {
                    siirraNullSpacea(Suunta.YLOS);
                }
            } else if (siirraKohtiPaikkaa(lauta.laatanKoordinaatit(4), new Koordinaatit(3, 0))) {//Oikea yläkulma on tyhjä, joten siirretään eka rivi paikoilleen
                if (siirraKohtiPaikkaa(lauta.laatanKoordinaatit(3), new Koordinaatit(2, 0))) {
                    if (siirraKohtiPaikkaa(lauta.laatanKoordinaatit(2), new Koordinaatit(1, 0))) {
                        siirraKohtiPaikkaa(lauta.laatanKoordinaatit(1), new Koordinaatit(0, 0));
                        if (lauta.laatanKoordinaatit(1).equals(new Koordinaatit(0, 0))) {
                            muodostelma2 = false;//nyt molemmat muodostelmat falsessa tokaa riviä varten
                        }
                    }
                }
            }
        } else {
            if (muodostelma) {//1,2,3,4 ekassa muodostelmassa, siirretään tokaan muodostelmaan
                if (lauta.getNullSpace().equals(new Koordinaatit(3, 1))) {
                    siirraNullSpacea(Suunta.ALAS);
                } else if (siirraKohtiPaikkaa(lauta.laatanKoordinaatit(1), new Koordinaatit(0, 1))) {
                    if (siirraKohtiPaikkaa(lauta.laatanKoordinaatit(2), new Koordinaatit(0, 0))) {
                        if (siirraKohtiPaikkaa(lauta.laatanKoordinaatit(3), new Koordinaatit(1, 0))) {
                            if (siirraKohtiPaikkaa(lauta.laatanKoordinaatit(4), new Koordinaatit(2, 0))) {
                                muodostelma2 = true;
                                muodostelma = false;
                            }
                        }
                    }
                }
            } else//kohti ekaa muodostelmaa
            if (!siirraKohtiPaikkaa(lauta.laatanKoordinaatit(1), new Koordinaatit(0, 0))) {
                System.out.println("siirretän ygöst");
            } else if (!siirraKohtiPaikkaa(lauta.laatanKoordinaatit(2), new Koordinaatit(1, 0))) {
                System.out.println("siirrtn kagost");
            } else if (!siirraKohtiPaikkaa(lauta.laatanKoordinaatit(3), new Koordinaatit(2, 0))) {
                System.out.println("siirretntnent kolmst");
            } else if (!siirraKohtiPaikkaa(lauta.laatanKoordinaatit(4), new Koordinaatit(2, 1))) {
                System.out.println("siirmrn nelst");
            } else {
                muodostelma = true;
            }
        }

    }
    
    /**
     * Siirtää yhtä laattaa tokan rivin ratkaisemiseksi.
     */
    private void seuraavaSiirtoTokaRivi(){
        if(muodostelma2){
            boolean viimeistely = lauta.laatanKoordinaatit(8).equals(new Koordinaatit(3, 1));
            if (!lauta.getNullSpace().equals(new Koordinaatit(3, 1)) && !viimeistely) {
                System.out.println("oikeeta yläkulmaa alas.");
                if (lauta.getNullSpace().x() != 3) {
                    siirraNullSpacea(Suunta.OIKEA);
                } else {
                    siirraNullSpacea(Suunta.YLOS);
                }
            } else if (siirraKohtiPaikkaa(lauta.laatanKoordinaatit(8), new Koordinaatit(3, 1))) {//Oikea yläkulma on tyhjä, joten siirretään eka rivi paikoilleen
                if (siirraKohtiPaikkaa(lauta.laatanKoordinaatit(7), new Koordinaatit(2, 1))) {
                    if (siirraKohtiPaikkaa(lauta.laatanKoordinaatit(6), new Koordinaatit(1, 1))) {
                        siirraKohtiPaikkaa(lauta.laatanKoordinaatit(5), new Koordinaatit(0, 1));
                        if (lauta.laatanKoordinaatit(5).equals(new Koordinaatit(0, 1))) {
                            muodostelma2 = false;//nyt molemmat muodostelmat falsessa jotain varten
                        }
                    }
                }
            }
        }else
        if(muodostelma){
            if (lauta.getNullSpace().equals(new Koordinaatit(3, 2))) {
                    siirraNullSpacea(Suunta.ALAS);
                } else if (siirraKohtiPaikkaa(lauta.laatanKoordinaatit(5), new Koordinaatit(0, 2))) {
                    if (siirraKohtiPaikkaa(lauta.laatanKoordinaatit(6), new Koordinaatit(0, 1))) {
                        if (siirraKohtiPaikkaa(lauta.laatanKoordinaatit(7), new Koordinaatit(1, 1))) {
                            if (siirraKohtiPaikkaa(lauta.laatanKoordinaatit(8), new Koordinaatit(2, 1))) {
                                muodostelma2 = true;
                                muodostelma = false;
                            }
                        }
                    }
                }
        }else//kohti kakkosrivin ekaa muodostelmaa
        if (!siirraKohtiPaikkaa(lauta.laatanKoordinaatit(5), new Koordinaatit(0, 1))) {
                System.out.println("siirretän vitost");
            } else if (!siirraKohtiPaikkaa(lauta.laatanKoordinaatit(6), new Koordinaatit(1, 1))) {
                System.out.println("siirrtn kudost");
            } else if (!siirraKohtiPaikkaa(lauta.laatanKoordinaatit(7), new Koordinaatit(2, 1))) {
                System.out.println("siirretntnent sepee");
            } else if (!siirraKohtiPaikkaa(lauta.laatanKoordinaatit(8), new Koordinaatit(2, 2))) {
                System.out.println("siirmrn kaz");
            } else {
                muodostelma = true;
            }
    }
    
    /**
     * Siirtää yhtä laattaa kolmannen rivin ratkaisemiseksi..
     */
    private void seuraavaSiirtoLoput(){
        //Muodostelma2 on truessa kun tänne tullaan ekaa kertaa??
        if(loppusilaus){
            if(siirraKohtiPaikkaa(lauta.laatanKoordinaatit(13), new Koordinaatit(0, 3))){
                if(siirraKohtiPaikkaa(lauta.laatanKoordinaatit(14), new Koordinaatit(1, 3))){
                    siirraKohtiPaikkaa(lauta.laatanKoordinaatit(15), new Koordinaatit(2, 3));
                    siirraKohtiPaikkaa(lauta.laatanKoordinaatit(11), new Koordinaatit(2, 2));
                    siirraKohtiPaikkaa(lauta.laatanKoordinaatit(12), new Koordinaatit(3, 2));
                }                     
            }
            if(siirraKohtiPaikkaa(lauta.laatanKoordinaatit(14), new Koordinaatit(1, 3))){
                siirraKohtiPaikkaa(lauta.laatanKoordinaatit(15), new Koordinaatit(2, 3));
                siirraKohtiPaikkaa(lauta.laatanKoordinaatit(11), new Koordinaatit(2, 2));
                siirraKohtiPaikkaa(lauta.laatanKoordinaatit(12), new Koordinaatit(3, 2));
            }
        }else if(muodostelma3){//ysi alanurkassa, kymppi päällä, kakstoista ja ykstoista symmetriaan toisella puolella
            if(siirraKohtiPaikkaa(lauta.laatanKoordinaatit(12), new Koordinaatit(3, 3))){
                if(siirraKohtiPaikkaa(lauta.laatanKoordinaatit(11), new Koordinaatit(3, 2))){
                    muodostelma2 = false;//11 ja 12 reunassa päällekäin
                }
            }
            
            if(!muodostelma2){
                if(lauta.laatanArvo(1, 3) == 13 && lauta.laatanArvo(2, 3) == 14){//tarkistaa onko valmis vain laittamaan laatat paikoilleen!
                    if(siirraKohtiPaikkaa(lauta.laatanKoordinaatit(15), new Koordinaatit(2, 2))){
                        if(siirraKohtiPaikkaa(lauta.laatanKoordinaatit(10), new Koordinaatit(1, 2))){
                            if(siirraKohtiPaikkaa(lauta.laatanKoordinaatit(9), new Koordinaatit(0, 2))){
                                    loppusilaus = true;
                            }
                        }
                    }
                }else{
                    //13, 14, 15 huonossa järkässä. Pitää pyöritellä
                    loppuPyorittely();
                    loppuPyörittelyCounter++;
                }
            }
        }else
        if(muodostelma2){
            boolean apu = false;
            if(muodostelma){//11 pois tielä
                if(siirraKohtiPaikkaa(lauta.laatanKoordinaatit(11), new Koordinaatit(1, 2))){
                    muodostelma = false;
                }
            }
            if(!muodostelma){//12 paikoilleen väliaikaisesti
                if(siirraKohtiPaikkaa(lauta.laatanKoordinaatit(12), new Koordinaatit(3, 2))){
                    if(siirraKohtiPaikkaa(lauta.laatanKoordinaatit(11), new Koordinaatit(2, 2))){
                        muodostelma3 = true;
                        System.out.println("muodostelma 3 = true");
                    }
                }
            }
        }else if(muodostelma){
            if(siirraKohtiPaikkaa(lauta.laatanKoordinaatit(9), new Koordinaatit(0, 3))){
               if(siirraKohtiPaikkaa(lauta.laatanKoordinaatit(10), new Koordinaatit(0, 2))){
                   muodostelma2 = true;
                   System.out.println("muodostelma 2 = true");
               }
            }
        }else{
                if(!siirraKohtiPaikkaa(lauta.laatanKoordinaatit(9), new Koordinaatit(0, 2))){
                    System.out.println("sirtn ysiä");
            }else if(lauta.laatanArvo(1, 2) != 10){
                    System.out.println("siirretään kybää");
                    siirraKohtiPaikkaa(lauta.laatanKoordinaatit(10), new Koordinaatit(1, 2));
            }else{
                muodostelma = true;
                System.out.println("muodostelma = true");
            }
        } 
        
    }
    
    private void loppuPyorittely(){
        System.out.println("loppupyöritellään");
        Koordinaatit n = lauta.getNullSpace();
        if(n.equals(new Koordinaatit(1, 2))){
            siirraNullSpacea(Suunta.ALAS);
        }else if(n.equals(new Koordinaatit(1, 3))){
            siirraNullSpacea(Suunta.OIKEA);
        }else if(n.equals(new Koordinaatit(2, 2))){
            siirraNullSpacea(Suunta.VASEN);
        }else if(n.equals(new Koordinaatit(2, 3))){
            siirraNullSpacea(Suunta.YLOS);
        }else{
            System.out.println("loppupyörittely kutsuttu vaikka nul ei oikealla alueella");
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
//        nullinKierto = false;
        alaKoske.add(lauta.laatanArvo(siirrettava.x(), siirrettava.y()));//MUTTA MILLOIN POISTETAAN?
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
                    nullinKierto = false;
                    lauta.siirraVasemmalle(k.x(), k.y());
                } else {
                    siirraNullSpacea(k, s);
                    //siirrä nullspacea haluttuun paikkaan
                }
                break;
            case OIKEA:
                nullToivottu.incx();
                if (lauta.getNullSpace().equals(nullToivottu)) {
                    nullinKierto = false;
                    lauta.siirraOikealle(k.x(), k.y());
                } else {
                    siirraNullSpacea(k, s);
                    //siirrä nullspacea haluttuun paikkaan
                }
                break;
            case YLOS:
                nullToivottu.decy();
                if (lauta.getNullSpace().equals(nullToivottu)) {
                    nullinKierto = false;
                    lauta.siirraYlos(k.x(), k.y());
                } else {
                    siirraNullSpacea(k, s);
                    //siirrä nullspacea haluttuun paikkaan
                }
                break;
            case ALAS:
                nullToivottu.incy();
                if (lauta.getNullSpace().equals(nullToivottu)) {
                    nullinKierto = false;
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

        if (nullinKierto) {//jos pitää kiertää, muuten mennään nopeinta reittiä
            kierraNullia(vaista);
            onSiirretty = true;
        } else if (vaista.onkoViistossa(lauta.getNullSpace())) {//Null viistossa. Ei huomioi kiertosuuntaa ja on muutenkin tyhmä
            switch (s) {
                case YLOS://HUOMHUOMHUOM ENSIN TSEKKAAT, MINNE EI OLE MENEMINEN. SITTEN nullinkierto = true; ja return;
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
            System.out.println("onvieresnsoisenfaepin" + lauta.laatanArvo(vaista.x(), vaista.y()));
            onSiirretty = true;
            switch (s) {
                case YLOS:
                    if (nullx != vaista.x()) {//null on sivussa eikä alla
                        if (alaKoske.contains(lauta.laatanArvo(nullx, nully - 1))) {
                            nullinKierto = true;
                            if (nullx < vaista.x()) {
                                nullinKiertoSuunta = Suunta.VASEN;
                            } else {
                                nullinKiertoSuunta = Suunta.OIKEA;
                            }
                            return;
                        }
                        siirraNullSpacea(Suunta.YLOS);
                    } else//null on alla (pitäisi saada ylös)
                    {
                        if (nullx < 3) {
                            siirraNullSpacea(Suunta.OIKEA);//Suositaan oikealta kiertämistä
                        } else {
                            siirraNullSpacea(Suunta.VASEN);
                        }
                    }
                    break;
                case VASEN:
                    if (nully != vaista.y()) {//null päällä tai alla
                        siirraNullSpacea(Suunta.VASEN);
                    } else//null on piilossa oikealla
                    {
                        if (nully > 0) {
                            if (alaKoske.contains(lauta.laatanArvo(nullx, nully - 1))) {
                                nullinKierto = true;
                                if (nullx < vaista.x()) {
                                nullinKiertoSuunta = Suunta.VASEN;
                                } else {
                                nullinKiertoSuunta = Suunta.OIKEA;
                                }
                                return;
                            }
                            siirraNullSpacea(Suunta.YLOS);//Suositaan oikealta kiertämistä
                        } else {
                            siirraNullSpacea(Suunta.ALAS);//HUOM SUUNTAMUUTTUJA HYVÄ OLLA
                        }
                    }
                    break;
                case ALAS:
                    if (nullx != vaista.x()) {//null sivussa eikä päällä
                        siirraNullSpacea(Suunta.ALAS);
                    } else//null on piilossa päällä
                    {
                        if (nullx < 3) {
                            siirraNullSpacea(Suunta.OIKEA);
                        } else {
                            siirraNullSpacea(Suunta.VASEN);
                        }
                    }
                    break;
                case OIKEA:
                    if (nully != vaista.y()) { //null yllä tai alla
                        siirraNullSpacea(Suunta.OIKEA);
                    } else//null vasemmalla
                    {
                        if (nully < 3) {
                            siirraNullSpacea(Suunta.ALAS);
                        } else {
                            siirraNullSpacea(Suunta.YLOS);
                        }
                    }
            }
        }

        if (!onSiirretty) {
            if (nullx < haluttuPaikka.x() && !alaKoske.contains(lauta.laatanArvo(nullx + 1, nully))) {
                siirraNullSpacea(Suunta.OIKEA);
            } else if (nullx > haluttuPaikka.x() && !alaKoske.contains(lauta.laatanArvo(nullx - 1, nully))) {
                siirraNullSpacea(Suunta.VASEN);
            } else if (nully < haluttuPaikka.y()) {
                siirraNullSpacea(Suunta.ALAS);
            } else if (nully > haluttuPaikka.y()) {
                siirraNullSpacea(Suunta.YLOS);
            }
        }

    }

    private void kierraNullia(Koordinaatit kierrettava) {
        int nullx = lauta.getNullSpace().x();
        int nully = lauta.getNullSpace().y();
        if(kierrettava.onkoVieressa(lauta.getNullSpace())){//NULL VIERESSÄ
            if(kierrettava.x() == nullx){//null joko yllä tai alla
                if(kierrettava.y() < nully){//null alla
                    if(nullinKiertoSuunta == Suunta.VASEN){//Myötäpäivään
                        siirraNullSpacea(Suunta.OIKEA);
                    }else{
                        siirraNullSpacea(Suunta.VASEN);
                    }
                }else{//null päällä
                    siirraNullSpacea(nullinKiertoSuunta);
                }
            }else{//null joko vasemmala tai oikealla
                if(kierrettava.x() < nullx){//null oikealla
                    if(nullinKiertoSuunta == Suunta.VASEN){
                        siirraNullSpacea(Suunta.YLOS);
                    }else{
                        siirraNullSpacea(Suunta.ALAS);
                    }
                }else{//null vasemmala
                    if(nullinKiertoSuunta == Suunta.VASEN){
                        siirraNullSpacea(Suunta.ALAS);
                    }else{
                        siirraNullSpacea(Suunta.YLOS);
                    }
                }
            }
        }else if(kierrettava.onkoViistossa(lauta.getNullSpace())){
            if(kierrettava.y() < nully){//null alaviistossa
                if(kierrettava.x() < nullx){//null oikealla alaviistossa
                    if(nullinKiertoSuunta==Suunta.VASEN){
                        siirraNullSpacea(Suunta.YLOS);
                    }else{
                        siirraNullSpacea(Suunta.VASEN);
                    }
                }else{//null on vasemmalla alaviistossa
                    if(nullinKiertoSuunta==Suunta.VASEN){
                        siirraNullSpacea(Suunta.OIKEA);
                    }else{
                        siirraNullSpacea(Suunta.YLOS);
                    }
                }
            }else{//null yläviistossa
                if(kierrettava.x() < nullx){//null oikealla yläviistossa
                    if(nullinKiertoSuunta==Suunta.VASEN){
                        siirraNullSpacea(nullinKiertoSuunta);
                    }else{
                        siirraNullSpacea(Suunta.ALAS);
                    }
                }else{//null vasemmalla yläviistossa
                    if(nullinKiertoSuunta==Suunta.VASEN){
                        siirraNullSpacea(Suunta.ALAS);
                    }else{
                        siirraNullSpacea(Suunta.OIKEA);
                    }
                }
            }
        }else{
            System.out.println("KierraNullia- metodi ei tee mtn!?");
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
