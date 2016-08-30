package kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import pelilauta.*;

/**
 * Jpanel luokan perivä komponentti käyttölittymälle.
 *
 * @author eamiller
 */
public class Piirtoalusta extends JPanel {
    private final Lauta lauta;
    private int moves;
    private boolean pelikaynnis = true;

    public Piirtoalusta(Lauta l) {
        lauta = l;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(0, 0, 350, 400);
        lauta.luo(g);
        for (Laatta l : lauta.getLaatatYhtenaListana()) {
            l.luo(g);
//            System.out.println(l);
        }
        g.setColor(Color.red);
        g.drawString("SIIRTOJA: " + String.valueOf(moves), 10, 25);
        
    }
    
    public void incMoves(){
        this.moves++;
    }
    
    public void resetMoves(){
        this.moves = 0;
    }

    public void setPelikaynnis(boolean pelikaynnis) {
        this.pelikaynnis = pelikaynnis;
    }

}
