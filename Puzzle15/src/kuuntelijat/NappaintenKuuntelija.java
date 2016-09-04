/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuuntelijat;

import Pelilogiikka.LaatanSiirtaja;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import ratkaisija.Suunta;

/**
 * Ei tee mitään vielä
 * @author eamiller
 */
public class NappaintenKuuntelija implements KeyListener{
    private LaatanSiirtaja ls;

    public NappaintenKuuntelija(LaatanSiirtaja ls) {
        this.ls = ls;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("moi");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("moi");
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                ls.lisaaSiirto(Suunta.YLOS);
                break;
            case KeyEvent.VK_RIGHT:
                ls.lisaaSiirto(Suunta.OIKEA);
                break;
            case KeyEvent.VK_DOWN:
                ls.lisaaSiirto(Suunta.ALAS);
                break;
            case KeyEvent.VK_LEFT:
                ls.lisaaSiirto(Suunta.VASEN);
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
