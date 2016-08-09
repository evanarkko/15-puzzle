/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelilauta;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * Luokka, joka hallinnoi laattoja
 * @author eamiller
 */
public class Laatta {
    private final int arvo;
    private Koordinaatit pelikoordinaatit;
    private Koordinaatit trueKoordinaatit;
    private int koko;

    public Laatta(int arvo, int x, int y) {
        this.arvo = arvo;
        pelikoordinaatit = new Koordinaatit(x, y);
        trueKoordinaatit = new Koordinaatit(0, 0);
        koko = 60;
    }

    public int getArvo() {
        return arvo;
    }
    
    public void setPelikoordinaatit(int x, int y){
        this.pelikoordinaatit = new Koordinaatit(x, y);
    }

    public void setTrueKoordinaatit(int x, int y) {
        this.trueKoordinaatit = new Koordinaatit(x, y);
    }
    
    /**
     * piirtää laatan Swing-metodeilla
     * @param g Grafiikkaolio
     */
    public void luo(Graphics g){ 
        g.setColor(Color.red);
        g.fillRoundRect(trueKoordinaatit.x(), trueKoordinaatit.y(), koko, koko, 20, 20);
        
        g.setColor(Color.yellow);
        g.drawRoundRect(trueKoordinaatit.x(), trueKoordinaatit.y(), koko, koko, 20, 20);
        
        g.setColor(Color.pink);
        g.setFont(new Font("TimesRoman", Font.BOLD, 25));
        g.drawString(String.valueOf(arvo), trueKoordinaatit.x()+10, trueKoordinaatit.y()+35);
    }

    @Override
    public String toString() {
        return "Laatta, arvo: " + arvo + ", co: (" + pelikoordinaatit.x()
                + ", " + pelikoordinaatit.y() + ")"; //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Siirtää laatta-oliota oikealle sekä piirtoalustalla, että peliludalla
     */
    public void siirraOikealle(){
        this.pelikoordinaatit.incx();
        this.trueKoordinaatit.incx(koko);
    }
    /**
     * Siirtää laatta-oliota vasemmalle sekä piirtoalustalla, että peliludalla
     */
    public void siirraVasemmalle(){
        this.pelikoordinaatit.decx();
        this.trueKoordinaatit.decx(koko);
    }
    /**
     * Siirtää laatta-oliota alas sekä piirtoalustalla, että peliludalla
     */
    public void siirraAlas(){
        this.pelikoordinaatit.incy();
        this.trueKoordinaatit.incy(koko);
    }
    /**
     * Siirtää laatta-oliota ylös sekä piirtoalustalla, että peliludalla
     */
    public void siirraYlos(){
        this.pelikoordinaatit.decy();
        this.trueKoordinaatit.decy(koko);
    }

    public Koordinaatit getPelikoordinaatit() {
        return pelikoordinaatit;
    }
    
    
    
}