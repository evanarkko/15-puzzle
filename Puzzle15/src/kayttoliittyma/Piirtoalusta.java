
package kayttoliittyma;

import java.awt.Graphics;
import javax.swing.JPanel;
import pelilauta.*;
import pelilogiikka.Puzzle;

/**
 *
 * @author eamiller
 */
public class Piirtoalusta extends JPanel{
    private final Puzzle puzzle;

    public Piirtoalusta(Puzzle p){
        puzzle = p;
    }

    @Override
    protected void paintComponent(Graphics g) {
        puzzle.getLauta().luo(g);
        for(Laatta l : puzzle.getLaatat()){
            l.luo(g);
//            System.out.println(l);
        }
    }
    
    
    
}
