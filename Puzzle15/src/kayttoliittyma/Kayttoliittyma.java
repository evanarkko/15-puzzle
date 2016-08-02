/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 *
 * @author eamiller
 */
public class Kayttoliittyma implements Runnable{
    private JFrame frame;
    private JPanel piirtoalusta;

    public Kayttoliittyma(JPanel piirtoalusta) {
        this.frame = new JFrame("Puzzle");
        this.piirtoalusta = piirtoalusta;
    }
    
    @Override
    public void run() {
        frame.setPreferredSize(new Dimension(700, 700));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container){
        container.add(piirtoalusta);
    }
    
}
