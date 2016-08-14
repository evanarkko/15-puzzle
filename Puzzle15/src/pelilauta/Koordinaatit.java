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
     * Kasvattaa-koordinaatin arvoa yhdellä
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
     * equals-metodi
     * @param k verrattavat koordinaait
     * @return palauttaa true jos samat koordinaatit, muuten false
     */
    public boolean equals(Koordinaatit k) {
        return this.x()==k.x() && this.y()==k.y(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    
    
    
    
    
}
