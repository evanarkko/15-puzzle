/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main15.Peli;

/**
 *
 * @author eamiller
 */
public class RatkaisijaKuuntelija implements ActionListener{
    private Peli p;

    public RatkaisijaKuuntelija(Peli p) {
        this.p = p;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        p.lopetaSekoittaminen();
        p.setRatkaisuMode(true);
    }
    
}
