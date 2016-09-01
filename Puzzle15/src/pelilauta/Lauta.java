package pelilauta;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import ratkaisija.Suunta;

/**
 * Pääpeliluokka. Hallinnoi laatat, laudan täytön ja muutokset pelissä.
 * @author eamiller
 */
public class Lauta {
    private final Laatta[][] lauta;
    private final int laattoja;
    private int marg = 120;
    private int koko = 60;
    private Koordinaatit nullSpace;
    private ArrayList<Integer> arvoArray; //Randomia generoimista varten
    
    public Lauta(int size) {
        lauta = new Laatta[size][size];
        laattoja = size * size - 1;
        arvoArray = new ArrayList<>();
        for(int i = 1; i <= laattoja; i++){
            arvoArray.add(i);
        }
        marg = 50;
        koko = 60;
        nullSpace = new Koordinaatit(size - 1, size - 1);
    }
    
    /**
     * Luo ja lisää laatat laudalle satunnaiseen arvojärjestykseen.
     */
    public void lisaaLaatatSekoitettuna() {
        this.lisaaLaatatJarjestykseen();
        this.sekoitaLaatat();
        //sekoita
    }
    
    public void sekoitaLaatat(){//priva?
        for(int i = 0; i < 200; i++){
            this.satunnainenSiirto();
        }
    }
    
    public void satunnainenSiirto(){
        int n;
        boolean uudestaan = true;
        while(uudestaan){
            n = (int) (Math.random() * 4); //n välillä 0-3
            switch (n){
                case 0://siirretään oikealle jos pystyy
                    if(nullSpace.x()>0){
                        siirraOikealle(nullSpace.x()-1, nullSpace.y());
                        uudestaan = false;
                    }
                    break;
                case 1://vasemmalle jos pydee
                    if(nullSpace.x()<lauta.length-1){
                        siirraVasemmalle(nullSpace.x()+1, nullSpace.y());
                        uudestaan = false;
                    }
                    break;
                case 2://Alaz jos mahd.
                    if(nullSpace.y()>0){
                        siirraAlas(nullSpace.x(), nullSpace.y()-1);
                        uudestaan = false;
                    }
                    break;
                case 3://ehk ylos
                    if(nullSpace.y()<lauta.length-1){
                        siirraYlos(nullSpace.x(), nullSpace.y()+1);
                        uudestaan = false;
                    }
                    break;
            }
        }
    }
    
    public void lisaaLaatat(int[] arvot){
        int aloitusx = marg;
        int aloitusy = marg;
        int apuLaskuri = 0;
        
        for (int i = 0; i < lauta.length; i++) {
            for (int a = 0; a < lauta[0].length; a++) {
                if (apuLaskuri < laattoja) {
                    int arvo = arvot[(lauta.length*i) + a];
                    
                    Laatta uusiLaatta = new Laatta(arvo, a, i);
                    uusiLaatta.setTrueKoordinaatit(aloitusx, aloitusy);
                    lauta[i][a] = uusiLaatta;
                    apuLaskuri++;
                    aloitusx += koko;
                }
            }
            aloitusy += koko;
            aloitusx = marg;
        }
    }

    @Override
    public String toString() {
        return lauta.length + "x" + lauta[0].length + ", laattoja: "
                + laattoja; //To change body of generated methods, choose Tools | Templates.
    }

    public Laatta[][] getLauta() {
        return lauta;
    }
    
    /**
     * Piirtää this.koko*this.koko -kokosien ruudukon.
     * @param g Grafiikkaolio
     */
    public void luo(Graphics g){
        g.setColor(Color.black);
        for(int i = 0; i < lauta.length + 1; i++){
            g.drawLine((i * koko) + marg, marg, (i * koko) + marg, (lauta.length*koko) + marg);
        }
        for(int i = 0; i < lauta.length + 1; i++){
            g.drawLine(marg, (i * koko) + marg, (lauta.length*koko)+marg, (i * koko) + marg);
        }
    }

    public int getLaattoja() {
        return laattoja;
    }
    
    /**
     * Luo ja lisää laatat laudalle arvojärjestykseen. 
     */
    public void lisaaLaatatJarjestykseen() {
        int aloitusx = marg;
        int aloitusy = marg;
        int apuLaskuri = 0;
        
        for (int i = 0; i < lauta.length; i++) {
            for (int a = 0; a < lauta[0].length; a++) {
                if (apuLaskuri < laattoja) {
                    
                    Laatta uusiLaatta = new Laatta((lauta.length*i) + a + 1, a, i);
                    uusiLaatta.setTrueKoordinaatit(aloitusx, aloitusy);
                    lauta[i][a] = uusiLaatta;
                    apuLaskuri++;
                    aloitusx += koko;
                }
            }
            aloitusy += koko;
            aloitusx = marg;
        }
    }
    
    /**
     * suorittaa yhden siirron saamiense parametrien perusteella.
     * Metodi saa koordinaatti-olion ja suunnan ja kutsuu näiden 
     * perusteella sopivaa laattaa siirtävää metodia
     * 
     * @param lahto Siirrettavan palikan koordinaatti (lähtökoordinaatti)
     * @param s Siirtosuunta
     */
    public void siirra(Koordinaatit lahto, Suunta s){
        switch(s){
            case ALAS:
                siirraAlas(lahto.x(), lahto.y());
                break;
            case YLOS:
                siirraYlos(lahto.x(), lahto.y());
                break;
            case VASEN:
                siirraVasemmalle(lahto.x(), lahto.y());
                break;
            case OIKEA:
                siirraOikealle(lahto.x(), lahto.y());
                break;
        }
    }
    
    /**
     * Siirtää laattaa lauta-ruudukossa. Mahdollisesti turhia metodeja, mutta
     * nyt tehdään pitkän kaavan kautta.
     * @param x
     * @param y 
     */
    public void siirraOikealle(int x, int y){
        if(nullSpace.x() == x + 1 && nullSpace.y() == y){
            lauta[y][x].siirraOikealle(); //Koordinaatit täällä väärinpäin
            lauta[y][x+1] = lauta[y][x];  //jotta ne voisivat olla oikeinpäin muualla
            lauta[y][x] = null;
            nullSpace.decx();
        }else{
            System.out.println("Siirto paikalta (" + x + ", " + y + ") oikealle on laiton!");
        }
    }
    
    /**
     * Siirtää laattaa lauta-ruudukossa. Mahdollisesti turhia metodeja, mutta
     * nyt tehdään pitkän kaavan kautta.
     * @param x
     * @param y 
     */
    public void siirraVasemmalle(int x, int y){
        if(nullSpace.x() == x - 1 && nullSpace.y() == y){
            lauta[y][x].siirraVasemmalle(); //Koordinaatit täällä väärinpäin
            lauta[y][x-1] = lauta[y][x];  //jotta ne voisivat olla oikeinpäin muualla
            lauta[y][x] = null;
            nullSpace.incx();
        }else{
            System.out.println("Siirto paikalta (" + x + ", " + y + ") vasemmalle on laiton!");
        }
    }
    
    /**
     * Siirtää laattaa lauta-ruudukossa. Mahdollisesti turhia metodeja, mutta
     * nyt tehdään pitkän kaavan kautta.
     * @param x
     * @param y 
     */
    public void siirraAlas(int x, int y){
        if(nullSpace.x() == x && nullSpace.y() == y + 1){
            lauta[y][x].siirraAlas();//Koordinaatit täällä väärinpäin
            lauta[y+1][x] = lauta[y][x];  //jotta ne voisivat olla oikeinpäin muualla
            lauta[y][x] = null;
            nullSpace.decy();
        }else{
            System.out.println("Siirto paikalta (" + x + ", " + y + ") alas on laiton!");
        }
    }
    
    /**
     * Siirtää laattaa lauta-ruudukossa. Mahdollisesti turhia metodeja, mutta
     * nyt tehdään pitkän kaavan kautta.
     * @param x
     * @param y 
     */
    public void siirraYlos(int x, int y){
        if(nullSpace.x() == x && nullSpace.y() == y - 1){
            lauta[y][x].siirraYlos();//Koordinaatit täällä väärinpäin
            lauta[y-1][x] = lauta[y][x];  //jotta ne voisivat olla oikeinpäin muualla
            lauta[y][x] = null;
            nullSpace.incy();
        }else{
            System.out.println("Siirto paikalta (" + x + ", " + y + ") ylös on laiton!");
        }
    }
    
    /**
     * Palauttaa laatta-ruudukon jäsenent yksiuloitteisena listana.
     * ISO apu järjestyksen tarkistamisessa.
     * @return Laatta[] lista kaikista laatoista tämänhetkisessä järjestyksessä.
     */
    public Laatta[] getLaatatYhtenaListana() { //Kokeillaanpa jos tämä shaiba toimii
        int i = 0;
        Laatta[] laatat = new Laatta[this.getLaattoja()];

        for (Laatta[] laattaLista : this.getLauta()) {
            for (Laatta l : laattaLista) {
                if (l != null) {
                    laatat[i] = l;
                    i++;
                }
            }
        }
        return laatat;
    }
    
    /**
     * Tarkistaa laattojen järjestyksen oikeellisuuden.
     * @return true tai false, riippuen ovatko laatat nousevassa järjestyksessä.
     */
    public boolean onkoJarjestyksessa(){
        Laatta[] kaikkiLaatat = this.getLaatatYhtenaListana();
        int current = kaikkiLaatat[0].getArvo();
        int next;
        for(int i = 1; i < kaikkiLaatat.length; i++){
            next = kaikkiLaatat[i].getArvo();
            if(next != current + 1) return false;
            current = kaikkiLaatat[i].getArvo();
        }
        return true;
    }
    
    /**
     * Tarkistaa laatttojen järjestyksen halutula rivillä
     * @param riviNro rivin indeksi alkaa nollasta (0 vastaa ekaa riviä)
     * @return 
     */
    public boolean onkoRiviJarjestyksessa(int riviNro){
        if(lauta[riviNro][0] == null)return false;//aika kömpelö/typerä whatchu gonna do?
        if(lauta[riviNro][0].getArvo() != riviNro*4+1)return false;
//        if(riviNro > lauta.length)System.out.println("liian suuri rivinro");
        Laatta[] rivi = lauta[riviNro];
        if(riviNro == lauta.length-1){//Erikoistapaus jos tarkistetaan viimeistä riviä
            //Ehkä erillinen metodi tätä varten???
        }
        
        for(Laatta l : rivi){
            if(l == null) return false;
        }
        
        int current = rivi[0].getArvo();
        int next;
        for(int i = 1; i < rivi.length; i++){
            next = rivi[i].getArvo();
            if(next != current + 1) return false;
            current = rivi[i].getArvo();
        }
        return true;
    }
    
    /**
     * palauttaa tyhjän paikan koordinaatit
     * @return 
     */
    public Koordinaatit getNullSpace() {
        return nullSpace;
    }
    
    /**
     * Palauttaa pelilaudan koordinaatit halutulle laatalle. 
     * @param arvo kyseessä olevan laatan arvo
     * @return 
     */
    public Koordinaatit laatanKoordinaatit(int arvo){
        if(arvo > laattoja){
            System.out.println("haettavan laatan arvo liian iso!");
            return null;
        }
        Laatta etsittavaLaatta = null;
        Laatta[] kaikkiLaatat = this.getLaatatYhtenaListana();
        for(Laatta l : kaikkiLaatat){
            if(l.getArvo() == arvo){
                etsittavaLaatta = l;
                break;
            }
        }
        return etsittavaLaatta.getPelikoordinaatit();
    }
    
    public int laatanArvo(int x, int y){
        if(lauta[y][x] == null)return 0;
        return lauta[y][x].getArvo();
    }

}
