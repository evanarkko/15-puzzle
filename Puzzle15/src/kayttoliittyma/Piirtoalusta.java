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
        lauta.luo(g);
        for (Laatta l : lauta.getLaatatYhtenaListana()) {
            l.luo(g);
//            System.out.println(l);
        }
        g.setColor(Color.red);
        g.drawString("MOVES: " + String.valueOf(moves), 10, 25);
        if (pelikaynnis) {
            moves++;
        }
    }

    public void setPelikaynnis(boolean pelikaynnis) {
        this.pelikaynnis = pelikaynnis;
    }

}
