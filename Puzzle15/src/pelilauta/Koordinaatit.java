/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelilauta;

/**
 * Tietorakenne, joka hallitsee ja palauttaa jonkin olion xy-koordinaatit
 * @author eamiller
 */
public class Koordinaatit {
    private int x;
    private int y;

    public Koordinaatit(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }
    
    /**
     * Kasvattaa x-koordinaatin arvoa yhdellä
     */
    public void incx(){
        x++;
    }
    /**
     * Kasvattaa y-koordinaatin arvoa yhdellä
     */
    public void incy(){
        y++;
    }
    /**
     * Vähentää x-koordinaatin arvoa yhdellä
     */
    public void decx(){
        x--;
    }
    /**
     * Vähentää y-koordinaatin arvoa yhdellä
     */
    public void decy(){
        y--;
    }
    
    /**
     * Lisää x-koordinaatin arvoa
     * @param maara muutoksen laajuus
     */
    public void incx(int maara){
        x+=maara;
    }
    
    /**
     * Lisää y-koordinaatin arvoa
     * @param maara muutoksen laajuus
     */
    public void incy(int maara){
        y+=maara;
    }
    
    /**
     * Vähentää x-koordinaatin arvoa
     * @param maara muutoksen laajuus
     */
    public void decx(int maara){
        x-=maara;
    }
    
    /**
     * Vähentää y-koordinaatin arvoa
     * @param maara muutoksen laajuus
     */
    public void decy(int maara){
        y-=maara;
    }
   
    /**
     * Katsoo, onko tämä olio syötteenä annetun olin välittömässä läheisyydessä.
     * Esim (1,0) ja (2, 0) ovat vierekkäin. Tärkeä metodi Ratkaisija-luokan 
     * kannalta
     * @param k
     * @return 
     */
    public boolean onkoVieressa(Koordinaatit k){
        if(this.equals(new Koordinaatit(k.x()-1, k.y()))) return true;
        if(this.equals(new Koordinaatit(k.x()+1, k.y()))) return true;
        if(this.equals(new Koordinaatit(k.x(), k.y()-1))) return true;
        if(this.equals(new Koordinaatit(k.x(), k.y()+1))) return true;
        return false;
    }
    
    /**
     * Katsoo, onko tämä olio viistossa syötteestä annetusta oliosta.
     * Esim (1,0) ja (2, 1) ovat viistossa eli niiden laattojen kulmat ovat
     * kosketuksissa. Myös hyvin tärkeä metodi Ratkaisija-luokan kannalta.
     * @param k
     * @return 
     */
    public boolean onkoViistossa(Koordinaatit k){
        if(this.x == k.x()-1 && this.y == k.y()-1) return true; 
        if(this.x == k.x()+1 && this.y == k.y()-1) return true; 
        if(this.x == k.x()-1 && this.y == k.y()+1) return true; 
        if(this.x == k.x()+1 && this.y == k.y()+1) return true; 
        return false;
    }
    @Override
    public boolean equals(Object obj) {
        Koordinaatit k = (Koordinaatit) obj;
        return this.x()==k.x() && this.y()==k.y();
    }
    
    
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    
    
    
    
    
}
