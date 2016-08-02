/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelilauta;

/**
 *
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
    
    public void incx(){
        x++;
    }
    public void incy(){
        y++;
    }
    public void decx(){
        x--;
    }
    public void decy(){
        y--;
    }
    public void incx(int maara){
        x+=maara;
    }
    public void incy(int maara){
        y+=maara;
    }
    public void decx(int maara){
        x-=maara;
    }
    public void decy(int maara){
        y-=maara;
    }
    

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    
    
    
    
    
}
