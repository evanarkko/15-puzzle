package kayttoliittyma;

import java.awt.Color;
import java.awt.Font;
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
    private boolean peliRatkaistu = false;

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
        g.drawString("MOVES: " + String.valueOf(moves), 10, 25);
        
        if(peliRatkaistu){
            g.setColor(Color.white);
            g.setFont(new Font("Lobster Two", Font.PLAIN, 30));
            int x = 195;
            int y1 = 25;
            int y2 = y1 + 15;
            g.drawString("PUZZLE", x, y1);
            g.setColor(Color.green);
            g.drawString("SOLVED", x, y2);
        }
        
    }
    
    public void incMoves(){
        this.moves++;
    }
    
    public void resetMoves(){
        this.moves = 0;
    }

    public void setPeliRatkaistu(boolean peliRatkaistu) {
        this.peliRatkaistu = peliRatkaistu;
    }
    
    

}
