/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuuntelijat;

import Pelilogiikka.LaatanSiirtaja;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import pelilauta.Koordinaatit;
import pelilauta.KoordinaattiMuuntaja;

/**
 *
 * @author eamiller
 */
public class HiirenKuuntelija implements MouseListener{
    KoordinaattiMuuntaja km = new KoordinaattiMuuntaja();
    private LaatanSiirtaja ls;

    public HiirenKuuntelija(LaatanSiirtaja ls) {
        this.ls = ls;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
//        System.out.println("pressed: ");
//        System.out.println(km.trueToGame(new Koordinaatit(e.getX(), e.getY())));
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("pressed: ");
        System.out.println(km.trueToGame(new Koordinaatit(e.getX(), e.getY())));
        ls.lisaaLahto(km.trueToGame(new Koordinaatit(e.getX(), e.getY())));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("released: ");
        System.out.println(km.trueToGame(new Koordinaatit(e.getX(), e.getY())));
        ls.lisaaSuunta(km.trueToGame(new Koordinaatit(e.getX(), e.getY())));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
