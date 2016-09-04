/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import kuuntelijat.HiirenKuuntelija;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import javax.swing.*;
import kuuntelijat.NappaintenKuuntelija;

/**
 * run()-metodin toteuttama käyttöliittymä pelaajaa varten
 * @author eamiller
 */
public class Kayttoliittyma implements Runnable{
    private JFrame frame;
    private JPanel piirtoalusta;
    private ActionListener rKuuntelija;
    private ActionListener sKuuntelija;
    private HiirenKuuntelija hKuuntelija;
    private KeyListener nKuuntelija;

    public Kayttoliittyma(JPanel piirtoalusta, ActionListener rKuuntelija,
            ActionListener sKuuntelija, HiirenKuuntelija hk, NappaintenKuuntelija nk) {
        this.frame = new JFrame("Puzzle");
        this.piirtoalusta = piirtoalusta;
        this.rKuuntelija = rKuuntelija;
        this.sKuuntelija = sKuuntelija;
        this.hKuuntelija = hk;
        this.nKuuntelija = nk;
    }
    
    @Override
    public void run() {
        frame.setPreferredSize(new Dimension(350, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        frame.addKeyListener(nKuuntelija);
    }
    
    private void luoKomponentit(Container container){
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(piirtoalusta);
        
        JButton sekoitaNappi = new JButton("SHUFFLE");
        sekoitaNappi.addActionListener(sKuuntelija);
        JButton ratkaiseNappi = new JButton("SOLVE");
        ratkaiseNappi.addActionListener(rKuuntelija);
        
        piirtoalusta.addMouseListener(hKuuntelija);
        
//        piirtoalusta.addKeyListener(nKuuntelija);
        
        
        container.add(sekoitaNappi);
        container.add(ratkaiseNappi);
    }
    
}
