/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

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

    public HiirenKuuntelija() {
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(new Koordinaatit(e.getX(), e.getY()));
        System.out.println(km.trueToGame(new Koordinaatit(e.getX(), e.getY())));
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
