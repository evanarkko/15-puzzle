package pelilauta;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
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

    public void lisaaLaatat() {
        int aloitusx = marg;
        int aloitusy = marg;
        int apuLaskuri = 0;
        
        for (int i = 0; i < lauta.length; i++) {
            for (int a = 0; a < lauta[0].length; a++) {
                if (apuLaskuri < laattoja) {
                    int arvo = arvoArray.remove((int) (Math.random()*arvoArray.size()));
                    
                    Laatta uusiLaatta = new Laatta(arvo, 0, 0);
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
    
    public void lisaaLaatatJarjestykseen() {
        int aloitusx = marg;
        int aloitusy = marg;
        int apuLaskuri = 0;
        
        for (int i = 0; i < lauta.length; i++) {
            for (int a = 0; a < lauta[0].length; a++) {
                if (apuLaskuri < laattoja) {
                    
                    Laatta uusiLaatta = new Laatta((lauta.length*i) + a + 1, 0, 0);
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
    

}
