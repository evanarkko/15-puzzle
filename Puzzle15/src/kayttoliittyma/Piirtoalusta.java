
package kayttoliittyma;

import java.awt.Graphics;
import javax.swing.JPanel;
import pelilauta.*;

/**
 *
 * @author eamiller
 */
public class Piirtoalusta extends JPanel{
    private final Lauta lauta;
    
    public Piirtoalusta(Lauta l){
        lauta = l;
    }

    @Override
    protected void paintComponent(Graphics g) {
        lauta.luo(g);
        for(Laatta l : lauta.getLaatatYhtenaListana()){
            l.luo(g);
//            System.out.println(l);
        }
    }
    
    
    
}
