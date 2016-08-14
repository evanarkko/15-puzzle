
package pelilauta;

import pelilauta.Koordinaatit;

/**
 * Olio, joka muuntaa piirtoalustan koordinaatit pelilaudan koordinaateiksi
 * ja päinvastoin.
 * @author eamiller
 */
public class KoordinaattiMuuntaja {
    private final int laudanKoko;
    private final int laudanMarginaali;

    public KoordinaattiMuuntaja(int koko, int marginaali) {
        this.laudanKoko = koko;
        this.laudanMarginaali = marginaali;
    }
    
    public Koordinaatit gameToTrue(Koordinaatit k){
        int x = k.x();
        int y = k.y();
        
        int truex = this.laudanMarginaali + x*laudanKoko;
        int truey = this.laudanMarginaali + x*laudanKoko;
        
        Koordinaatit palauta = new Koordinaatit(truex, truey);
        return palauta;
    }
    
    public Koordinaatit trueToGame(){
        return null;
    }
    
}
