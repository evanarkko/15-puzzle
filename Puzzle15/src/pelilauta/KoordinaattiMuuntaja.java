
package pelilauta;

import pelilauta.Koordinaatit;

/**
 * Olio, joka muuntaa piirtoalustan koordinaatit pelilaudan koordinaateiksi
 * ja päinvastoin.
 * @author eamiller
 */
public class KoordinaattiMuuntaja {
    private final int laatanKoko;
    private final int laudanMarginaali;

    public KoordinaattiMuuntaja() {
        this.laatanKoko = 60;
        this.laudanMarginaali = 50;
    }
    
    /**
     * Muuttaa laudan pelikoordinaatit piirtoalustan todellisiksi koordinaateiksi.
     * Metodi ei ole tällä hetkellä käytössä mutta implementoitu nyt kuitenkin lähinnä
     * varmuuden ja tasapainon vuoksi
     * @param k
     * @return todelliset koordinaatit
     */
    public Koordinaatit gameToTrue(Koordinaatit k){
        int x = k.x();
        int y = k.y();
        
        int truex = this.laudanMarginaali + x*laatanKoko;
        int truey = this.laudanMarginaali + x*laatanKoko;
        
        Koordinaatit palauta = new Koordinaatit(truex, truey);
        return palauta;
    }
    
    
    /**
     * Muuttaa piirtoalusta (JPanel) todelliset koordinaatit peliruudukon
     * koordinaateiksi. Tärkeä apumetodi hiirenkuuntelija kannalta.
     * Olettaa, että pelilaudan marg-arvo (marginaali) on 50
     * ja koko (laattojen koot) 60 (Kys. metodin testit olettavat näin myös)
     * @param k todelliset koordinaatit
     * @return pelikoordinaatit
     */
    public Koordinaatit trueToGame(Koordinaatit k){
        int x = k.x();
        int y = k.y();
        
        int gameX = -1;
        int gameY = -1;
        
        if(50 <= x && x <= 110){
            gameX = 0;
        }else if(110 <= x && x <= 170){
            gameX = 1;
        }else if(170 <= x && x <= 230){
            gameX = 2;
        }else if(230 <= x && x <= 290){
            gameX = 3;
        }
        
        if(50 <= y && y <= 110){
            gameY = 0;
        }else if(110 <= y && y <= 170){
            gameY = 1;
        }else if(170 <= y && y <= 230){
            gameY = 2;
        }else if(230 <= y && y <= 290){
            gameY = 3;
        }
        
        return new Koordinaatit(gameX, gameY);
    }
    
}
