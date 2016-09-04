/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Pelilogiikka.Peli;

/**
 *
 * @author eamiller
 */
public class SekoittajaNapinKuuntelija implements ActionListener{
    private Peli p;

    public SekoittajaNapinKuuntelija(Peli p) {
        this.p = p;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("sekokuuntelija toimii");
        p.lopetaRatkaiseminen();
        p.setSekoitusMode(true);
        p.resetMoves();
    }
    
}
